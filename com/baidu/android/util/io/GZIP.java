package com.baidu.android.util.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes6.dex */
public final class GZIP {
    private static final boolean DEBUG = false;
    public static final int NUM_1024 = 1024;

    private GZIP() {
    }

    public static byte[] gZip(byte[] bArr) {
        byte[] bArr2;
        Exception e;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            bArr2 = null;
            e = e2;
        }
        try {
            byteArrayOutputStream.close();
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return bArr2;
        }
        return bArr2;
    }

    public static byte[] unGZip(byte[] bArr) {
        byte[] bArr2;
        Exception e;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr3 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = gZIPInputStream.read(bArr3, 0, bArr3.length);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr3, 0, read);
            }
            bArr2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return bArr2;
            }
        } catch (Exception e3) {
            bArr2 = null;
            e = e3;
        }
        return bArr2;
    }

    public static boolean isGzipFile(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        byte[] bArr = new byte[4];
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                if ("1F8B0800".equalsIgnoreCase(FileUtils.toHexString(bArr, "", true))) {
                    Closeables.closeSafely(fileInputStream);
                    return true;
                }
                Closeables.closeSafely(fileInputStream);
                return false;
            } catch (Exception e) {
                fileInputStream2 = fileInputStream;
                Closeables.closeSafely(fileInputStream2);
                return false;
            } catch (Throwable th) {
                th = th;
                Closeables.closeSafely(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            fileInputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }
}
