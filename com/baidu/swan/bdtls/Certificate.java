package com.baidu.swan.bdtls;

import android.content.Context;
/* loaded from: classes3.dex */
public class Certificate {
    public static native byte[] signature(Object obj);

    public static byte[] eu(Context context) {
        return signature(context);
    }

    static {
        System.loadLibrary("bdtls");
    }
}
