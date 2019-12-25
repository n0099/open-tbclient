package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes5.dex */
public final class d extends Thread {
    private static boolean QJ = false;
    private final Context Ph;
    private final SoftReference<Looper> QK;
    private SoftReference<Handler> QL;
    private final int QM;
    private volatile int QN;
    private a QO;
    private final Runnable QP;

    private d(Context context, int i) {
        this.QK = new SoftReference<>(Looper.getMainLooper());
        this.QN = 0;
        this.QP = new e(this);
        this.Ph = context;
        this.QM = 3000;
        switch (i) {
            case 1:
                this.QO = new b(context);
                return;
            case 2:
                this.QO = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + QJ + "***");
        if (QJ) {
            return;
        }
        QJ = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.cb("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.QN;
            if (this.QK.get() == null) {
                QJ = false;
                break;
            }
            try {
                if (this.QL == null || this.QL.get() == null) {
                    this.QL = new SoftReference<>(new Handler(this.QK.get()));
                }
                this.QL.get().post(this.QP);
                Thread.sleep(this.QM);
                if (com.baidu.crabsdk.a.I == 0) {
                    QJ = false;
                    com.baidu.crabsdk.c.a.cd("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.QN != i);
        if (this.Ph != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.cb("onAppNotResponding!");
            if (this.QO != null) {
                this.QO.d("/data/anr/traces.txt");
            }
        }
        QJ = false;
        QJ = false;
        com.baidu.crabsdk.c.a.cd("anr watch thread is over!");
    }
}
