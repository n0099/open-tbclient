package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes12.dex */
public final class d extends Thread {
    private static boolean anJ = false;
    private final Context alx;
    private final SoftReference<Looper> anK;
    private SoftReference<Handler> anL;
    private final int anM;
    private volatile int anN;
    private a anO;
    private final Runnable anP;

    private d(Context context, int i) {
        this.anK = new SoftReference<>(Looper.getMainLooper());
        this.anN = 0;
        this.anP = new e(this);
        this.alx = context;
        this.anM = 3000;
        switch (i) {
            case 1:
                this.anO = new b(context);
                return;
            case 2:
                this.anO = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + anJ + "***");
        if (anJ) {
            return;
        }
        anJ = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.dh("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.anN;
            if (this.anK.get() == null) {
                anJ = false;
                break;
            }
            try {
                if (this.anL == null || this.anL.get() == null) {
                    this.anL = new SoftReference<>(new Handler(this.anK.get()));
                }
                this.anL.get().post(this.anP);
                Thread.sleep(this.anM);
                if (com.baidu.crabsdk.a.I == 0) {
                    anJ = false;
                    com.baidu.crabsdk.c.a.di("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.anN != i);
        if (this.alx != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.dh("onAppNotResponding!");
            if (this.anO != null) {
                this.anO.e("/data/anr/traces.txt");
            }
        }
        anJ = false;
        anJ = false;
        com.baidu.crabsdk.c.a.di("anr watch thread is over!");
    }
}
