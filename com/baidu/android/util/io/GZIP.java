package com.baidu.android.util.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes2.dex */
public final class GZIP {
    public static final boolean DEBUG = false;
    public static final int NUM_1024 = 1024;

    public static byte[] gZip(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return bArr2;
        }
    }

    public static boolean isGzipFile(String str) {
        FileInputStream fileInputStream;
        File file = new File(str);
        if (file.exists()) {
            byte[] bArr = new byte[4];
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                } catch (Exception unused) {
                    fileInputStream2 = fileInputStream;
                    Closeables.closeSafely(fileInputStream2);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    Closeables.closeSafely(fileInputStream2);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
            if ("1F8B0800".equalsIgnoreCase(FileUtils.toHexString(bArr, "", true))) {
                Closeables.closeSafely(fileInputStream);
                return true;
            }
            Closeables.closeSafely(fileInputStream);
            return false;
        }
        return false;
    }

    public static byte[] unGZip(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr3 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = gZIPInputStream.read(bArr3, 0, 1024);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr3, 0, read);
                } else {
                    bArr2 = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return bArr2;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return bArr2;
        }
    }
}
