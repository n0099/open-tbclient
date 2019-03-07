package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes3.dex */
public final class j {
    private static k abf = new k("loop");
    private static k abg = new k("writelog");

    public static Handler rN() {
        return abf.getHandler();
    }

    public static Handler rO() {
        return abg.getHandler();
    }
}
