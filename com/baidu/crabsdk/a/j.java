package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes8.dex */
public final class j {
    private static k Re = new k("loop");
    private static k Rf = new k("writelog");

    public static Handler od() {
        return Re.getHandler();
    }

    public static Handler oe() {
        return Rf.getHandler();
    }
}
