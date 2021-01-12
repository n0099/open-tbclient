package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes14.dex */
public final class b {
    private static b aoq;
    private boolean ah = false;
    private c aor;

    private b(Context context) {
        this.aor = c.ad(context);
    }

    public static b ab(Context context) {
        return ac(context);
    }

    private static b ac(Context context) {
        if (aoq == null) {
            synchronized (b.class) {
                if (aoq == null) {
                    aoq = new b(context);
                }
            }
        }
        return aoq;
    }

    public static b ul() {
        return aoq;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.ds("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.aor.aos);
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
        this.aor.aot.stop();
        com.baidu.crabsdk.c.a.ds("Stop main-thread block monitoring!");
    }
}
