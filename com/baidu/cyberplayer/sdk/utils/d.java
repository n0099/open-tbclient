package com.baidu.cyberplayer.sdk.utils;

import android.text.TextUtils;
import com.baidu.android.util.io.ZipUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes3.dex */
public class d {
    public static ArrayList<String> a(File file, String str) throws Exception {
        CyberLog.d(ZipUtils.TAG, "zipFilePath:" + file.getAbsolutePath());
        CyberLog.d(ZipUtils.TAG, "saveDirectory:" + str);
        if (file != null) {
            if (file.exists()) {
                if (file.length() <= 524288000) {
                    if (!TextUtils.isEmpty(str)) {
                        File file2 = new File(str);
                        if (file2.exists() && file2.isDirectory()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ZipFile zipFile = new ZipFile(file);
                            Enumeration<? extends ZipEntry> entries = zipFile.entries();
                            byte[] bArr = new byte[1024];
                            while (entries.hasMoreElements()) {
                                ZipEntry nextElement = entries.nextElement();
                                if (!nextElement.getName().contains("../")) {
                                    File file3 = new File(str, nextElement.getName());
                                    if (nextElement.isDirectory()) {
                                        try {
                                            if (!file3.exists()) {
                                                file3.mkdirs();
                                                arrayList.add(str + File.separatorChar + nextElement.getName());
                                            }
                                        } catch (Exception unused) {
                                        }
                                    } else {
                                        try {
                                            if (!file3.getParentFile().exists()) {
                                                file3.mkdirs();
                                            }
                                        } catch (Exception unused2) {
                                        }
                                        arrayList.add(str + File.separator + nextElement.getName());
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("dstFile:");
                                        sb.append(file3.getAbsolutePath());
                                        CyberLog.d(ZipUtils.TAG, sb.toString());
                                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                                        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                        while (true) {
                                            int read = bufferedInputStream.read(bArr, 0, 1024);
                                            if (read == -1) {
                                                break;
                                            }
                                            bufferedOutputStream.write(bArr, 0, read);
                                        }
                                        bufferedInputStream.close();
                                        bufferedOutputStream.close();
                                    }
                                }
                            }
                            zipFile.close();
                            CyberLog.d(ZipUtils.TAG, "unzipFile success");
                            return arrayList;
                        }
                        throw new Exception("directory not exist");
                    }
                    throw new Exception("saveDirectory is null");
                }
                throw new Exception("zip file too large");
            }
            throw new Exception("zip file not exist");
        }
        throw new Exception("zip file is null");
    }

    public static ArrayList<String> b(File file, String str) throws Exception {
        CyberLog.d(ZipUtils.TAG, "zipFilePath:" + file.getAbsolutePath());
        CyberLog.d(ZipUtils.TAG, "saveDirectory:" + str);
        if (file != null) {
            if (file.exists()) {
                if (file.length() <= 524288000) {
                    if (!TextUtils.isEmpty(str)) {
                        File file2 = new File(str);
                        if (file2.exists() && file2.isDirectory()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ZipFile zipFile = new ZipFile(file);
                            Enumeration<? extends ZipEntry> entries = zipFile.entries();
                            byte[] bArr = new byte[1024];
                            while (entries.hasMoreElements()) {
                                ZipEntry nextElement = entries.nextElement();
                                if (!nextElement.getName().contains("../")) {
                                    File file3 = new File(str, nextElement.getName());
                                    if (nextElement.isDirectory()) {
                                        try {
                                            if (!file3.exists()) {
                                                file3.mkdirs();
                                                arrayList.add(nextElement.getName());
                                            }
                                        } catch (Exception unused) {
                                        }
                                    } else {
                                        try {
                                            if (!file3.getParentFile().exists()) {
                                                file3.mkdirs();
                                            }
                                        } catch (Exception unused2) {
                                        }
                                        arrayList.add(nextElement.getName());
                                        CyberLog.d(ZipUtils.TAG, "dstFile:" + file3.getAbsolutePath());
                                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                                        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                        while (true) {
                                            int read = bufferedInputStream.read(bArr, 0, 1024);
                                            if (read == -1) {
                                                break;
                                            }
                                            bufferedOutputStream.write(bArr, 0, read);
                                        }
                                        bufferedInputStream.close();
                                        bufferedOutputStream.close();
                                    }
                                }
                            }
                            zipFile.close();
                            CyberLog.d(ZipUtils.TAG, "unzipFile success");
                            return arrayList;
                        }
                        throw new Exception("directory not exist");
                    }
                    throw new Exception("saveDirectory is null");
                }
                throw new Exception("zip file too large");
            }
            throw new Exception("zip file not exist");
        }
        throw new Exception("zip file is null");
    }
}
