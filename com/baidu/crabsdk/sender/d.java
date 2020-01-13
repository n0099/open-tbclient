package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes6.dex */
public final class d extends Thread {
    private static boolean QN = false;
    private final Context Pl;
    private final SoftReference<Looper> QO;
    private SoftReference<Handler> QP;
    private final int QR;
    private volatile int QS;
    private a QT;
    private final Runnable QU;

    private d(Context context, int i) {
        this.QO = new SoftReference<>(Looper.getMainLooper());
        this.QS = 0;
        this.QU = new e(this);
        this.Pl = context;
        this.QR = 3000;
        switch (i) {
            case 1:
                this.QT = new b(context);
                return;
            case 2:
                this.QT = new c(context);
                return;
            default:
                return;
        }
    }

    public d(Context context, int i, byte b) {
        this(context, i);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int i;
        com.baidu.crabsdk.c.a.v("***isRunning = " + QN + "***");
        if (QN) {
            return;
        }
        QN = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.cb("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.QS;
            if (this.QO.get() == null) {
                QN = false;
                break;
            }
            try {
                if (this.QP == null || this.QP.get() == null) {
                    this.QP = new SoftReference<>(new Handler(this.QO.get()));
                }
                this.QP.get().post(this.QU);
                Thread.sleep(this.QR);
                if (com.baidu.crabsdk.a.I == 0) {
                    QN = false;
                    com.baidu.crabsdk.c.a.cd("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.QS != i);
        if (this.Pl != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.cb("onAppNotResponding!");
            if (this.QT != null) {
                this.QT.d("/data/anr/traces.txt");
            }
        }
        QN = false;
        QN = false;
        com.baidu.crabsdk.c.a.cd("anr watch thread is over!");
    }
}
