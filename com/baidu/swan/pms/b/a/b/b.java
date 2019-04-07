package com.baidu.swan.pms.b.a.b;

import android.util.Log;
import com.baidu.swan.pms.b.a.c.c;
import com.baidu.swan.pms.b.a.c.f;
import com.baidu.swan.pms.b.a.c.g;
import com.baidu.swan.pms.b.a.c.l;
import com.baidu.swan.pms.e;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class b {
    private f bmn;
    private AtomicBoolean bmo = new AtomicBoolean(false);
    private com.baidu.swan.pms.b.a.c.b bmq = new com.baidu.swan.pms.b.a.c.b() { // from class: com.baidu.swan.pms.b.a.b.b.1
        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void d(f<T> fVar) {
            b.this.bmn = fVar;
        }

        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void e(f<T> fVar) {
            if (b.this.bmn == fVar) {
                b.this.bmn = null;
            }
        }
    };
    private l bmr = new l(this.bmq);
    private com.baidu.swan.pms.b.a.c.a bms = new com.baidu.swan.pms.b.a.c.a() { // from class: com.baidu.swan.pms.b.a.b.b.2
        @Override // com.baidu.swan.pms.b.a.c.a
        public Runnable cR(boolean z) {
            return b.this.cQ(z);
        }
    };
    private a<f> bmk = new a<>();
    private BlockingQueue<Runnable> bml = new LinkedBlockingQueue();
    private ThreadPoolExecutor bmm = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.bml);

    public void a(com.baidu.swan.pms.b.a.c.b bVar) {
        this.bmr.e(bVar);
    }

    public void b(com.baidu.swan.pms.b.a.c.b bVar) {
        this.bmr.f(bVar);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.bmk.V(fVar);
        if (e.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.bmk);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.bml);
        }
    }

    public synchronized void start() {
        if (this.bml.size() < 1) {
            this.bmm.execute(new g(this.bmo, this.bmr, this.bms));
        }
    }

    public synchronized Runnable cQ(boolean z) {
        f fVar;
        if (this.bmk != null) {
            if (z) {
                fVar = this.bmk.RQ();
            } else {
                fVar = this.bmk.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean a(f fVar, c cVar) {
        boolean z;
        if (this.bmn != null && this.bmn.h(fVar)) {
            this.bmn.a(cVar);
            z = true;
        } else {
            f W = this.bmk.W(fVar);
            if (W != null) {
                if (e.DEBUG) {
                    Log.w("PMSThreadQueue", "found duplicated task in mWaitingQueue:" + fVar.toString());
                }
                W.a(cVar);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
