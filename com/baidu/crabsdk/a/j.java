package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes6.dex */
public final class j {
    private static k XE = new k("loop");
    private static k XF = new k("writelog");

    public static Handler rn() {
        return XE.getHandler();
    }

    public static Handler ro() {
        return XF.getHandler();
    }
}
