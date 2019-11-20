package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes3.dex */
public final class j {
    private static k IT = new k("loop");
    private static k IU = new k("writelog");

    public static Handler ml() {
        return IT.getHandler();
    }

    public static Handler mm() {
        return IU.getHandler();
    }
}
