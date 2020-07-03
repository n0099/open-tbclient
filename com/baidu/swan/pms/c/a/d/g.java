package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class g implements Runnable {
    private AtomicBoolean dqF;
    private b dqU;
    private a dqV;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.dqF = atomicBoolean;
        this.dqU = bVar;
        this.dqV = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable gn;
        while (!this.dqF.get() && (gn = this.dqV.gn(true)) != null && (gn instanceof f)) {
            try {
                l((f) gn);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.dqU.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.dqU.e(fVar);
        }
    }
}
