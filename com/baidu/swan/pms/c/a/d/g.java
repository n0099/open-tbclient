package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class g implements Runnable {
    private AtomicBoolean cBE;
    private b cBT;
    private a cBU;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.cBE = atomicBoolean;
        this.cBT = bVar;
        this.cBU = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable fa;
        while (!this.cBE.get() && (fa = this.cBU.fa(true)) != null && (fa instanceof f)) {
            try {
                l((f) fa);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.cBT.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.cBT.e(fVar);
        }
    }
}
