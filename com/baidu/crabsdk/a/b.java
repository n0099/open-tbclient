package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes6.dex */
public final class b {
    private static b amx;
    private boolean ah = false;
    private c amy;

    private b(Context context) {
        this.amy = c.aa(context);
    }

    public static b Y(Context context) {
        return Z(context);
    }

    private static b Z(Context context) {
        if (amx == null) {
            synchronized (b.class) {
                if (amx == null) {
                    amx = new b(context);
                }
            }
        }
        return amx;
    }

    public static b uJ() {
        return amx;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.dt("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.amy.amz);
            com.baidu.crabsdk.c.a.dt("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.dt("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.amy.amA.stop();
        com.baidu.crabsdk.c.a.dt("Stop main-thread block monitoring!");
    }
}
