package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes3.dex */
public final class b {
    private static b Zg;
    private c Zh;
    private boolean af = false;

    private b(Context context) {
        this.Zh = c.as(context);
    }

    public static b aq(Context context) {
        return ar(context);
    }

    private static b ar(Context context) {
        if (Zg == null) {
            synchronized (b.class) {
                if (Zg == null) {
                    Zg = new b(context);
                }
            }
        }
        return Zg;
    }

    public static b rc() {
        return Zg;
    }

    public final void start() {
        if (this.af) {
            com.baidu.crabsdk.c.a.ch("Block monitoring has already started!");
            return;
        }
        this.af = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.Zh.Zi);
            com.baidu.crabsdk.c.a.ch("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.af) {
            com.baidu.crabsdk.c.a.ch("Block monitoring is not enabled!");
            return;
        }
        this.af = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.Zh.Zj.stop();
        com.baidu.crabsdk.c.a.ch("Stop main-thread block monitoring!");
    }
}
