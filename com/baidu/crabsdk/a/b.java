package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes6.dex */
public final class b {
    private static b Xr;
    private c Xs;
    private boolean af = false;

    private b(Context context) {
        this.Xs = c.bg(context);
    }

    public static b be(Context context) {
        return bf(context);
    }

    private static b bf(Context context) {
        if (Xr == null) {
            synchronized (b.class) {
                if (Xr == null) {
                    Xr = new b(context);
                }
            }
        }
        return Xr;
    }

    public static b rk() {
        return Xr;
    }

    public final void start() {
        if (this.af) {
            com.baidu.crabsdk.c.a.cH("Block monitoring has already started!");
            return;
        }
        this.af = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.Xs.Xt);
            com.baidu.crabsdk.c.a.cH("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.af) {
            com.baidu.crabsdk.c.a.cH("Block monitoring is not enabled!");
            return;
        }
        this.af = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.Xs.Xu.stop();
        com.baidu.crabsdk.c.a.cH("Stop main-thread block monitoring!");
    }
}
