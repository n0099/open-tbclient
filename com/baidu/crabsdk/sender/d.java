package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes11.dex */
public final class d extends Thread {
    private static boolean bC = false;
    private final Context anO;
    private final SoftReference<Looper> apW;
    private SoftReference<Handler> apX;
    private final int apY;
    private volatile int apZ;
    private a aqa;
    private final Runnable aqb;

    private d(Context context, int i) {
        this.apW = new SoftReference<>(Looper.getMainLooper());
        this.apZ = 0;
        this.aqb = new e(this);
        this.anO = context;
        this.apY = 3000;
        switch (i) {
            case 1:
                this.aqa = new b(context);
                return;
            case 2:
                this.aqa = new c(context);
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
        com.baidu.crabsdk.c.a.dA("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.apZ;
            if (this.apW.get() == null) {
                bC = false;
                break;
            }
            try {
                if (this.apX == null || this.apX.get() == null) {
                    this.apX = new SoftReference<>(new Handler(this.apW.get()));
                }
                this.apX.get().post(this.aqb);
                Thread.sleep(this.apY);
                if (com.baidu.crabsdk.a.I == 0) {
                    bC = false;
                    com.baidu.crabsdk.c.a.dB("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.apZ != i);
        if (this.anO != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.dA("onAppNotResponding!");
            if (this.aqa != null) {
                this.aqa.e("/data/anr/traces.txt");
            }
        }
        bC = false;
        bC = false;
        com.baidu.crabsdk.c.a.dB("anr watch thread is over!");
    }
}
