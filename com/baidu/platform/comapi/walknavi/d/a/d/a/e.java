package com.baidu.platform.comapi.walknavi.d.a.d.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes8.dex */
public class e {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [37=4] */
    public static boolean a(File file, File file2) {
        ZipInputStream zipInputStream;
        Throwable th;
        ZipInputStream zipInputStream2 = null;
        try {
            zipInputStream = new ZipInputStream(new CheckedInputStream(new FileInputStream(file), new CRC32()));
        } catch (IOException e) {
        } catch (Throwable th2) {
            zipInputStream = null;
            th = th2;
        }
        try {
            a(zipInputStream, file2);
            c.a(zipInputStream);
            return true;
        } catch (IOException e2) {
            zipInputStream2 = zipInputStream;
            c.a(zipInputStream2);
            return false;
        } catch (Throwable th3) {
            th = th3;
            c.a(zipInputStream);
            throw th;
        }
    }

    private static void a(ZipInputStream zipInputStream, File file) throws IOException {
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                File file2 = new File(file, nextEntry.getName());
                a.a(file2);
                if (nextEntry.isDirectory()) {
                    file2.mkdirs();
                } else {
                    c.a(zipInputStream, file2);
                }
                zipInputStream.closeEntry();
            } else {
                return;
            }
        }
    }
}
