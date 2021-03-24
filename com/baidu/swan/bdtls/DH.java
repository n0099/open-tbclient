package com.baidu.swan.bdtls;
/* loaded from: classes3.dex */
public class DH {
    static {
        System.loadLibrary("bdtls");
    }

    public static int a() {
        return getGroupId();
    }

    public static int b(int i, int i2) {
        return getPublicKey(i, i2);
    }

    public static int c() {
        return getSecret();
    }

    public static byte[] d(int i, int i2, int i3) {
        return getSecretKey(i, i2, i3);
    }

    public static native int getGroupId();

    public static native int getPublicKey(int i, int i2);

    public static native int getSecret();

    public static native byte[] getSecretKey(int i, int i2, int i3);
}
