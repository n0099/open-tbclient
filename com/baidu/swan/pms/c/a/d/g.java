package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes19.dex */
public class g implements Runnable {
    private b dwM;
    private a dwN;
    private AtomicBoolean dwx;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.dwx = atomicBoolean;
        this.dwM = bVar;
        this.dwN = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable gI;
        while (!this.dwx.get() && (gI = this.dwN.gI(true)) != null && (gI instanceof f)) {
            try {
                l((f) gI);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.dwM.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.dwM.e(fVar);
        }
    }
}
