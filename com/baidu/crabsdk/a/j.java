package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes11.dex */
public final class j {
    private static k anW = new k("loop");
    private static k anX = new k("writelog");

    public static Handler vj() {
        return anW.getHandler();
    }

    public static Handler vk() {
        return anX.getHandler();
    }
}
