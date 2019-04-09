package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes3.dex */
public final class d extends Thread {
    private static boolean aco = false;
    private final Context aaZ;
    private final SoftReference<Looper> acp;
    private SoftReference<Handler> acq;
    private final int acr;
    private volatile int acs;
    private a act;
    private final Runnable acu;

    private d(Context context, int i) {
        this.acp = new SoftReference<>(Looper.getMainLooper());
        this.acs = 0;
        this.acu = new e(this);
        this.aaZ = context;
        this.acr = 3000;
        switch (i) {
            case 1:
                this.act = new b(context);
                return;
            case 2:
                this.act = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + aco + "***");
        if (aco) {
            return;
        }
        aco = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.cv("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.acs;
            if (this.acp.get() == null) {
                aco = false;
                break;
            }
            try {
                if (this.acq == null || this.acq.get() == null) {
                    this.acq = new SoftReference<>(new Handler(this.acp.get()));
                }
                this.acq.get().post(this.acu);
                Thread.sleep(this.acr);
                if (com.baidu.crabsdk.a.I == 0) {
                    aco = false;
                    com.baidu.crabsdk.c.a.cx("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.acs != i);
        if (this.aaZ != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.cv("onAppNotResponding!");
            if (this.act != null) {
                this.act.d("/data/anr/traces.txt");
            }
        }
        aco = false;
        aco = false;
        com.baidu.crabsdk.c.a.cx("anr watch thread is over!");
    }
}
