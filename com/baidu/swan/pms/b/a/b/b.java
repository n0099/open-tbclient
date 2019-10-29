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
    private f bMp;
    private AtomicBoolean bMq = new AtomicBoolean(false);
    private com.baidu.swan.pms.b.a.c.b bMr = new com.baidu.swan.pms.b.a.c.b() { // from class: com.baidu.swan.pms.b.a.b.b.1
        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void d(f<T> fVar) {
            b.this.bMp = fVar;
        }

        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void e(f<T> fVar) {
            if (b.this.bMp == fVar) {
                b.this.bMp = null;
            }
        }
    };
    private l bMs = new l(this.bMr);
    private com.baidu.swan.pms.b.a.c.a bMt = new com.baidu.swan.pms.b.a.c.a() { // from class: com.baidu.swan.pms.b.a.b.b.2
        @Override // com.baidu.swan.pms.b.a.c.a
        public Runnable dE(boolean z) {
            return b.this.dD(z);
        }
    };
    private a<f> bMm = new a<>();
    private BlockingQueue<Runnable> bMn = new LinkedBlockingQueue();
    private ThreadPoolExecutor bMo = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.bMn);

    public void a(com.baidu.swan.pms.b.a.c.b bVar) {
        this.bMs.e(bVar);
    }

    public void b(com.baidu.swan.pms.b.a.c.b bVar) {
        this.bMs.f(bVar);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.bMm.V(fVar);
        if (e.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.bMm);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.bMn);
        }
    }

    public synchronized void start() {
        if (this.bMn.size() < 1) {
            this.bMo.execute(new g(this.bMq, this.bMs, this.bMt));
        }
    }

    public synchronized Runnable dD(boolean z) {
        f fVar;
        if (this.bMm != null) {
            if (z) {
                fVar = this.bMm.abq();
            } else {
                fVar = this.bMm.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean a(f fVar, c cVar) {
        boolean z;
        if (this.bMp != null && this.bMp.h(fVar)) {
            this.bMp.a(cVar);
            z = true;
        } else {
            f W = this.bMm.W(fVar);
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
