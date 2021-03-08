package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class j {
    private static k apS = new k("loop");
    private static k apT = new k("writelog");

    public static Handler ul() {
        return apS.getHandler();
    }

    public static Handler um() {
        return apT.getHandler();
    }
}
