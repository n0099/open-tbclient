package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes15.dex */
public class g implements Runnable {
    private AtomicBoolean ehX;
    private b ein;
    private a eio;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.ehX = atomicBoolean;
        this.ein = bVar;
        this.eio = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable hT;
        while (!this.ehX.get() && (hT = this.eio.hT(true)) != null && (hT instanceof f)) {
            try {
                l((f) hT);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.ein.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.ein.e(fVar);
        }
    }
}
