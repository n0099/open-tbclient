package com.baidu.e.a.a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes11.dex */
public class o {
    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean unzip(File file, File file2) {
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(file);
            try {
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        File file3 = new File(file2, nextElement.getName());
                        c.ensureParent(file3);
                        if (nextElement.isDirectory()) {
                            file3.mkdirs();
                        } else {
                            InputStream inputStream = zipFile.getInputStream(nextElement);
                            File f = f(file3);
                            d.copyStream(inputStream, f);
                            d.close(inputStream);
                            f.renameTo(file3);
                        }
                    }
                    a(zipFile);
                    return true;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    a(zipFile);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                a(zipFile);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            zipFile = null;
        } catch (Throwable th2) {
            th = th2;
            zipFile = null;
            a(zipFile);
            throw th;
        }
    }

    public static File f(File file) {
        return new File(file.getAbsolutePath() + ".tmp" + System.currentTimeMillis());
    }
}
