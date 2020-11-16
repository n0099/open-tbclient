package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes7.dex */
public final class d extends Thread {
    private static boolean bC = false;
    private final Context anU;
    private final SoftReference<Looper> aqc;
    private SoftReference<Handler> aqd;
    private final int aqe;
    private volatile int aqf;
    private a aqg;
    private final Runnable aqh;

    private d(Context context, int i) {
        this.aqc = new SoftReference<>(Looper.getMainLooper());
        this.aqf = 0;
        this.aqh = new e(this);
        this.anU = context;
        this.aqe = 3000;
        switch (i) {
            case 1:
                this.aqg = new b(context);
                return;
            case 2:
                this.aqg = new c(context);
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
        com.baidu.crabsdk.c.a.dC("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.aqf;
            if (this.aqc.get() == null) {
                bC = false;
                break;
            }
            try {
                if (this.aqd == null || this.aqd.get() == null) {
                    this.aqd = new SoftReference<>(new Handler(this.aqc.get()));
                }
                this.aqd.get().post(this.aqh);
                Thread.sleep(this.aqe);
                if (com.baidu.crabsdk.a.I == 0) {
                    bC = false;
                    com.baidu.crabsdk.c.a.dD("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.aqf != i);
        if (this.anU != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.dC("onAppNotResponding!");
            if (this.aqg != null) {
                this.aqg.e("/data/anr/traces.txt");
            }
        }
        bC = false;
        bC = false;
        com.baidu.crabsdk.c.a.dD("anr watch thread is over!");
    }
}
