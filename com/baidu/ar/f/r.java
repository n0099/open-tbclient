package com.baidu.ar.f;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes3.dex */
public class r {
    private static void a(ZipInputStream zipInputStream, File file) {
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            File file2 = new File(file, nextEntry.getName());
            g.c(file2);
            if (nextEntry.isDirectory()) {
                file2.mkdirs();
            } else {
                i.a(zipInputStream, file2);
            }
            zipInputStream.closeEntry();
        }
    }

    public static boolean a(File file, File file2) {
        ZipInputStream zipInputStream;
        ZipInputStream zipInputStream2 = null;
        try {
            zipInputStream = new ZipInputStream(new CheckedInputStream(new FileInputStream(file), new CRC32()));
            try {
                try {
                    a(zipInputStream, file2);
                    i.closeQuietly(zipInputStream);
                    return true;
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    i.closeQuietly(zipInputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                zipInputStream2 = zipInputStream;
                i.closeQuietly(zipInputStream2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            zipInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            i.closeQuietly(zipInputStream2);
            throw th;
        }
    }
}
