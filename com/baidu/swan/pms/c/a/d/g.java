package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class g implements Runnable {
    private b cBH;
    private a cBI;
    private AtomicBoolean cBs;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.cBs = atomicBoolean;
        this.cBH = bVar;
        this.cBI = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable eZ;
        while (!this.cBs.get() && (eZ = this.cBI.eZ(true)) != null && (eZ instanceof f)) {
            try {
                l((f) eZ);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.cBH.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.cBH.e(fVar);
        }
    }
}
