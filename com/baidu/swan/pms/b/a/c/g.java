package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class g implements Runnable {
    private AtomicBoolean bth;
    private b btw;
    private a btx;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.bth = atomicBoolean;
        this.btw = bVar;
        this.btx = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable dn;
        while (!this.bth.get() && (dn = this.btx.dn(true)) != null && (dn instanceof f)) {
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
        this.btw.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.btw.e(fVar);
        }
    }
}
