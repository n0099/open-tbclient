package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes2.dex */
public final class j {
    private static k Sd = new k("loop");
    private static k Se = new k("writelog");

    public static Handler oV() {
        return Sd.getHandler();
    }

    public static Handler oW() {
        return Se.getHandler();
    }
}
