package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes2.dex */
public final class b {
    private static b RP;
    private c RQ;
    private boolean ae = false;

    private b(Context context) {
        this.RQ = c.at(context);
    }

    public static b ar(Context context) {
        return as(context);
    }

    private static b as(Context context) {
        if (RP == null) {
            synchronized (b.class) {
                if (RP == null) {
                    RP = new b(context);
                }
            }
        }
        return RP;
    }

    public static b oT() {
        return RP;
    }

    public final void start() {
        if (this.ae) {
            com.baidu.crabsdk.c.a.cb("Block monitoring has already started!");
            return;
        }
        this.ae = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.RQ.RR);
            com.baidu.crabsdk.c.a.cb("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.b("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ae) {
            com.baidu.crabsdk.c.a.cb("Block monitoring is not enabled!");
            return;
        }
        this.ae = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.RQ.RT.stop();
        com.baidu.crabsdk.c.a.cb("Stop main-thread block monitoring!");
    }
}
