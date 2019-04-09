package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes3.dex */
public final class j {
    private static k abi = new k("loop");
    private static k abj = new k("writelog");

    public static Handler rN() {
        return abi.getHandler();
    }

    public static Handler rO() {
        return abj.getHandler();
    }
}
