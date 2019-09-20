package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class g implements Runnable {
    private AtomicBoolean btF;
    private b btU;
    private a btV;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.btF = atomicBoolean;
        this.btU = bVar;
        this.btV = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable dn;
        while (!this.btF.get() && (dn = this.btV.dn(true)) != null && (dn instanceof f)) {
            try {
                i((f) dn);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void i(f<T> fVar) {
        this.btU.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.btU.e(fVar);
        }
    }
}
