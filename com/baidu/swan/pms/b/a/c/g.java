package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class g implements Runnable {
    private b bmB;
    private a bmC;
    private AtomicBoolean bmk;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.bmk = atomicBoolean;
        this.bmB = bVar;
        this.bmC = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable cR;
        while (!this.bmk.get() && (cR = this.bmC.cR(true)) != null && (cR instanceof f)) {
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
        this.bmB.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.bmB.e(fVar);
        }
    }
}
