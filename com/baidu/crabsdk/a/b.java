package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes3.dex */
public final class b {
    private static b YL;
    private c YM;
    private boolean af = false;

    private b(Context context) {
        this.YM = c.as(context);
    }

    public static b aq(Context context) {
        return ar(context);
    }

    private static b ar(Context context) {
        if (YL == null) {
            synchronized (b.class) {
                if (YL == null) {
                    YL = new b(context);
                }
            }
        }
        return YL;
    }

    public static b qF() {
        return YL;
    }

    public final void start() {
        if (this.af) {
            com.baidu.crabsdk.c.a.cf("Block monitoring has already started!");
            return;
        }
        this.af = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.YM.YN);
            com.baidu.crabsdk.c.a.cf("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.af) {
            com.baidu.crabsdk.c.a.cf("Block monitoring is not enabled!");
            return;
        }
        this.af = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.YM.YO.stop();
        com.baidu.crabsdk.c.a.cf("Stop main-thread block monitoring!");
    }
}
