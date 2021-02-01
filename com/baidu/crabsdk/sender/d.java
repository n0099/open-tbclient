package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes5.dex */
public final class d extends Thread {
    private static boolean aqw = false;
    private final Context aol;
    private volatile int aqA;
    private a aqB;
    private final Runnable aqC;
    private final SoftReference<Looper> aqx;
    private SoftReference<Handler> aqy;
    private final int aqz;

    private d(Context context, int i) {
        this.aqx = new SoftReference<>(Looper.getMainLooper());
        this.aqA = 0;
        this.aqC = new e(this);
        this.aol = context;
        this.aqz = 3000;
        switch (i) {
            case 1:
                this.aqB = new b(context);
                return;
            case 2:
                this.aqB = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + aqw + "***");
        if (aqw) {
            return;
        }
        aqw = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.ds("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.aqA;
            if (this.aqx.get() == null) {
                aqw = false;
                break;
            }
            try {
                if (this.aqy == null || this.aqy.get() == null) {
                    this.aqy = new SoftReference<>(new Handler(this.aqx.get()));
                }
                this.aqy.get().post(this.aqC);
                Thread.sleep(this.aqz);
                if (com.baidu.crabsdk.a.I == 0) {
                    aqw = false;
                    com.baidu.crabsdk.c.a.dt("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.aqA != i);
        if (this.aol != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.ds("onAppNotResponding!");
            if (this.aqB != null) {
                this.aqB.e("/data/anr/traces.txt");
            }
        }
        aqw = false;
        aqw = false;
        com.baidu.crabsdk.c.a.dt("anr watch thread is over!");
    }
}
