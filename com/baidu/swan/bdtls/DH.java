package com.baidu.swan.bdtls;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes3.dex */
public class DH {
    static {
        System.loadLibrary("bdtls");
    }

    public static int getDHGroupId() {
        return getGroupId();
    }

    public static int getDHPublicKey(int i2, int i3) {
        return getPublicKey(i2, i3);
    }

    public static int getDHSecret() {
        return getSecret();
    }

    public static byte[] getDHSecretKey(int i2, int i3, int i4) {
        return getSecretKey(i2, i3, i4);
    }

    @Keep
    public static native int getGroupId();

    @Keep
    public static native int getPublicKey(int i2, int i3);

    @Keep
    public static native int getSecret();

    @Keep
    public static native byte[] getSecretKey(int i2, int i3, int i4);
}
