package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes12.dex */
public final class b {
    private static b als;
    private boolean ah = false;
    private c alt;

    private b(Context context) {
        this.alt = c.Y(context);
    }

    public static b W(Context context) {
        return X(context);
    }

    private static b X(Context context) {
        if (als == null) {
            synchronized (b.class) {
                if (als == null) {
                    als = new b(context);
                }
            }
        }
        return als;
    }

    public static b tb() {
        return als;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.dh("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.alt.alu);
            com.baidu.crabsdk.c.a.dh("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.dh("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.alt.alv.stop();
        com.baidu.crabsdk.c.a.dh("Stop main-thread block monitoring!");
    }
}
