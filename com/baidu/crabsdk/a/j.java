package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes8.dex */
public final class j {
    private static k akn = new k("loop");
    private static k ako = new k("writelog");

    public static Handler sH() {
        return akn.getHandler();
    }

    public static Handler sI() {
        return ako.getHandler();
    }
}
