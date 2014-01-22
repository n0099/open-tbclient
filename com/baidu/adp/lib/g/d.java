package com.baidu.adp.lib.g;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public class d {
    public static void a(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr, 0, 1024);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                gZIPInputStream.close();
                return;
            }
        }
    }

    public static void b(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                return;
            }
        }
    }

    public static void a(byte[] bArr, OutputStream outputStream) {
        if (bArr != null && bArr.length != 0) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            gZIPOutputStream.write(bArr, 0, bArr.length);
            gZIPOutputStream.flush();
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
        }
    }
}
