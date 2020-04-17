package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class g implements Runnable {
    private AtomicBoolean daE;
    private b daT;
    private a daU;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.daE = atomicBoolean;
        this.daT = bVar;
        this.daU = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable fX;
        while (!this.daE.get() && (fX = this.daU.fX(true)) != null && (fX instanceof f)) {
            try {
                l((f) fX);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.daT.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.daT.e(fVar);
        }
    }
}
