package com.baidu.ar.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
/* loaded from: classes3.dex */
public class ZipUtils {
    private static void a(ZipInputStream zipInputStream, File file) {
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            File file2 = new File(file, nextEntry.getName());
            FileUtils.ensureParent(file2);
            if (nextEntry.isDirectory()) {
                file2.mkdirs();
            } else {
                IoUtils.copyStream(zipInputStream, file2);
            }
            zipInputStream.closeEntry();
        }
    }

    public static void closeZipFile(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isZipFile(String str) {
        try {
            try {
                closeZipFile(new ZipFile(str));
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                closeZipFile(null);
                return false;
            }
        } catch (Throwable th) {
            closeZipFile(null);
            throw th;
        }
    }

    public static boolean unzip(File file, File file2) {
        ZipInputStream zipInputStream;
        ZipInputStream zipInputStream2 = null;
        try {
            zipInputStream = new ZipInputStream(new CheckedInputStream(new FileInputStream(file), new CRC32()));
            try {
                try {
                    a(zipInputStream, file2);
                    IoUtils.closeQuietly(zipInputStream);
                    return true;
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    IoUtils.closeQuietly(zipInputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                zipInputStream2 = zipInputStream;
                IoUtils.closeQuietly(zipInputStream2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            zipInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            IoUtils.closeQuietly(zipInputStream2);
            throw th;
        }
    }
}
