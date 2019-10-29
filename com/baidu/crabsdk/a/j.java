package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes3.dex */
public final class j {
    private static k Ju = new k("loop");
    private static k Jv = new k("writelog");

    public static Handler ml() {
        return Ju.getHandler();
    }

    public static Handler mm() {
        return Jv.getHandler();
    }
}
