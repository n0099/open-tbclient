package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class g implements Runnable {
    private b cxI;
    private a cxJ;
    private AtomicBoolean cxt;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.cxt = atomicBoolean;
        this.cxI = bVar;
        this.cxJ = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable eS;
        while (!this.cxt.get() && (eS = this.cxJ.eS(true)) != null && (eS instanceof f)) {
            try {
                l((f) eS);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.cxI.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.cxI.e(fVar);
        }
    }
}
