package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes11.dex */
public final class j {
    private static k anV = new k("loop");
    private static k anW = new k("writelog");

    public static Handler vj() {
        return anV.getHandler();
    }

    public static Handler vk() {
        return anW.getHandler();
    }
}
