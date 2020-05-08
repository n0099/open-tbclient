package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes8.dex */
public final class d extends Thread {
    private static boolean akR = false;
    private final Context ajB;
    private final SoftReference<Looper> akS;
    private SoftReference<Handler> akT;
    private final int akU;
    private volatile int akV;
    private a akW;
    private final Runnable akX;

    private d(Context context, int i) {
        this.akS = new SoftReference<>(Looper.getMainLooper());
        this.akV = 0;
        this.akX = new e(this);
        this.ajB = context;
        this.akU = 3000;
        switch (i) {
            case 1:
                this.akW = new b(context);
                return;
            case 2:
                this.akW = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + akR + "***");
        if (akR) {
            return;
        }
        akR = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.de("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.akV;
            if (this.akS.get() == null) {
                akR = false;
                break;
            }
            try {
                if (this.akT == null || this.akT.get() == null) {
                    this.akT = new SoftReference<>(new Handler(this.akS.get()));
                }
                this.akT.get().post(this.akX);
                Thread.sleep(this.akU);
                if (com.baidu.crabsdk.a.I == 0) {
                    akR = false;
                    com.baidu.crabsdk.c.a.df("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.akV != i);
        if (this.ajB != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.de("onAppNotResponding!");
            if (this.akW != null) {
                this.akW.e("/data/anr/traces.txt");
            }
        }
        akR = false;
        akR = false;
        com.baidu.crabsdk.c.a.df("anr watch thread is over!");
    }
}
