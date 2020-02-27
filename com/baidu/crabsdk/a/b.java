package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes8.dex */
public final class b {
    private static b QO;
    private c QP;
    private boolean af = false;

    private b(Context context) {
        this.QP = c.as(context);
    }

    public static b aq(Context context) {
        return ar(context);
    }

    private static b ar(Context context) {
        if (QO == null) {
            synchronized (b.class) {
                if (QO == null) {
                    QO = new b(context);
                }
            }
        }
        return QO;
    }

    public static b oa() {
        return QO;
    }

    public final void start() {
        if (this.af) {
            com.baidu.crabsdk.c.a.cj("Block monitoring has already started!");
            return;
        }
        this.af = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.QP.QR);
            com.baidu.crabsdk.c.a.cj("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.af) {
            com.baidu.crabsdk.c.a.cj("Block monitoring is not enabled!");
            return;
        }
        this.af = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.QP.QS.stop();
        com.baidu.crabsdk.c.a.cj("Stop main-thread block monitoring!");
    }
}
