package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes3.dex */
public final class d extends Thread {
    private static boolean aad = false;
    private final Context YR;
    private final SoftReference<Looper> aae;
    private SoftReference<Handler> aaf;
    private final int aag;
    private volatile int aah;
    private a aai;
    private final Runnable aaj;

    private d(Context context, int i) {
        this.aae = new SoftReference<>(Looper.getMainLooper());
        this.aah = 0;
        this.aaj = new e(this);
        this.YR = context;
        this.aag = 3000;
        switch (i) {
            case 1:
                this.aai = new b(context);
                return;
            case 2:
                this.aai = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + aad + "***");
        if (aad) {
            return;
        }
        aad = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.cf("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.aah;
            if (this.aae.get() == null) {
                aad = false;
                break;
            }
            try {
                if (this.aaf == null || this.aaf.get() == null) {
                    this.aaf = new SoftReference<>(new Handler(this.aae.get()));
                }
                this.aaf.get().post(this.aaj);
                Thread.sleep(this.aag);
                if (com.baidu.crabsdk.a.I == 0) {
                    aad = false;
                    com.baidu.crabsdk.c.a.ch("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.aah != i);
        if (this.YR != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.cf("onAppNotResponding!");
            if (this.aai != null) {
                this.aai.d("/data/anr/traces.txt");
            }
        }
        aad = false;
        aad = false;
        com.baidu.crabsdk.c.a.ch("anr watch thread is over!");
    }
}
