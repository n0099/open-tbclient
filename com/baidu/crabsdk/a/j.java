package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes8.dex */
public final class j {
    private static k ajD = new k("loop");
    private static k ajE = new k("writelog");

    public static Handler sy() {
        return ajD.getHandler();
    }

    public static Handler sz() {
        return ajE.getHandler();
    }
}
