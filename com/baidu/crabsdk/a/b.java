package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes6.dex */
public final class b {
    private static b amv;
    private boolean ah = false;
    private c amw;

    private b(Context context) {
        this.amw = c.aa(context);
    }

    public static b Y(Context context) {
        return Z(context);
    }

    private static b Z(Context context) {
        if (amv == null) {
            synchronized (b.class) {
                if (amv == null) {
                    amv = new b(context);
                }
            }
        }
        return amv;
    }

    public static b uJ() {
        return amv;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.ds("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.amw.amx);
            com.baidu.crabsdk.c.a.ds("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.ds("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.amw.amy.stop();
        com.baidu.crabsdk.c.a.ds("Stop main-thread block monitoring!");
    }
}
