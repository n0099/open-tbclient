package com.baidu.swan.bdtls;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes3.dex */
public class DH {
    @Keep
    public static native int getGroupId();

    @Keep
    public static native int getPublicKey(int i, int i2);

    @Keep
    public static native int getSecret();

    @Keep
    public static native byte[] getSecretKey(int i, int i2, int i3);

    static {
        System.loadLibrary("bdtls");
    }

    public static int getDHGroupId() {
        return getGroupId();
    }

    public static int getDHSecret() {
        return getSecret();
    }

    public static int getDHPublicKey(int i, int i2) {
        return getPublicKey(i, i2);
    }

    public static byte[] getDHSecretKey(int i, int i2, int i3) {
        return getSecretKey(i, i2, i3);
    }
}
