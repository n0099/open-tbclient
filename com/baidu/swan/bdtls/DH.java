package com.baidu.swan.bdtls;
/* loaded from: classes3.dex */
public class DH {
    static {
        System.loadLibrary("bdtls");
    }

    public static int a() {
        return getGroupId();
    }

    public static int b(int i2, int i3) {
        return getPublicKey(i2, i3);
    }

    public static int c() {
        return getSecret();
    }

    public static byte[] d(int i2, int i3, int i4) {
        return getSecretKey(i2, i3, i4);
    }

    public static native int getGroupId();

    public static native int getPublicKey(int i2, int i3);

    public static native int getSecret();

    public static native byte[] getSecretKey(int i2, int i3, int i4);
}
