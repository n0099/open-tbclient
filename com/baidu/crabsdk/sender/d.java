package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes3.dex */
public final class d extends Thread {
    private static boolean acn = false;
    private final Context aaY;
    private final SoftReference<Looper> aco;
    private SoftReference<Handler> acp;
    private final int acq;
    private volatile int acr;
    private a acs;
    private final Runnable act;

    private d(Context context, int i) {
        this.aco = new SoftReference<>(Looper.getMainLooper());
        this.acr = 0;
        this.act = new e(this);
        this.aaY = context;
        this.acq = 3000;
        switch (i) {
            case 1:
                this.acs = new b(context);
                return;
            case 2:
                this.acs = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + acn + "***");
        if (acn) {
            return;
        }
        acn = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.cv("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.acr;
            if (this.aco.get() == null) {
                acn = false;
                break;
            }
            try {
                if (this.acp == null || this.acp.get() == null) {
                    this.acp = new SoftReference<>(new Handler(this.aco.get()));
                }
                this.acp.get().post(this.act);
                Thread.sleep(this.acq);
                if (com.baidu.crabsdk.a.I == 0) {
                    acn = false;
                    com.baidu.crabsdk.c.a.cx("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.acr != i);
        if (this.aaY != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.cv("onAppNotResponding!");
            if (this.acs != null) {
                this.acs.d("/data/anr/traces.txt");
            }
        }
        acn = false;
        acn = false;
        com.baidu.crabsdk.c.a.cx("anr watch thread is over!");
    }
}
