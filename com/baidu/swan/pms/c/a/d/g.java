package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class g implements Runnable {
    private AtomicBoolean evU;
    private b ewj;
    private a ewk;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.evU = atomicBoolean;
        this.ewj = bVar;
        this.ewk = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable iD;
        while (!this.evU.get() && (iD = this.ewk.iD(true)) != null && (iD instanceof f)) {
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
        this.ewj.d(fVar);
        try {
            fVar.run();
        } catch (Exception e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.e("PMSTaskExecutor", "run task error:" + e.toString());
            }
        } finally {
            this.ewj.e(fVar);
        }
    }
}
