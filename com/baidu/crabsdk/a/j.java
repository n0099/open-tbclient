package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes6.dex */
public final class j {
    private static k Pu = new k("loop");
    private static k Pv = new k("writelog");

    public static Handler nv() {
        return Pu.getHandler();
    }

    public static Handler nw() {
        return Pv.getHandler();
    }
}
