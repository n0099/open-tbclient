package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes7.dex */
public final class j {
    private static k aoc = new k("loop");
    private static k aod = new k("writelog");

    public static Handler vi() {
        return aoc.getHandler();
    }

    public static Handler vj() {
        return aod.getHandler();
    }
}
