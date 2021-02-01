package com.baidu.swan.bdtls;
/* loaded from: classes5.dex */
public final class RSA {
    public static native byte[] decrypt(byte[] bArr);

    public static native byte[] encrypt(byte[] bArr);

    public static native byte[] privateDecrypt(byte[] bArr);

    public static native byte[] privateEncrypt(byte[] bArr);

    static {
        System.loadLibrary("bdtls");
    }
}
