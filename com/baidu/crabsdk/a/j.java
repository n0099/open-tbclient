package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes2.dex */
public final class j {
    private static k UH = new k("loop");
    private static k UI = new k("writelog");

    public static Handler qc() {
        return UH.getHandler();
    }

    public static Handler qd() {
        return UI.getHandler();
    }
}
