package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes3.dex */
public final class b {
    private static b Jg;
    private c Jh;
    private boolean af = false;

    private b(Context context) {
        this.Jh = c.aj(context);
    }

    public static b ah(Context context) {
        return ai(context);
    }

    private static b ai(Context context) {
        if (Jg == null) {
            synchronized (b.class) {
                if (Jg == null) {
                    Jg = new b(context);
                }
            }
        }
        return Jg;
    }

    public static b mi() {
        return Jg;
    }

    public final void start() {
        if (this.af) {
            com.baidu.crabsdk.c.a.bu("Block monitoring has already started!");
            return;
        }
        this.af = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.Jh.Ji);
            com.baidu.crabsdk.c.a.bu("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.af) {
            com.baidu.crabsdk.c.a.bu("Block monitoring is not enabled!");
            return;
        }
        this.af = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.Jh.Jj.stop();
        com.baidu.crabsdk.c.a.bu("Stop main-thread block monitoring!");
    }
}
