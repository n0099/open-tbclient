package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes14.dex */
public class g implements Runnable {
    private AtomicBoolean dFA;
    private b dFQ;
    private a dFR;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.dFA = atomicBoolean;
        this.dFQ = bVar;
        this.dFR = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable hc;
        while (!this.dFA.get() && (hc = this.dFR.hc(true)) != null && (hc instanceof f)) {
            try {
                l((f) hc);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.dFQ.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.dFQ.e(fVar);
        }
    }
}
