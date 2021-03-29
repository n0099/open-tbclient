package com.baidu.sofire.jni;

import com.baidu.sofire.g.d;
/* loaded from: classes2.dex */
public class Asc {
    static {
        try {
            System.loadLibrary("fire");
        } catch (Throwable unused) {
            d.a();
        }
    }

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native int df(String str, String str2, byte[] bArr);

    public native byte[] dr(byte[] bArr, byte[] bArr2);
}
