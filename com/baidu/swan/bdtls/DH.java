package com.baidu.swan.bdtls;
/* loaded from: classes11.dex */
public class DH {
    private static native int getGroupId();

    private static native int getPublicKey(int i, int i2);

    private static native int getSecret();

    private static native byte[] getSecretKey(int i, int i2, int i3);

    public static int aiR() {
        return getSecret();
    }

    public static int aiS() {
        return getGroupId();
    }

    public static int aj(int i, int i2) {
        return getPublicKey(i, i2);
    }

    public static byte[] t(int i, int i2, int i3) {
        return getSecretKey(i, i2, i3);
    }

    static {
        System.loadLibrary("bdtls");
    }
}
