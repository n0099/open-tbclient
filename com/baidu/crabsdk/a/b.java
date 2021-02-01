package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes5.dex */
public final class b {
    private static b aog;
    private boolean ah = false;
    private c aoh;

    private b(Context context) {
        this.aoh = c.ad(context);
    }

    public static b ab(Context context) {
        return ac(context);
    }

    private static b ac(Context context) {
        if (aog == null) {
            synchronized (b.class) {
                if (aog == null) {
                    aog = new b(context);
                }
            }
        }
        return aog;
    }

    public static b ui() {
        return aog;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.ds("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.aoh.aoi);
            com.baidu.crabsdk.c.a.ds("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.ds("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.aoh.aoj.stop();
        com.baidu.crabsdk.c.a.ds("Stop main-thread block monitoring!");
    }
}
