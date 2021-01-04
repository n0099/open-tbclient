package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes3.dex */
public final class b {
    private static b apd;
    private boolean ah = false;
    private c ape;

    private b(Context context) {
        this.ape = c.ae(context);
    }

    public static b ac(Context context) {
        return ad(context);
    }

    private static b ad(Context context) {
        if (apd == null) {
            synchronized (b.class) {
                if (apd == null) {
                    apd = new b(context);
                }
            }
        }
        return apd;
    }

    public static b us() {
        return apd;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.dx("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.ape.apf);
            com.baidu.crabsdk.c.a.dx("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.dx("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.ape.apg.stop();
        com.baidu.crabsdk.c.a.dx("Stop main-thread block monitoring!");
    }
}
