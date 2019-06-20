package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes3.dex */
public final class d extends Thread {
    private static boolean aac = false;
    private final Context YQ;
    private final SoftReference<Looper> aad;
    private SoftReference<Handler> aae;
    private final int aaf;
    private volatile int aag;
    private a aah;
    private final Runnable aai;

    private d(Context context, int i) {
        this.aad = new SoftReference<>(Looper.getMainLooper());
        this.aag = 0;
        this.aai = new e(this);
        this.YQ = context;
        this.aaf = 3000;
        switch (i) {
            case 1:
                this.aah = new b(context);
                return;
            case 2:
                this.aah = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + aac + "***");
        if (aac) {
            return;
        }
        aac = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.cf("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.aag;
            if (this.aad.get() == null) {
                aac = false;
                break;
            }
            try {
                if (this.aae == null || this.aae.get() == null) {
                    this.aae = new SoftReference<>(new Handler(this.aad.get()));
                }
                this.aae.get().post(this.aai);
                Thread.sleep(this.aaf);
                if (com.baidu.crabsdk.a.I == 0) {
                    aac = false;
                    com.baidu.crabsdk.c.a.ch("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.aag != i);
        if (this.YQ != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.cf("onAppNotResponding!");
            if (this.aah != null) {
                this.aah.d("/data/anr/traces.txt");
            }
        }
        aac = false;
        aac = false;
        com.baidu.crabsdk.c.a.ch("anr watch thread is over!");
    }
}
