package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes5.dex */
public final class b {
    private static b apG;
    private boolean ah = false;
    private c apH;

    private b(Context context) {
        this.apH = c.ac(context);
    }

    public static b aa(Context context) {
        return ab(context);
    }

    private static b ab(Context context) {
        if (apG == null) {
            synchronized (b.class) {
                if (apG == null) {
                    apG = new b(context);
                }
            }
        }
        return apG;
    }

    public static b ui() {
        return apG;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.dw("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.apH.apI);
            com.baidu.crabsdk.c.a.dw("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.dw("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.apH.apJ.stop();
        com.baidu.crabsdk.c.a.dw("Stop main-thread block monitoring!");
    }
}
