package com.baidu.swan.bdtls;

import android.content.Context;
import androidx.annotation.Keep;
@Keep
/* loaded from: classes3.dex */
public class Certificate {
    static {
        System.loadLibrary("bdtls");
    }

    public static byte[] getSignature(Context context) {
        return signature(context);
    }

    @Keep
    public static native byte[] signature(Object obj);
}
