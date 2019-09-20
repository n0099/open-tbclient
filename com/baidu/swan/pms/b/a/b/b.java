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
    private f btE;
    private AtomicBoolean btF = new AtomicBoolean(false);
    private com.baidu.swan.pms.b.a.c.b btG = new com.baidu.swan.pms.b.a.c.b() { // from class: com.baidu.swan.pms.b.a.b.b.1
        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void d(f<T> fVar) {
            b.this.btE = fVar;
        }

        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void e(f<T> fVar) {
            if (b.this.btE == fVar) {
                b.this.btE = null;
            }
        }
    };
    private l btH = new l(this.btG);
    private com.baidu.swan.pms.b.a.c.a btI = new com.baidu.swan.pms.b.a.c.a() { // from class: com.baidu.swan.pms.b.a.b.b.2
        @Override // com.baidu.swan.pms.b.a.c.a
        public Runnable dn(boolean z) {
            return b.this.dm(z);
        }
    };
    private a<f> btB = new a<>();
    private BlockingQueue<Runnable> btC = new LinkedBlockingQueue();
    private ThreadPoolExecutor btD = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.btC);

    public void a(com.baidu.swan.pms.b.a.c.b bVar) {
        this.btH.e(bVar);
    }

    public void b(com.baidu.swan.pms.b.a.c.b bVar) {
        this.btH.f(bVar);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.btB.X(fVar);
        if (e.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.btB);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.btC);
        }
    }

    public synchronized void start() {
        if (this.btC.size() < 1) {
            this.btD.execute(new g(this.btF, this.btH, this.btI));
        }
    }

    public synchronized Runnable dm(boolean z) {
        f fVar;
        if (this.btB != null) {
            if (z) {
                fVar = this.btB.WB();
            } else {
                fVar = this.btB.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean a(f fVar, c cVar) {
        boolean z;
        if (this.btE != null && this.btE.h(fVar)) {
            this.btE.a(cVar);
            z = true;
        } else {
            f Y = this.btB.Y(fVar);
            if (Y != null) {
                if (e.DEBUG) {
                    Log.w("PMSThreadQueue", "found duplicated task in mWaitingQueue:" + fVar.toString());
                }
                Y.a(cVar);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
