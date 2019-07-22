package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes3.dex */
public final class d extends Thread {
    private static boolean aaz = false;
    private final Context Zl;
    private final SoftReference<Looper> aaA;
    private SoftReference<Handler> aaB;
    private final int aaC;
    private volatile int aaD;
    private a aaE;
    private final Runnable aaF;

    private d(Context context, int i) {
        this.aaA = new SoftReference<>(Looper.getMainLooper());
        this.aaD = 0;
        this.aaF = new e(this);
        this.Zl = context;
        this.aaC = 3000;
        switch (i) {
            case 1:
                this.aaE = new b(context);
                return;
            case 2:
                this.aaE = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + aaz + "***");
        if (aaz) {
            return;
        }
        aaz = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.ch("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.aaD;
            if (this.aaA.get() == null) {
                aaz = false;
                break;
            }
            try {
                if (this.aaB == null || this.aaB.get() == null) {
                    this.aaB = new SoftReference<>(new Handler(this.aaA.get()));
                }
                this.aaB.get().post(this.aaF);
                Thread.sleep(this.aaC);
                if (com.baidu.crabsdk.a.I == 0) {
                    aaz = false;
                    com.baidu.crabsdk.c.a.cj("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.aaD != i);
        if (this.Zl != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.ch("onAppNotResponding!");
            if (this.aaE != null) {
                this.aaE.d("/data/anr/traces.txt");
            }
        }
        aaz = false;
        aaz = false;
        com.baidu.crabsdk.c.a.cj("anr watch thread is over!");
    }
}
