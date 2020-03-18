package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes8.dex */
public final class d extends Thread {
    private static boolean Sv = false;
    private final Context QX;
    private a SA;
    private final Runnable SB;
    private final SoftReference<Looper> Sw;
    private SoftReference<Handler> Sx;
    private final int Sy;
    private volatile int Sz;

    private d(Context context, int i) {
        this.Sw = new SoftReference<>(Looper.getMainLooper());
        this.Sz = 0;
        this.SB = new e(this);
        this.QX = context;
        this.Sy = 3000;
        switch (i) {
            case 1:
                this.SA = new b(context);
                return;
            case 2:
                this.SA = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + Sv + "***");
        if (Sv) {
            return;
        }
        Sv = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.cj("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.Sz;
            if (this.Sw.get() == null) {
                Sv = false;
                break;
            }
            try {
                if (this.Sx == null || this.Sx.get() == null) {
                    this.Sx = new SoftReference<>(new Handler(this.Sw.get()));
                }
                this.Sx.get().post(this.SB);
                Thread.sleep(this.Sy);
                if (com.baidu.crabsdk.a.I == 0) {
                    Sv = false;
                    com.baidu.crabsdk.c.a.ck("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.Sz != i);
        if (this.QX != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.cj("onAppNotResponding!");
            if (this.SA != null) {
                this.SA.e("/data/anr/traces.txt");
            }
        }
        Sv = false;
        Sv = false;
        com.baidu.crabsdk.c.a.ck("anr watch thread is over!");
    }
}
