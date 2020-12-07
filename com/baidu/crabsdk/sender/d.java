package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes8.dex */
public final class d extends Thread {
    private static boolean aqX = false;
    private final Context aoI;
    private final SoftReference<Looper> aqY;
    private SoftReference<Handler> aqZ;
    private final int ara;
    private volatile int arb;
    private a arc;
    private final Runnable ard;

    private d(Context context, int i) {
        this.aqY = new SoftReference<>(Looper.getMainLooper());
        this.arb = 0;
        this.ard = new e(this);
        this.aoI = context;
        this.ara = 3000;
        switch (i) {
            case 1:
                this.arc = new b(context);
                return;
            case 2:
                this.arc = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + aqX + "***");
        if (aqX) {
            return;
        }
        aqX = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.dE("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.arb;
            if (this.aqY.get() == null) {
                aqX = false;
                break;
            }
            try {
                if (this.aqZ == null || this.aqZ.get() == null) {
                    this.aqZ = new SoftReference<>(new Handler(this.aqY.get()));
                }
                this.aqZ.get().post(this.ard);
                Thread.sleep(this.ara);
                if (com.baidu.crabsdk.a.I == 0) {
                    aqX = false;
                    com.baidu.crabsdk.c.a.dF("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.arb != i);
        if (this.aoI != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.dE("onAppNotResponding!");
            if (this.arc != null) {
                this.arc.e("/data/anr/traces.txt");
            }
        }
        aqX = false;
        aqX = false;
        com.baidu.crabsdk.c.a.dF("anr watch thread is over!");
    }
}
