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
    private f bmo;
    private AtomicBoolean bmq = new AtomicBoolean(false);
    private com.baidu.swan.pms.b.a.c.b bmr = new com.baidu.swan.pms.b.a.c.b() { // from class: com.baidu.swan.pms.b.a.b.b.1
        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void d(f<T> fVar) {
            b.this.bmo = fVar;
        }

        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void e(f<T> fVar) {
            if (b.this.bmo == fVar) {
                b.this.bmo = null;
            }
        }
    };
    private l bms = new l(this.bmr);
    private com.baidu.swan.pms.b.a.c.a bmt = new com.baidu.swan.pms.b.a.c.a() { // from class: com.baidu.swan.pms.b.a.b.b.2
        @Override // com.baidu.swan.pms.b.a.c.a
        public Runnable cR(boolean z) {
            return b.this.cQ(z);
        }
    };
    private a<f> bml = new a<>();
    private BlockingQueue<Runnable> bmm = new LinkedBlockingQueue();
    private ThreadPoolExecutor bmn = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.bmm);

    public void a(com.baidu.swan.pms.b.a.c.b bVar) {
        this.bms.e(bVar);
    }

    public void b(com.baidu.swan.pms.b.a.c.b bVar) {
        this.bms.f(bVar);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.bml.V(fVar);
        if (e.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.bml);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.bmm);
        }
    }

    public synchronized void start() {
        if (this.bmm.size() < 1) {
            this.bmn.execute(new g(this.bmq, this.bms, this.bmt));
        }
    }

    public synchronized Runnable cQ(boolean z) {
        f fVar;
        if (this.bml != null) {
            if (z) {
                fVar = this.bml.RQ();
            } else {
                fVar = this.bml.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean a(f fVar, c cVar) {
        boolean z;
        if (this.bmo != null && this.bmo.h(fVar)) {
            this.bmo.a(cVar);
            z = true;
        } else {
            f W = this.bml.W(fVar);
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
