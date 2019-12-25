package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes5.dex */
public final class b {
    private static b Pb;
    private c Pc;
    private boolean af = false;

    private b(Context context) {
        this.Pc = c.aq(context);
    }

    public static b ao(Context context) {
        return ap(context);
    }

    private static b ap(Context context) {
        if (Pb == null) {
            synchronized (b.class) {
                if (Pb == null) {
                    Pb = new b(context);
                }
            }
        }
        return Pb;
    }

    public static b nr() {
        return Pb;
    }

    public final void start() {
        if (this.af) {
            com.baidu.crabsdk.c.a.cb("Block monitoring has already started!");
            return;
        }
        this.af = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.Pc.Pe);
            com.baidu.crabsdk.c.a.cb("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.af) {
            com.baidu.crabsdk.c.a.cb("Block monitoring is not enabled!");
            return;
        }
        this.af = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.Pc.Pf.stop();
        com.baidu.crabsdk.c.a.cb("Stop main-thread block monitoring!");
    }
}
