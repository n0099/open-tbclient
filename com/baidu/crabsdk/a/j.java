package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes3.dex */
public final class j {
    private static k apr = new k("loop");
    private static k aps = new k("writelog");

    public static Handler uv() {
        return apr.getHandler();
    }

    public static Handler uw() {
        return aps.getHandler();
    }
}
