package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class g implements Runnable {
    private b bMF;
    private a bMG;
    private AtomicBoolean bMq;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.bMq = atomicBoolean;
        this.bMF = bVar;
        this.bMG = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable dE;
        while (!this.bMq.get() && (dE = this.bMG.dE(true)) != null && (dE instanceof f)) {
            try {
                i((f) dE);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void i(f<T> fVar) {
        this.bMF.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.bMF.e(fVar);
        }
    }
}
