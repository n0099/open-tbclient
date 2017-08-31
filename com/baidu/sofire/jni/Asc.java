package com.baidu.sofire.jni;

import com.baidu.sofire.b.d;
/* loaded from: classes.dex */
public class Asc {
    public static native String nx();

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native int df(String str, String str2, byte[] bArr);

    public native byte[] dr(byte[] bArr, byte[] bArr2);

    static {
        try {
            System.loadLibrary("fire");
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
