package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes8.dex */
public final class d extends Thread {
    private static boolean akL = false;
    private final Context ajv;
    private final SoftReference<Looper> akM;
    private SoftReference<Handler> akN;
    private final int akO;
    private volatile int akP;
    private a akQ;
    private final Runnable akR;

    private d(Context context, int i) {
        this.akM = new SoftReference<>(Looper.getMainLooper());
        this.akP = 0;
        this.akR = new e(this);
        this.ajv = context;
        this.akO = 3000;
        switch (i) {
            case 1:
                this.akQ = new b(context);
                return;
            case 2:
                this.akQ = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + akL + "***");
        if (akL) {
            return;
        }
        akL = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.de("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.akP;
            if (this.akM.get() == null) {
                akL = false;
                break;
            }
            try {
                if (this.akN == null || this.akN.get() == null) {
                    this.akN = new SoftReference<>(new Handler(this.akM.get()));
                }
                this.akN.get().post(this.akR);
                Thread.sleep(this.akO);
                if (com.baidu.crabsdk.a.I == 0) {
                    akL = false;
                    com.baidu.crabsdk.c.a.df("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.akP != i);
        if (this.ajv != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.de("onAppNotResponding!");
            if (this.akQ != null) {
                this.akQ.e("/data/anr/traces.txt");
            }
        }
        akL = false;
        akL = false;
        com.baidu.crabsdk.c.a.df("anr watch thread is over!");
    }
}
