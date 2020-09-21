package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes8.dex */
public final class d extends Thread {
    private static boolean bC = false;
    private final Context ane;
    private final SoftReference<Looper> apl;
    private SoftReference<Handler> apm;
    private final int apn;
    private volatile int apo;
    private a apq;
    private final Runnable apr;

    private d(Context context, int i) {
        this.apl = new SoftReference<>(Looper.getMainLooper());
        this.apo = 0;
        this.apr = new e(this);
        this.ane = context;
        this.apn = 3000;
        switch (i) {
            case 1:
                this.apq = new b(context);
                return;
            case 2:
                this.apq = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + bC + "***");
        if (bC) {
            return;
        }
        bC = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.dv("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.apo;
            if (this.apl.get() == null) {
                bC = false;
                break;
            }
            try {
                if (this.apm == null || this.apm.get() == null) {
                    this.apm = new SoftReference<>(new Handler(this.apl.get()));
                }
                this.apm.get().post(this.apr);
                Thread.sleep(this.apn);
                if (com.baidu.crabsdk.a.I == 0) {
                    bC = false;
                    com.baidu.crabsdk.c.a.dw("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.apo != i);
        if (this.ane != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.dv("onAppNotResponding!");
            if (this.apq != null) {
                this.apq.e("/data/anr/traces.txt");
            }
        }
        bC = false;
        bC = false;
        com.baidu.crabsdk.c.a.dw("anr watch thread is over!");
    }
}
