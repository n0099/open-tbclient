package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes2.dex */
public final class b {
    private static b Ut;
    private c Uu;
    private boolean ae = false;

    private b(Context context) {
        this.Uu = c.aZ(context);
    }

    public static b aX(Context context) {
        return aY(context);
    }

    private static b aY(Context context) {
        if (Ut == null) {
            synchronized (b.class) {
                if (Ut == null) {
                    Ut = new b(context);
                }
            }
        }
        return Ut;
    }

    public static b pZ() {
        return Ut;
    }

    public final void start() {
        if (this.ae) {
            com.baidu.crabsdk.c.a.cv("Block monitoring has already started!");
            return;
        }
        this.ae = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.Uu.Uv);
            com.baidu.crabsdk.c.a.cv("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ae) {
            com.baidu.crabsdk.c.a.cv("Block monitoring is not enabled!");
            return;
        }
        this.ae = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.Uu.Uw.stop();
        com.baidu.crabsdk.c.a.cv("Stop main-thread block monitoring!");
    }
}
