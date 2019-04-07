package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes3.dex */
public final class b {
    private static b aaT;
    private c aaU;
    private boolean af = false;

    private b(Context context) {
        this.aaU = c.ba(context);
    }

    public static b aY(Context context) {
        return aZ(context);
    }

    private static b aZ(Context context) {
        if (aaT == null) {
            synchronized (b.class) {
                if (aaT == null) {
                    aaT = new b(context);
                }
            }
        }
        return aaT;
    }

    public static b rK() {
        return aaT;
    }

    public final void start() {
        if (this.af) {
            com.baidu.crabsdk.c.a.cv("Block monitoring has already started!");
            return;
        }
        this.af = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.aaU.aaV);
            com.baidu.crabsdk.c.a.cv("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.af) {
            com.baidu.crabsdk.c.a.cv("Block monitoring is not enabled!");
            return;
        }
        this.af = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.aaU.aaW.stop();
        com.baidu.crabsdk.c.a.cv("Stop main-thread block monitoring!");
    }
}
