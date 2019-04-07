package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class g implements Runnable {
    private b bmF;
    private a bmG;
    private AtomicBoolean bmo;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.bmo = atomicBoolean;
        this.bmF = bVar;
        this.bmG = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable cR;
        while (!this.bmo.get() && (cR = this.bmG.cR(true)) != null && (cR instanceof f)) {
            try {
                i((f) cR);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void i(f<T> fVar) {
        this.bmF.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.bmF.e(fVar);
        }
    }
}
