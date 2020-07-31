package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes12.dex */
public final class j {
    private static k alF = new k("loop");
    private static k alG = new k("writelog");

    public static Handler te() {
        return alF.getHandler();
    }

    public static Handler tf() {
        return alG.getHandler();
    }
}
