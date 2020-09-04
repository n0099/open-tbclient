package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes6.dex */
public final class d extends Thread {
    private static boolean bC = false;
    private final Context amC;
    private final SoftReference<Looper> aoI;
    private SoftReference<Handler> aoJ;
    private final int aoK;
    private volatile int aoL;
    private a aoM;
    private final Runnable aoN;

    private d(Context context, int i) {
        this.aoI = new SoftReference<>(Looper.getMainLooper());
        this.aoL = 0;
        this.aoN = new e(this);
        this.amC = context;
        this.aoK = 3000;
        switch (i) {
            case 1:
                this.aoM = new b(context);
                return;
            case 2:
                this.aoM = new c(context);
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
        com.baidu.crabsdk.c.a.dt("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.aoL;
            if (this.aoI.get() == null) {
                bC = false;
                break;
            }
            try {
                if (this.aoJ == null || this.aoJ.get() == null) {
                    this.aoJ = new SoftReference<>(new Handler(this.aoI.get()));
                }
                this.aoJ.get().post(this.aoN);
                Thread.sleep(this.aoK);
                if (com.baidu.crabsdk.a.I == 0) {
                    bC = false;
                    com.baidu.crabsdk.c.a.du("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.aoL != i);
        if (this.amC != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.dt("onAppNotResponding!");
            if (this.aoM != null) {
                this.aoM.e("/data/anr/traces.txt");
            }
        }
        bC = false;
        bC = false;
        com.baidu.crabsdk.c.a.du("anr watch thread is over!");
    }
}
