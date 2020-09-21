package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes8.dex */
public final class b {
    private static b amZ;
    private boolean ah = false;
    private c ana;

    private b(Context context) {
        this.ana = c.aa(context);
    }

    public static b Y(Context context) {
        return Z(context);
    }

    private static b Z(Context context) {
        if (amZ == null) {
            synchronized (b.class) {
                if (amZ == null) {
                    amZ = new b(context);
                }
            }
        }
        return amZ;
    }

    public static b uX() {
        return amZ;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.dv("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.ana.anb);
            com.baidu.crabsdk.c.a.dv("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.dv("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.ana.anc.stop();
        com.baidu.crabsdk.c.a.dv("Stop main-thread block monitoring!");
    }
}
