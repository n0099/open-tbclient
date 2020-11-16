package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes7.dex */
public final class b {
    private static b anP;
    private boolean ah = false;
    private c anQ;

    private b(Context context) {
        this.anQ = c.ad(context);
    }

    public static b ab(Context context) {
        return ac(context);
    }

    private static b ac(Context context) {
        if (anP == null) {
            synchronized (b.class) {
                if (anP == null) {
                    anP = new b(context);
                }
            }
        }
        return anP;
    }

    public static b vf() {
        return anP;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.dC("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.anQ.anR);
            com.baidu.crabsdk.c.a.dC("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.dC("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.anQ.anS.stop();
        com.baidu.crabsdk.c.a.dC("Stop main-thread block monitoring!");
    }
}
