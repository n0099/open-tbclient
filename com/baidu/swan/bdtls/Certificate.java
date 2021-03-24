package com.baidu.swan.bdtls;

import android.content.Context;
/* loaded from: classes3.dex */
public class Certificate {
    static {
        System.loadLibrary("bdtls");
    }

    public static byte[] a(Context context) {
        return signature(context);
    }

    public static native byte[] signature(Object obj);
}
