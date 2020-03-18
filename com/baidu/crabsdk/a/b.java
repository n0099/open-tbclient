package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes8.dex */
public final class b {
    private static b QS;
    private c QT;
    private boolean ah = false;

    private b(Context context) {
        this.QT = c.as(context);
    }

    public static b aq(Context context) {
        return ar(context);
    }

    private static b ar(Context context) {
        if (QS == null) {
            synchronized (b.class) {
                if (QS == null) {
                    QS = new b(context);
                }
            }
        }
        return QS;
    }

    public static b oa() {
        return QS;
    }

    public final void start() {
        if (this.ah) {
            com.baidu.crabsdk.c.a.cj("Block monitoring has already started!");
            return;
        }
        this.ah = true;
        try {
            Looper.getMainLooper().setMessageLogging(this.QT.QU);
            com.baidu.crabsdk.c.a.cj("Start main-thread block monitoring!");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("setMessageLogging error!!", e);
        }
    }

    public final void stop() {
        if (!this.ah) {
            com.baidu.crabsdk.c.a.cj("Block monitoring is not enabled!");
            return;
        }
        this.ah = false;
        Looper.getMainLooper().setMessageLogging(null);
        this.QT.QV.stop();
        com.baidu.crabsdk.c.a.cj("Stop main-thread block monitoring!");
    }
}
