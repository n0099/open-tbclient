package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes5.dex */
public final class d extends Thread {
    private static boolean arV = false;
    private final Context apL;
    private final SoftReference<Looper> arW;
    private SoftReference<Handler> arX;
    private final int arY;
    private volatile int arZ;
    private a asa;
    private final Runnable asb;

    private d(Context context, int i) {
        this.arW = new SoftReference<>(Looper.getMainLooper());
        this.arZ = 0;
        this.asb = new e(this);
        this.apL = context;
        this.arY = 3000;
        switch (i) {
            case 1:
                this.asa = new b(context);
                return;
            case 2:
                this.asa = new c(context);
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
        com.baidu.crabsdk.c.a.v("***isRunning = " + arV + "***");
        if (arV) {
            return;
        }
        arV = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.dw("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.arZ;
            if (this.arW.get() == null) {
                arV = false;
                break;
            }
            try {
                if (this.arX == null || this.arX.get() == null) {
                    this.arX = new SoftReference<>(new Handler(this.arW.get()));
                }
                this.arX.get().post(this.asb);
                Thread.sleep(this.arY);
                if (com.baidu.crabsdk.a.I == 0) {
                    arV = false;
                    com.baidu.crabsdk.c.a.dx("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.arZ != i);
        if (this.apL != null && !com.baidu.crabsdk.a.J) {
            com.baidu.crabsdk.c.a.dw("onAppNotResponding!");
            if (this.asa != null) {
                this.asa.e("/data/anr/traces.txt");
            }
        }
        arV = false;
        arV = false;
        com.baidu.crabsdk.c.a.dx("anr watch thread is over!");
    }
}
