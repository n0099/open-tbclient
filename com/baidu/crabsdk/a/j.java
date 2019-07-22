package com.baidu.crabsdk.a;

import android.os.Handler;
/* loaded from: classes3.dex */
public final class j {
    private static k Zt = new k("loop");
    private static k Zu = new k("writelog");

    public static Handler rf() {
        return Zt.getHandler();
    }

    public static Handler rg() {
        return Zu.getHandler();
    }
}
