package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes2.dex */
public final class j {
    private static k Sf = new k("loop");
    private static k Sg = new k("writelog");

    public static Handler oV() {
        return Sf.getHandler();
    }

    public static Handler oW() {
        return Sg.getHandler();
    }
}
