package com.baidu.swan.bdtls;

import android.content.Context;
/* loaded from: classes16.dex */
public class Certificate {
    public static native byte[] signature(Object obj);

    public static byte[] dv(Context context) {
        return signature(context);
    }

    static {
        System.loadLibrary("bdtls");
    }
}
