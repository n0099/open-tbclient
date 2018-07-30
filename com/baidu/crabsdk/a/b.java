package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes2.dex */
public final class b {
    private static b RO;
    private c RP;
    private boolean ae = false;

    private b(Context context) {
        this.RP = c.at(context);
    }

    public static b ar(Context context) {
        return as(context);
    }

    private static b as(Context context) {
        if (RO == null) {
            synchronized (b.class) {
                if (RO == null) {
                    RO = new b(context);
                }
            }
        }
        return RO;
    }

    public static b oW() {
        return RO;
    }

    public final void start() {
        if (this.ae) {
            com.baidu.crabsdk.c.a.ce("Block monitoring has already started!");
            return;
        }
        this.ae = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.RP.RQ);
            com.baidu.crabsdk.c.a.ce("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.b("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ae) {
            com.baidu.crabsdk.c.a.ce("Block monitoring is not enabled!");
            return;
        }
        this.ae = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.RP.RR.stop();
        com.baidu.crabsdk.c.a.ce("Stop main-thread block monitoring!");
    }
}
