package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes3.dex */
public final class d extends Thread {
    private static boolean KF = false;
    private final Context Jl;
    private final SoftReference<Looper> KG;
    private SoftReference<Handler> KH;
    private final int KI;
    private volatile int KJ;
    private a KK;
    private final Runnable KL;

    private d(Context context, int i) {
        this.KG = new SoftReference<>(Looper.getMainLooper());
        this.KJ = 0;
        this.KL = new e(this);
        this.Jl = context;
        this.KI = 3000;
        switch (i) {
            case 1:
                this.KK = new b(context);
                return;
            case 2:
                this.KK = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + KF + "***");
        if (KF) {
            return;
        }
        KF = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.bu("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.KJ;
            if (this.KG.get() == null) {
                KF = false;
                break;
            }
            try {
                if (this.KH == null || this.KH.get() == null) {
                    this.KH = new SoftReference<>(new Handler(this.KG.get()));
                }
                this.KH.get().post(this.KL);
                Thread.sleep(this.KI);
                if (com.baidu.crabsdk.a.I == 0) {
                    KF = false;
                    com.baidu.crabsdk.c.a.bw("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.KJ != i);
        if (this.Jl != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.bu("onAppNotResponding!");
            if (this.KK != null) {
                this.KK.d("/data/anr/traces.txt");
            }
        }
        KF = false;
        KF = false;
        com.baidu.crabsdk.c.a.bw("anr watch thread is over!");
    }
}
