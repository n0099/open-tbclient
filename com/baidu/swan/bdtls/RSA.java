package com.baidu.swan.bdtls;
/* loaded from: classes3.dex */
public final class RSA {
    static {
        System.loadLibrary("bdtls");
    }

    public static native byte[] decrypt(byte[] bArr);

    public static native byte[] encrypt(byte[] bArr);

    public static native byte[] privateDecrypt(byte[] bArr);

    public static native byte[] privateEncrypt(byte[] bArr);
}
