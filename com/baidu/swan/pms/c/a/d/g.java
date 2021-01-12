package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class g implements Runnable {
    private b esB;
    private a esC;
    private AtomicBoolean esm;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.esm = atomicBoolean;
        this.esB = bVar;
        this.esC = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable iB;
        while (!this.esm.get() && (iB = this.esC.iB(true)) != null && (iB instanceof f)) {
            try {
                l((f) iB);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.esB.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.esB.e(fVar);
        }
    }
}
