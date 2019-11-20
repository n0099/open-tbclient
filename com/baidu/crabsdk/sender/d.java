package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes3.dex */
public final class d extends Thread {
    private static boolean Kf = false;
    private final Context II;
    private final SoftReference<Looper> Kg;
    private SoftReference<Handler> Kh;
    private final int Ki;
    private volatile int Kj;
    private a Kk;
    private final Runnable Kl;

    private d(Context context, int i) {
        this.Kg = new SoftReference<>(Looper.getMainLooper());
        this.Kj = 0;
        this.Kl = new e(this);
        this.II = context;
        this.Ki = 3000;
        switch (i) {
            case 1:
                this.Kk = new b(context);
                return;
            case 2:
                this.Kk = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + Kf + "***");
        if (Kf) {
            return;
        }
        Kf = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.bu("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.Kj;
            if (this.Kg.get() == null) {
                Kf = false;
                break;
            }
            try {
                if (this.Kh == null || this.Kh.get() == null) {
                    this.Kh = new SoftReference<>(new Handler(this.Kg.get()));
                }
                this.Kh.get().post(this.Kl);
                Thread.sleep(this.Ki);
                if (com.baidu.crabsdk.a.I == 0) {
                    Kf = false;
                    com.baidu.crabsdk.c.a.bw("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.Kj != i);
        if (this.II != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.bu("onAppNotResponding!");
            if (this.Kk != null) {
                this.Kk.d("/data/anr/traces.txt");
            }
        }
        Kf = false;
        Kf = false;
        com.baidu.crabsdk.c.a.bw("anr watch thread is over!");
    }
}
