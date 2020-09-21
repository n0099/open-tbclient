package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes24.dex */
public class g implements Runnable {
    private AtomicBoolean dHI;
    private b dHY;
    private a dHZ;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.dHI = atomicBoolean;
        this.dHY = bVar;
        this.dHZ = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable hb;
        while (!this.dHI.get() && (hb = this.dHZ.hb(true)) != null && (hb instanceof f)) {
            try {
                l((f) hb);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.dHY.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.dHY.e(fVar);
        }
    }
}
