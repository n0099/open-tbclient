package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes11.dex */
public final class b {
    private static b anI;
    private boolean ah = false;
    private c anJ;

    private b(Context context) {
        this.anJ = c.ad(context);
    }

    public static b ab(Context context) {
        return ac(context);
    }

    private static b ac(Context context) {
        if (anI == null) {
            synchronized (b.class) {
                if (anI == null) {
                    anI = new b(context);
                }
            }
        }
        return anI;
    }

    public static b vg() {
        return anI;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.dA("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.anJ.anK);
            com.baidu.crabsdk.c.a.dA("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.dA("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.anJ.anL.stop();
        com.baidu.crabsdk.c.a.dA("Stop main-thread block monitoring!");
    }
}
