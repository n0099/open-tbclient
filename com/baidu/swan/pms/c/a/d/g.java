package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class g implements Runnable {
    private b euI;
    private a euJ;
    private AtomicBoolean eut;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.eut = atomicBoolean;
        this.euI = bVar;
        this.euJ = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable iD;
        while (!this.eut.get() && (iD = this.euJ.iD(true)) != null && (iD instanceof f)) {
            try {
                l((f) iD);
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }

    private <T> void l(f<T> fVar) {
        this.euI.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.euI.e(fVar);
        }
    }
}
