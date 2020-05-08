package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes8.dex */
public final class b {
    private static b ajw;
    private boolean ah = false;
    private c ajx;

    private b(Context context) {
        this.ajx = c.U(context);
    }

    public static b S(Context context) {
        return T(context);
    }

    private static b T(Context context) {
        if (ajw == null) {
            synchronized (b.class) {
                if (ajw == null) {
                    ajw = new b(context);
                }
            }
        }
        return ajw;
    }

    public static b su() {
        return ajw;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.de("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.ajx.ajy);
            com.baidu.crabsdk.c.a.de("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.de("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.ajx.ajz.stop();
        com.baidu.crabsdk.c.a.de("Stop main-thread block monitoring!");
    }
}
