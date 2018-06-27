package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes2.dex */
public final class b {
    private static b RR;
    private c RT;
    private boolean ae = false;

    private b(Context context) {
        this.RT = c.at(context);
    }

    public static b ar(Context context) {
        return as(context);
    }

    private static b as(Context context) {
        if (RR == null) {
            synchronized (b.class) {
                if (RR == null) {
                    RR = new b(context);
                }
            }
        }
        return RR;
    }

    public static b oT() {
        return RR;
    }

    public final void start() {
        if (this.ae) {
            com.baidu.crabsdk.c.a.cd("Block monitoring has already started!");
            return;
        }
        this.ae = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.RT.RU);
            com.baidu.crabsdk.c.a.cd("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.b("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ae) {
            com.baidu.crabsdk.c.a.cd("Block monitoring is not enabled!");
            return;
        }
        this.ae = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.RT.RV.stop();
        com.baidu.crabsdk.c.a.cd("Stop main-thread block monitoring!");
    }
}
