package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes6.dex */
public final class j {
    private static k Xv = new k("loop");
    private static k Xw = new k("writelog");

    public static Handler rj() {
        return Xv.getHandler();
    }

    public static Handler rk() {
        return Xw.getHandler();
    }
}
