package com.baidu.android.nebula.a;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public final class p {
    public static byte[] a(byte[] bArr) {
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
}
