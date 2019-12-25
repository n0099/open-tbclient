package com.baidu.swan.e;

import android.text.TextUtils;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes9.dex */
public class e {
    public static boolean k(com.baidu.swan.a.a.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.filePath)) {
            return false;
        }
        try {
            Enumeration<? extends ZipEntry> entries = new ZipFile(cVar.filePath).entries();
            while (entries.hasMoreElements()) {
                String name = entries.nextElement().getName();
                if (!TextUtils.isEmpty(name) && name.contains(GlobalConstants.LIB_ZEUS_CHROMIUM)) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean unzipFile(String str, String str2) {
        return bZ(str, str2) == null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [137=4] */
    private static Exception bZ(String str, String str2) {
        ZipFile zipFile;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream2;
        ZipFile zipFile2 = null;
        if (str == null) {
            return new Exception("srcFileName is null");
        }
        if (str2 == null) {
            str2 = new File(str).getParent();
        }
        try {
            zipFile = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                bufferedOutputStream = null;
                bufferedInputStream = null;
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry nextElement = entries.nextElement();
                        if (!TextUtils.isEmpty(nextElement.getName()) && !qQ(nextElement.getName())) {
                            File file = new File(str2 + "/" + nextElement.getName());
                            if (!nextElement.isDirectory()) {
                                if (!file.exists()) {
                                    createNewFileSafely(file);
                                }
                                BufferedInputStream bufferedInputStream3 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                try {
                                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(file), 2048);
                                    try {
                                        byte[] bArr = new byte[2048];
                                        while (true) {
                                            int read = bufferedInputStream3.read(bArr, 0, 2048);
                                            if (read == -1) {
                                                break;
                                            }
                                            bufferedOutputStream3.write(bArr, 0, read);
                                        }
                                        closeSafely(bufferedInputStream3);
                                        closeSafely(bufferedOutputStream3);
                                        bufferedOutputStream = bufferedOutputStream3;
                                        bufferedInputStream = bufferedInputStream3;
                                    } catch (IOException e) {
                                        e = e;
                                        zipFile2 = zipFile;
                                        bufferedInputStream2 = bufferedInputStream3;
                                        bufferedOutputStream2 = bufferedOutputStream3;
                                        try {
                                            e.printStackTrace();
                                            closeSafely(bufferedOutputStream2);
                                            closeSafely(bufferedInputStream2);
                                            closeSafely(zipFile2);
                                            return e;
                                        } catch (Throwable th) {
                                            th = th;
                                            bufferedInputStream = bufferedInputStream2;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            zipFile = zipFile2;
                                            closeSafely(bufferedOutputStream);
                                            closeSafely(bufferedInputStream);
                                            closeSafely(zipFile);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedOutputStream = bufferedOutputStream3;
                                        bufferedInputStream = bufferedInputStream3;
                                        closeSafely(bufferedOutputStream);
                                        closeSafely(bufferedInputStream);
                                        closeSafely(zipFile);
                                        throw th;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    zipFile2 = zipFile;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    bufferedInputStream2 = bufferedInputStream3;
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedInputStream = bufferedInputStream3;
                                }
                            } else if (!file.exists()) {
                                file.mkdirs();
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        zipFile2 = zipFile;
                        bufferedOutputStream2 = bufferedOutputStream;
                        bufferedInputStream2 = bufferedInputStream;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                closeSafely(bufferedOutputStream);
                closeSafely(bufferedInputStream);
                closeSafely(zipFile);
                return null;
            } catch (IOException e4) {
                e = e4;
                bufferedInputStream2 = null;
                zipFile2 = zipFile;
                bufferedOutputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedOutputStream2 = null;
            bufferedInputStream2 = null;
        } catch (Throwable th6) {
            th = th6;
            zipFile = null;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        }
    }

    private static boolean qQ(String str) {
        return str.contains("../");
    }

    private static boolean createNewFileSafely(File file) {
        if (file == null || file.exists()) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    private static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
