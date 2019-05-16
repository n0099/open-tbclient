package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes3.dex */
public final class j {
    private static k YZ = new k("loop");
    private static k Za = new k("writelog");

    public static Handler qI() {
        return YZ.getHandler();
    }

    public static Handler qJ() {
        return Za.getHandler();
    }
}
