package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class g implements Runnable {
    private b bsG;
    private a bsH;
    private AtomicBoolean bsr;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.bsr = atomicBoolean;
        this.bsG = bVar;
        this.bsH = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable di;
        while (!this.bsr.get() && (di = this.bsH.di(true)) != null && (di instanceof f)) {
            try {
                i((f) di);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void i(f<T> fVar) {
        this.bsG.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.bsG.e(fVar);
        }
    }
}
