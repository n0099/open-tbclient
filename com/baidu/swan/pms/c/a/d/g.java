package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes15.dex */
public class g implements Runnable {
    private AtomicBoolean dTJ;
    private b dTZ;
    private a dUa;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.dTJ = atomicBoolean;
        this.dTZ = bVar;
        this.dUa = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable hx;
        while (!this.dTJ.get() && (hx = this.dUa.hx(true)) != null && (hx instanceof f)) {
            try {
                l((f) hx);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.dTZ.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.dTZ.e(fVar);
        }
    }
}
