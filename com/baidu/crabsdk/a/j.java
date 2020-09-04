package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes6.dex */
public final class j {
    private static k amK = new k("loop");
    private static k amL = new k("writelog");

    public static Handler uM() {
        return amK.getHandler();
    }

    public static Handler uN() {
        return amL.getHandler();
    }
}
