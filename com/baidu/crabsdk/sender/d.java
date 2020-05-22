package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes8.dex */
public final class d extends Thread {
    private static boolean amu = false;
    private final Context akf;
    private final Runnable amA;
    private final SoftReference<Looper> amv;
    private SoftReference<Handler> amw;
    private final int amx;
    private volatile int amy;
    private a amz;

    private d(Context context, int i) {
        this.amv = new SoftReference<>(Looper.getMainLooper());
        this.amy = 0;
        this.amA = new e(this);
        this.akf = context;
        this.amx = 3000;
        switch (i) {
            case 1:
                this.amz = new b(context);
                return;
            case 2:
                this.amz = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + amu + "***");
        if (amu) {
            return;
        }
        amu = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.dg("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.amy;
            if (this.amv.get() == null) {
                amu = false;
                break;
            }
            try {
                if (this.amw == null || this.amw.get() == null) {
                    this.amw = new SoftReference<>(new Handler(this.amv.get()));
                }
                this.amw.get().post(this.amA);
                Thread.sleep(this.amx);
                if (com.baidu.crabsdk.a.I == 0) {
                    amu = false;
                    com.baidu.crabsdk.c.a.dh("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.amy != i);
        if (this.akf != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.dg("onAppNotResponding!");
            if (this.amz != null) {
                this.amz.e("/data/anr/traces.txt");
            }
        }
        amu = false;
        amu = false;
        com.baidu.crabsdk.c.a.dh("anr watch thread is over!");
    }
}
