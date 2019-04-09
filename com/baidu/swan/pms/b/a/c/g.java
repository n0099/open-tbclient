package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class g implements Runnable {
    private b bmG;
    private a bmH;
    private AtomicBoolean bmq;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.bmq = atomicBoolean;
        this.bmG = bVar;
        this.bmH = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable cR;
        while (!this.bmq.get() && (cR = this.bmH.cR(true)) != null && (cR instanceof f)) {
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
        this.bmG.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.bmG.e(fVar);
        }
    }
}
