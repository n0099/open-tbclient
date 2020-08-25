package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes6.dex */
public final class j {
    private static k amI = new k("loop");
    private static k amJ = new k("writelog");

    public static Handler uM() {
        return amI.getHandler();
    }

    public static Handler uN() {
        return amJ.getHandler();
    }
}
