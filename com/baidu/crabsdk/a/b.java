package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes8.dex */
public final class b {
    private static b alx;
    private boolean ah = false;
    private c aly;

    private b(Context context) {
        this.aly = c.Y(context);
    }

    public static b W(Context context) {
        return X(context);
    }

    private static b X(Context context) {
        if (alx == null) {
            synchronized (b.class) {
                if (alx == null) {
                    alx = new b(context);
                }
            }
        }
        return alx;
    }

    public static b sZ() {
        return alx;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.di("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.aly.alz);
            com.baidu.crabsdk.c.a.di("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.di("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.aly.alA.stop();
        com.baidu.crabsdk.c.a.di("Stop main-thread block monitoring!");
    }
}
