package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes6.dex */
public final class b {
    private static b Pg;
    private c Ph;
    private boolean af = false;

    private b(Context context) {
        this.Ph = c.aq(context);
    }

    public static b ao(Context context) {
        return ap(context);
    }

    private static b ap(Context context) {
        if (Pg == null) {
            synchronized (b.class) {
                if (Pg == null) {
                    Pg = new b(context);
                }
            }
        }
        return Pg;
    }

    public static b ns() {
        return Pg;
    }

    public final void start() {
        if (this.af) {
            com.baidu.crabsdk.c.a.cb("Block monitoring has already started!");
            return;
        }
        this.af = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.Ph.Pi);
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
        this.Ph.Pj.stop();
        com.baidu.crabsdk.c.a.cb("Stop main-thread block monitoring!");
    }
}
