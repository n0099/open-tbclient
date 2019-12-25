package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class j {
    private static k Pq = new k("loop");
    private static k Pr = new k("writelog");

    public static Handler nu() {
        return Pq.getHandler();
    }

    public static Handler nv() {
        return Pr.getHandler();
    }
}
