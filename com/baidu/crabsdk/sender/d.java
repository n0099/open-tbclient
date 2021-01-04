package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes3.dex */
public final class d extends Thread {
    private static boolean art = false;
    private final Context api;
    private final SoftReference<Looper> aru;
    private SoftReference<Handler> arv;
    private final int arw;
    private volatile int arx;
    private a ary;
    private final Runnable arz;

    private d(Context context, int i) {
        this.aru = new SoftReference<>(Looper.getMainLooper());
        this.arx = 0;
        this.arz = new e(this);
        this.api = context;
        this.arw = 3000;
        switch (i) {
            case 1:
                this.ary = new b(context);
                return;
            case 2:
                this.ary = new c(context);
                return;
            default:
                return;
        }
    }

    public d(Context context, int i, byte b2) {
        this(context, i);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int i;
        com.baidu.crabsdk.c.a.v("***isRunning = " + art + "***");
        if (art) {
            return;
        }
        art = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.dx("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.arx;
            if (this.aru.get() == null) {
                art = false;
                break;
            }
            try {
                if (this.arv == null || this.arv.get() == null) {
                    this.arv = new SoftReference<>(new Handler(this.aru.get()));
                }
                this.arv.get().post(this.arz);
                Thread.sleep(this.arw);
                if (com.baidu.crabsdk.a.I == 0) {
                    art = false;
                    com.baidu.crabsdk.c.a.dy("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.arx != i);
        if (this.api != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.dx("onAppNotResponding!");
            if (this.ary != null) {
                this.ary.e("/data/anr/traces.txt");
            }
        }
        art = false;
        art = false;
        com.baidu.crabsdk.c.a.dy("anr watch thread is over!");
    }
}
