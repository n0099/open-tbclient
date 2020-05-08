package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class g implements Runnable {
    private AtomicBoolean daJ;
    private b daY;
    private a daZ;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.daJ = atomicBoolean;
        this.daY = bVar;
        this.daZ = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable fX;
        while (!this.daJ.get() && (fX = this.daZ.fX(true)) != null && (fX instanceof f)) {
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
        this.daY.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.daY.e(fVar);
        }
    }
}
