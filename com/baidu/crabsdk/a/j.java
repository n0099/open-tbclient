package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes3.dex */
public final class j {
    private static k abg = new k("loop");
    private static k abh = new k("writelog");

    public static Handler rN() {
        return abg.getHandler();
    }

    public static Handler rO() {
        return abh.getHandler();
    }
}
