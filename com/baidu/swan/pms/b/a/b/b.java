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
    private f btg;
    private AtomicBoolean bth = new AtomicBoolean(false);
    private com.baidu.swan.pms.b.a.c.b bti = new com.baidu.swan.pms.b.a.c.b() { // from class: com.baidu.swan.pms.b.a.b.b.1
        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void d(f<T> fVar) {
            b.this.btg = fVar;
        }

        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void e(f<T> fVar) {
            if (b.this.btg == fVar) {
                b.this.btg = null;
            }
        }
    };
    private l btj = new l(this.bti);
    private com.baidu.swan.pms.b.a.c.a btk = new com.baidu.swan.pms.b.a.c.a() { // from class: com.baidu.swan.pms.b.a.b.b.2
        @Override // com.baidu.swan.pms.b.a.c.a
        public Runnable dn(boolean z) {
            return b.this.dm(z);
        }
    };
    private a<f> btd = new a<>();
    private BlockingQueue<Runnable> bte = new LinkedBlockingQueue();
    private ThreadPoolExecutor btf = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.bte);

    public void a(com.baidu.swan.pms.b.a.c.b bVar) {
        this.btj.e(bVar);
    }

    public void b(com.baidu.swan.pms.b.a.c.b bVar) {
        this.btj.f(bVar);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.btd.X(fVar);
        if (e.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.btd);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.bte);
        }
    }

    public synchronized void start() {
        if (this.bte.size() < 1) {
            this.btf.execute(new g(this.bth, this.btj, this.btk));
        }
    }

    public synchronized Runnable dm(boolean z) {
        f fVar;
        if (this.btd != null) {
            if (z) {
                fVar = this.btd.Wx();
            } else {
                fVar = this.btd.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean a(f fVar, c cVar) {
        boolean z;
        if (this.btg != null && this.btg.h(fVar)) {
            this.btg.a(cVar);
            z = true;
        } else {
            f Y = this.btd.Y(fVar);
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
