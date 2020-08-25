package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes6.dex */
public final class d extends Thread {
    private static boolean bC = false;
    private final Context amA;
    private final SoftReference<Looper> aoG;
    private SoftReference<Handler> aoH;
    private final int aoI;
    private volatile int aoJ;
    private a aoK;
    private final Runnable aoL;

    private d(Context context, int i) {
        this.aoG = new SoftReference<>(Looper.getMainLooper());
        this.aoJ = 0;
        this.aoL = new e(this);
        this.amA = context;
        this.aoI = 3000;
        switch (i) {
            case 1:
                this.aoK = new b(context);
                return;
            case 2:
                this.aoK = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + bC + "***");
        if (bC) {
            return;
        }
        bC = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.ds("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.aoJ;
            if (this.aoG.get() == null) {
                bC = false;
                break;
            }
            try {
                if (this.aoH == null || this.aoH.get() == null) {
                    this.aoH = new SoftReference<>(new Handler(this.aoG.get()));
                }
                this.aoH.get().post(this.aoL);
                Thread.sleep(this.aoI);
                if (com.baidu.crabsdk.a.I == 0) {
                    bC = false;
                    com.baidu.crabsdk.c.a.dt("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.aoJ != i);
        if (this.amA != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.ds("onAppNotResponding!");
            if (this.aoK != null) {
                this.aoK.e("/data/anr/traces.txt");
            }
        }
        bC = false;
        bC = false;
        com.baidu.crabsdk.c.a.dt("anr watch thread is over!");
    }
}
