package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes8.dex */
public final class j {
    private static k anm = new k("loop");
    private static k ann = new k("writelog");

    public static Handler va() {
        return anm.getHandler();
    }

    public static Handler vb() {
        return ann.getHandler();
    }
}
