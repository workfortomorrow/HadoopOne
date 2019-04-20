package com.du;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class WriteFile {

	/**
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 写入文件*/
//					Configuration conf=new Configuration();
		//conf.set("fs.defaultFS","http://localhost:9000");
//					conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
//					  因为hadoop-hdfs-2.7.1.jar和hadoop-common-2.7.1.jar
//					  两个包的services目录下都有,org.apache.hadoop.fs.FileSystem这个文件
//					  maven-assembly-plugin(fatjar也是一样的），将hadoop-common.jar中的services内容打进了最终的jar包中，
//					  而hadoop-hdfs.jar包中，services的内容被覆盖了。
		//conf.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS","hdfs://localhost:9000");
		conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
		FileSystem fs;
		try {
			fs = FileSystem.get(conf);

			byte[] buff="HelloWorld!".getBytes();
			String filename="Helltest";
			FSDataOutputStream os= fs.create(new Path(filename));
			os.write(buff, 0, buff.length);
			System.out.println("Create"+filename);
			os.close();
			fs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**判断文件是否存在
		 *

		 String name="Helltest";
		 Configuration conf=new Configuration();
		 conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
		 try {
		 FileSystem fs=FileSystem.get(conf);
		 if(fs.exists(new Path(name))){
		 System.out.println("文件存在！");
		 }else{
		 System.out.println("文件不存在！");
		 }
		 fs.close();
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }	 */

		/**
		 * 读取文件

		 Configuration conf=new Configuration();
		 try {
		 FileSystem fs=FileSystem.get(conf);
		 Path file=new Path("Helltest");
		 FSDataInputStream getIt=fs.open(file);
		 BufferedReader d=new BufferedReader(new InputStreamReader(getIt));
		 System.out.println(d.readLine());
		 d.close();
		 fs.close();
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } */
	}

}
