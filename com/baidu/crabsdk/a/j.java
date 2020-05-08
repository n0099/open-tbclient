package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes8.dex */
public final class j {
    private static k ajJ = new k("loop");
    private static k ajK = new k("writelog");

    public static Handler sx() {
        return ajJ.getHandler();
    }

    public static Handler sy() {
        return ajK.getHandler();
    }
}
