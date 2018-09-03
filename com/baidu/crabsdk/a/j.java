package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes2.dex */
public final class j {
    private static k Sc = new k("loop");
    private static k Sd = new k("writelog");

    public static Handler oW() {
        return Sc.getHandler();
    }

    public static Handler oX() {
        return Sd.getHandler();
    }
}
