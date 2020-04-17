package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes8.dex */
public final class b {
    private static b ajq;
    private boolean ah = false;
    private c ajr;

    private b(Context context) {
        this.ajr = c.ah(context);
    }

    public static b af(Context context) {
        return ag(context);
    }

    private static b ag(Context context) {
        if (ajq == null) {
            synchronized (b.class) {
                if (ajq == null) {
                    ajq = new b(context);
                }
            }
        }
        return ajq;
    }

    public static b sv() {
        return ajq;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.de("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.ajr.ajs);
            com.baidu.crabsdk.c.a.de("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.de("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.ajr.ajt.stop();
        com.baidu.crabsdk.c.a.de("Stop main-thread block monitoring!");
    }
}
