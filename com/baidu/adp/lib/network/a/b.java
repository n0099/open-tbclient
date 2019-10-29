package com.baidu.adp.lib.network.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class b {
    public static boolean al(String str) {
        return str != null && str.contains("vnd.wap.wml");
    }

    public static byte[] f(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long c = c(inputStream, outputStream);
        if (c > 2147483647L) {
            return -1;
        }
        return (int) c;
    }

    public static long c(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null) {
            return -1L;
        }
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
                j += read;
            } else {
                return j;
            }
        }
    }
}
