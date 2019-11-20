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
    private f bLy;
    private AtomicBoolean bLz = new AtomicBoolean(false);
    private com.baidu.swan.pms.b.a.c.b bLA = new com.baidu.swan.pms.b.a.c.b() { // from class: com.baidu.swan.pms.b.a.b.b.1
        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void d(f<T> fVar) {
            b.this.bLy = fVar;
        }

        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void e(f<T> fVar) {
            if (b.this.bLy == fVar) {
                b.this.bLy = null;
            }
        }
    };
    private l bLB = new l(this.bLA);
    private com.baidu.swan.pms.b.a.c.a bLC = new com.baidu.swan.pms.b.a.c.a() { // from class: com.baidu.swan.pms.b.a.b.b.2
        @Override // com.baidu.swan.pms.b.a.c.a
        public Runnable dE(boolean z) {
            return b.this.dD(z);
        }
    };
    private a<f> bLv = new a<>();
    private BlockingQueue<Runnable> bLw = new LinkedBlockingQueue();
    private ThreadPoolExecutor bLx = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.bLw);

    public void a(com.baidu.swan.pms.b.a.c.b bVar) {
        this.bLB.e(bVar);
    }

    public void b(com.baidu.swan.pms.b.a.c.b bVar) {
        this.bLB.f(bVar);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.bLv.V(fVar);
        if (e.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.bLv);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.bLw);
        }
    }

    public synchronized void start() {
        if (this.bLw.size() < 1) {
            this.bLx.execute(new g(this.bLz, this.bLB, this.bLC));
        }
    }

    public synchronized Runnable dD(boolean z) {
        f fVar;
        if (this.bLv != null) {
            if (z) {
                fVar = this.bLv.abo();
            } else {
                fVar = this.bLv.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean a(f fVar, c cVar) {
        boolean z;
        if (this.bLy != null && this.bLy.h(fVar)) {
            this.bLy.a(cVar);
            z = true;
        } else {
            f W = this.bLv.W(fVar);
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
