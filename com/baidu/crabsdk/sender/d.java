package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes8.dex */
public final class d extends Thread {
    private static boolean St = false;
    private final Context QU;
    private final SoftReference<Looper> Su;
    private SoftReference<Handler> Sv;
    private final int Sw;
    private volatile int Sx;
    private a Sy;
    private final Runnable Sz;

    private d(Context context, int i) {
        this.Su = new SoftReference<>(Looper.getMainLooper());
        this.Sx = 0;
        this.Sz = new e(this);
        this.QU = context;
        this.Sw = 3000;
        switch (i) {
            case 1:
                this.Sy = new b(context);
                return;
            case 2:
                this.Sy = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + St + "***");
        if (St) {
            return;
        }
        St = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.cj("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.Sx;
            if (this.Su.get() == null) {
                St = false;
                break;
            }
            try {
                if (this.Sv == null || this.Sv.get() == null) {
                    this.Sv = new SoftReference<>(new Handler(this.Su.get()));
                }
                this.Sv.get().post(this.Sz);
                Thread.sleep(this.Sw);
                if (com.baidu.crabsdk.a.I == 0) {
                    St = false;
                    com.baidu.crabsdk.c.a.cl("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.Sx != i);
        if (this.QU != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.cj("onAppNotResponding!");
            if (this.Sy != null) {
                this.Sy.d("/data/anr/traces.txt");
            }
        }
        St = false;
        St = false;
        com.baidu.crabsdk.c.a.cl("anr watch thread is over!");
    }
}
