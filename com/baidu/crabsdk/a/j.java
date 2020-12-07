package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes8.dex */
public final class j {
    private static k aoQ = new k("loop");
    private static k aoR = new k("writelog");

    public static Handler uX() {
        return aoQ.getHandler();
    }

    public static Handler uY() {
        return aoR.getHandler();
    }
}
