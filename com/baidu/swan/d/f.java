package com.baidu.swan.d;

import android.text.TextUtils;
import android.util.Xml;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes11.dex */
public class f {
    public static String streamToString(InputStream inputStream) {
        return streamToString(inputStream, Xml.Encoding.UTF_8.toString());
    }

    public static String streamToString(InputStream inputStream, String str) {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str), 8192);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                c.closeSafely(inputStream);
            } finally {
                c.closeSafely(inputStream);
            }
        } catch (Exception | OutOfMemoryError e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0051 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    public static boolean streamToFile(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        if (inputStream == null || file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        ?? exists = parentFile.exists();
        if (exists == 0) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            fileOutputStream.flush();
                            c.closeSafely(fileOutputStream);
                            c.closeSafely(inputStream);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    c.closeSafely(fileOutputStream);
                    c.closeSafely(inputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                c.closeSafely(exists);
                c.closeSafely(inputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            exists = 0;
            c.closeSafely(exists);
            c.closeSafely(inputStream);
            throw th;
        }
    }

    public static boolean e(InputStream inputStream, String str) {
        if (inputStream == null || TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        byte[] bArr = new byte[8192];
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String str2 = str + "/" + nextEntry.getName();
                    if (nextEntry.isDirectory()) {
                        File file2 = new File(str2);
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                    } else {
                        File parentFile = new File(str2).getParentFile();
                        if (!parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        if (!parentFile.isDirectory()) {
                            parentFile.delete();
                            parentFile.mkdirs();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(str2);
                        while (true) {
                            try {
                                int read = zipInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            } catch (Throwable th) {
                                c.closeSafely(fileOutputStream);
                                throw th;
                            }
                        }
                        c.closeSafely(fileOutputStream);
                    }
                } else {
                    return true;
                }
            } catch (IOException e) {
                return false;
            } finally {
                c.closeSafely(zipInputStream);
            }
        }
    }
}
