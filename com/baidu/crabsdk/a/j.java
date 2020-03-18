package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes8.dex */
public final class j {
    private static k Rh = new k("loop");
    private static k Ri = new k("writelog");

    public static Handler od() {
        return Rh.getHandler();
    }

    public static Handler oe() {
        return Ri.getHandler();
    }
}
