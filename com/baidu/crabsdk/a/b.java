package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes8.dex */
public final class b {
    private static b aka;
    private boolean ah = false;
    private c akb;

    private b(Context context) {
        this.akb = c.X(context);
    }

    public static b V(Context context) {
        return W(context);
    }

    private static b W(Context context) {
        if (aka == null) {
            synchronized (b.class) {
                if (aka == null) {
                    aka = new b(context);
                }
            }
        }
        return aka;
    }

    public static b sE() {
        return aka;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.dg("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.akb.akc);
            com.baidu.crabsdk.c.a.dg("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.dg("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.akb.akd.stop();
        com.baidu.crabsdk.c.a.dg("Stop main-thread block monitoring!");
    }
}
