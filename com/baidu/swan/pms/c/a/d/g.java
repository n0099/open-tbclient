package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class g implements Runnable {
    private b enH;
    private a enI;
    private AtomicBoolean enr;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.enr = atomicBoolean;
        this.enH = bVar;
        this.enI = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable il;
        while (!this.enr.get() && (il = this.enI.il(true)) != null && (il instanceof f)) {
            try {
                l((f) il);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.enH.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.enH.e(fVar);
        }
    }
}
