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
    private f bsq;
    private AtomicBoolean bsr = new AtomicBoolean(false);
    private com.baidu.swan.pms.b.a.c.b bss = new com.baidu.swan.pms.b.a.c.b() { // from class: com.baidu.swan.pms.b.a.b.b.1
        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void d(f<T> fVar) {
            b.this.bsq = fVar;
        }

        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void e(f<T> fVar) {
            if (b.this.bsq == fVar) {
                b.this.bsq = null;
            }
        }
    };
    private l bst = new l(this.bss);
    private com.baidu.swan.pms.b.a.c.a bsu = new com.baidu.swan.pms.b.a.c.a() { // from class: com.baidu.swan.pms.b.a.b.b.2
        @Override // com.baidu.swan.pms.b.a.c.a
        public Runnable di(boolean z) {
            return b.this.dh(z);
        }
    };
    private a<f> bsn = new a<>();
    private BlockingQueue<Runnable> bso = new LinkedBlockingQueue();
    private ThreadPoolExecutor bsp = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.bso);

    public void a(com.baidu.swan.pms.b.a.c.b bVar) {
        this.bst.e(bVar);
    }

    public void b(com.baidu.swan.pms.b.a.c.b bVar) {
        this.bst.f(bVar);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.bsn.X(fVar);
        if (e.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.bsn);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.bso);
        }
    }

    public synchronized void start() {
        if (this.bso.size() < 1) {
            this.bsp.execute(new g(this.bsr, this.bst, this.bsu));
        }
    }

    public synchronized Runnable dh(boolean z) {
        f fVar;
        if (this.bsn != null) {
            if (z) {
                fVar = this.bsn.VE();
            } else {
                fVar = this.bsn.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean a(f fVar, c cVar) {
        boolean z;
        if (this.bsq != null && this.bsq.h(fVar)) {
            this.bsq.a(cVar);
            z = true;
        } else {
            f Y = this.bsn.Y(fVar);
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
