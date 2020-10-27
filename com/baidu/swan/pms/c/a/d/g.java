package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes15.dex */
public class g implements Runnable {
    private AtomicBoolean ecf;
    private b ecv;
    private a ecw;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.ecf = atomicBoolean;
        this.ecv = bVar;
        this.ecw = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable hK;
        while (!this.ecf.get() && (hK = this.ecw.hK(true)) != null && (hK instanceof f)) {
            try {
                l((f) hK);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.ecv.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.ecv.e(fVar);
        }
    }
}
