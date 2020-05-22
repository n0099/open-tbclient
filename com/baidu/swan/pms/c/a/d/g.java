package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class g implements Runnable {
    private AtomicBoolean dlU;
    private b dmj;
    private a dmk;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.dlU = atomicBoolean;
        this.dmj = bVar;
        this.dmk = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable gi;
        while (!this.dlU.get() && (gi = this.dmk.gi(true)) != null && (gi instanceof f)) {
            try {
                l((f) gi);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.dmj.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.dmj.e(fVar);
        }
    }
}
