package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes14.dex */
public final class d extends Thread {
    private static boolean aqG = false;
    private final Context aov;
    private final SoftReference<Looper> aqH;
    private SoftReference<Handler> aqI;
    private final int aqJ;
    private volatile int aqK;
    private a aqL;
    private final Runnable aqM;

    private d(Context context, int i) {
        this.aqH = new SoftReference<>(Looper.getMainLooper());
        this.aqK = 0;
        this.aqM = new e(this);
        this.aov = context;
        this.aqJ = 3000;
        switch (i) {
            case 1:
                this.aqL = new b(context);
                return;
            case 2:
                this.aqL = new c(context);
                return;
            default:
                return;
        }
    }

    public d(Context context, int i, byte b2) {
        this(context, i);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int i;
        com.baidu.crabsdk.c.a.v("***isRunning = " + aqG + "***");
        if (aqG) {
            return;
        }
        aqG = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.ds("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.aqK;
            if (this.aqH.get() == null) {
                aqG = false;
                break;
            }
            try {
                if (this.aqI == null || this.aqI.get() == null) {
                    this.aqI = new SoftReference<>(new Handler(this.aqH.get()));
                }
                this.aqI.get().post(this.aqM);
                Thread.sleep(this.aqJ);
                if (com.baidu.crabsdk.a.I == 0) {
                    aqG = false;
                    com.baidu.crabsdk.c.a.dt("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.aqK != i);
        if (this.aov != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.ds("onAppNotResponding!");
            if (this.aqL != null) {
                this.aqL.e("/data/anr/traces.txt");
            }
        }
        aqG = false;
        aqG = false;
        com.baidu.crabsdk.c.a.dt("anr watch thread is over!");
    }
}
