package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes8.dex */
public final class b {
    private static b aoD;
    private boolean ah = false;
    private c aoE;

    private b(Context context) {
        this.aoE = c.ae(context);
    }

    public static b ac(Context context) {
        return ad(context);
    }

    private static b ad(Context context) {
        if (aoD == null) {
            synchronized (b.class) {
                if (aoD == null) {
                    aoD = new b(context);
                }
            }
        }
        return aoD;
    }

    public static b uU() {
        return aoD;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.dE("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.aoE.aoF);
            com.baidu.crabsdk.c.a.dE("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.dE("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.aoE.aoG.stop();
        com.baidu.crabsdk.c.a.dE("Stop main-thread block monitoring!");
    }
}
