package com.baidu.swan.bdtls;
/* loaded from: classes3.dex */
public class DH {
    private static native int getGroupId();

    private static native int getPublicKey(int i, int i2);

    private static native int getSecret();

    private static native byte[] getSecretKey(int i, int i2, int i3);

    public static int aTC() {
        return getSecret();
    }

    public static int aTD() {
        return getGroupId();
    }

    public static int at(int i, int i2) {
        return getPublicKey(i, i2);
    }

    public static byte[] w(int i, int i2, int i3) {
        return getSecretKey(i, i2, i3);
    }

    static {
        System.loadLibrary("bdtls");
    }
}
