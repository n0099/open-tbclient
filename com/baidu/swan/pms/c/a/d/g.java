package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class g implements Runnable {
    private AtomicBoolean cxi;
    private b cxx;
    private a cxy;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.cxi = atomicBoolean;
        this.cxx = bVar;
        this.cxy = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable eN;
        while (!this.cxi.get() && (eN = this.cxy.eN(true)) != null && (eN instanceof f)) {
            try {
                l((f) eN);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.cxx.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.cxx.e(fVar);
        }
    }
}
