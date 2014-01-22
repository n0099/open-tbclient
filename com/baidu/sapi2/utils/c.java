package com.baidu.sapi2.utils;

import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public class c {
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
