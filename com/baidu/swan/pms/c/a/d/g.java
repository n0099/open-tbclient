package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class g implements Runnable {
    private b egG;
    private a egH;
    private AtomicBoolean egq;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.egq = atomicBoolean;
        this.egG = bVar;
        this.egH = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable hW;
        while (!this.egq.get() && (hW = this.egH.hW(true)) != null && (hW instanceof f)) {
            try {
                l((f) hW);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.egG.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.egG.e(fVar);
        }
    }
}
