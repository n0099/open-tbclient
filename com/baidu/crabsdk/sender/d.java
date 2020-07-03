package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes8.dex */
public final class d extends Thread {
    private static boolean anN = false;
    private final Context alC;
    private final SoftReference<Looper> anO;
    private SoftReference<Handler> anP;
    private final int anQ;
    private volatile int anR;
    private a anS;
    private final Runnable anT;

    private d(Context context, int i) {
        this.anO = new SoftReference<>(Looper.getMainLooper());
        this.anR = 0;
        this.anT = new e(this);
        this.alC = context;
        this.anQ = 3000;
        switch (i) {
            case 1:
                this.anS = new b(context);
                return;
            case 2:
                this.anS = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + anN + "***");
        if (anN) {
            return;
        }
        anN = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.di("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.anR;
            if (this.anO.get() == null) {
                anN = false;
                break;
            }
            try {
                if (this.anP == null || this.anP.get() == null) {
                    this.anP = new SoftReference<>(new Handler(this.anO.get()));
                }
                this.anP.get().post(this.anT);
                Thread.sleep(this.anQ);
                if (com.baidu.crabsdk.a.I == 0) {
                    anN = false;
                    com.baidu.crabsdk.c.a.dj("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.anR != i);
        if (this.alC != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.di("onAppNotResponding!");
            if (this.anS != null) {
                this.anS.e("/data/anr/traces.txt");
            }
        }
        anN = false;
        anN = false;
        com.baidu.crabsdk.c.a.dj("anr watch thread is over!");
    }
}
