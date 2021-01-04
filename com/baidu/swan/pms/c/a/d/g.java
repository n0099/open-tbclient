package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class g implements Runnable {
    private AtomicBoolean ewZ;
    private b exo;
    private a exp;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.ewZ = atomicBoolean;
        this.exo = bVar;
        this.exp = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable iF;
        while (!this.ewZ.get() && (iF = this.exp.iF(true)) != null && (iF instanceof f)) {
            try {
                l((f) iF);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.exo.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.exo.e(fVar);
        }
    }
}
