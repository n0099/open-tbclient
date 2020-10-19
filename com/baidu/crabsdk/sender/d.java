package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes11.dex */
public final class d extends Thread {
    private static boolean bC = false;
    private final Context anN;
    private final SoftReference<Looper> apV;
    private SoftReference<Handler> apW;
    private final int apX;
    private volatile int apY;
    private a apZ;
    private final Runnable aqa;

    private d(Context context, int i) {
        this.apV = new SoftReference<>(Looper.getMainLooper());
        this.apY = 0;
        this.aqa = new e(this);
        this.anN = context;
        this.apX = 3000;
        switch (i) {
            case 1:
                this.apZ = new b(context);
                return;
            case 2:
                this.apZ = new c(context);
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
            i = this.apY;
            if (this.apV.get() == null) {
                bC = false;
                break;
            }
            try {
                if (this.apW == null || this.apW.get() == null) {
                    this.apW = new SoftReference<>(new Handler(this.apV.get()));
                }
                this.apW.get().post(this.aqa);
                Thread.sleep(this.apX);
                if (com.baidu.crabsdk.a.I == 0) {
                    bC = false;
                    com.baidu.crabsdk.c.a.dB("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.apY != i);
        if (this.anN != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.dA("onAppNotResponding!");
            if (this.apZ != null) {
                this.apZ.e("/data/anr/traces.txt");
            }
        }
        bC = false;
        bC = false;
        com.baidu.crabsdk.c.a.dB("anr watch thread is over!");
    }
}
