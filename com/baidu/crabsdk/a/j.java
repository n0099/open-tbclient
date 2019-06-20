package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes3.dex */
public final class j {
    private static k YY = new k("loop");
    private static k YZ = new k("writelog");

    public static Handler qI() {
        return YY.getHandler();
    }

    public static Handler qJ() {
        return YZ.getHandler();
    }
}
