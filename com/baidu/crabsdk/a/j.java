package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class j {
    private static k aos = new k("loop");
    private static k aot = new k("writelog");

    public static Handler ul() {
        return aos.getHandler();
    }

    public static Handler um() {
        return aot.getHandler();
    }
}
