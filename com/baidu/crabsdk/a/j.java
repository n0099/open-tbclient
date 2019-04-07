package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes3.dex */
public final class j {
    private static k abh = new k("loop");
    private static k abi = new k("writelog");

    public static Handler rN() {
        return abh.getHandler();
    }

    public static Handler rO() {
        return abi.getHandler();
    }
}
