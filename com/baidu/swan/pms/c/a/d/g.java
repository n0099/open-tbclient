package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes14.dex */
public class g implements Runnable {
    private AtomicBoolean dFE;
    private b dFU;
    private a dFV;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.dFE = atomicBoolean;
        this.dFU = bVar;
        this.dFV = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable hd;
        while (!this.dFE.get() && (hd = this.dFV.hd(true)) != null && (hd instanceof f)) {
            try {
                l((f) hd);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.dFU.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.dFU.e(fVar);
        }
    }
}
