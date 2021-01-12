package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes14.dex */
public final class j {
    private static k aoC = new k("loop");
    private static k aoD = new k("writelog");

    public static Handler uo() {
        return aoC.getHandler();
    }

    public static Handler up() {
        return aoD.getHandler();
    }
}
