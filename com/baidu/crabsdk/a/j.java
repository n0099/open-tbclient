package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes8.dex */
public final class j {
    private static k alK = new k("loop");
    private static k alL = new k("writelog");

    public static Handler tc() {
        return alK.getHandler();
    }

    public static Handler td() {
        return alL.getHandler();
    }
}
