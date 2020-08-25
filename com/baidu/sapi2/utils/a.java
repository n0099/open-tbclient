package com.baidu.sapi2.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes12.dex */
public final class a {
    private static final int a = 2048;

    public static boolean a(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            Log.i(Log.TAG, e);
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [9=4] */
    public static String b(String str) throws IOException {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception e) {
            fileInputStream2 = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str2 = new String(bArr);
            fileInputStream.close();
            return str2;
        } catch (Exception e2) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static boolean a(File file, byte[] bArr, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            if (file.canWrite()) {
                fileOutputStream = new FileOutputStream(file, z);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                    return true;
                } catch (Throwable th) {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                        return false;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th2) {
            fileOutputStream = null;
        }
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static int a(InputStream inputStream, OutputStream outputStream) throws Exception, IOException {
        int i = 0;
        byte[] bArr = new byte[2048];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 2048);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 2048);
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr, 0, 2048);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
            } finally {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    Log.e(Log.TAG, e);
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e2) {
                    Log.e(Log.TAG, e2);
                }
            }
        }
        bufferedOutputStream.flush();
        return i;
    }
}
