package com.baidu.swan.bdtls;

import android.content.Context;
/* loaded from: classes14.dex */
public class Certificate {
    public static native byte[] signature(Object obj);

    public static byte[] et(Context context) {
        return signature(context);
    }

    static {
        System.loadLibrary("bdtls");
    }
}
