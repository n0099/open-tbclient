package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes6.dex */
public final class b {
    private static b Xi;
    private c Xj;
    private boolean af = false;

    private b(Context context) {
        this.Xj = c.bg(context);
    }

    public static b be(Context context) {
        return bf(context);
    }

    private static b bf(Context context) {
        if (Xi == null) {
            synchronized (b.class) {
                if (Xi == null) {
                    Xi = new b(context);
                }
            }
        }
        return Xi;
    }

    public static b rj() {
        return Xi;
    }

    public final void start() {
        if (this.af) {
            com.baidu.crabsdk.c.a.cG("Block monitoring has already started!");
            return;
        }
        this.af = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.Xj.Xk);
            com.baidu.crabsdk.c.a.cG("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.af) {
            com.baidu.crabsdk.c.a.cG("Block monitoring is not enabled!");
            return;
        }
        this.af = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.Xj.Xl.stop();
        com.baidu.crabsdk.c.a.cG("Stop main-thread block monitoring!");
    }
}
