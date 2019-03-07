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
    private f bmj;
    private AtomicBoolean bmk = new AtomicBoolean(false);
    private com.baidu.swan.pms.b.a.c.b bml = new com.baidu.swan.pms.b.a.c.b() { // from class: com.baidu.swan.pms.b.a.b.b.1
        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void d(f<T> fVar) {
            b.this.bmj = fVar;
        }

        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void e(f<T> fVar) {
            if (b.this.bmj == fVar) {
                b.this.bmj = null;
            }
        }
    };
    private l bmm = new l(this.bml);
    private com.baidu.swan.pms.b.a.c.a bmn = new com.baidu.swan.pms.b.a.c.a() { // from class: com.baidu.swan.pms.b.a.b.b.2
        @Override // com.baidu.swan.pms.b.a.c.a
        public Runnable cR(boolean z) {
            return b.this.cQ(z);
        }
    };
    private a<f> bmg = new a<>();
    private BlockingQueue<Runnable> bmh = new LinkedBlockingQueue();
    private ThreadPoolExecutor bmi = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.bmh);

    public void a(com.baidu.swan.pms.b.a.c.b bVar) {
        this.bmm.e(bVar);
    }

    public void b(com.baidu.swan.pms.b.a.c.b bVar) {
        this.bmm.f(bVar);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.bmg.X(fVar);
        if (e.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.bmg);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.bmh);
        }
    }

    public synchronized void start() {
        if (this.bmh.size() < 1) {
            this.bmi.execute(new g(this.bmk, this.bmm, this.bmn));
        }
    }

    public synchronized Runnable cQ(boolean z) {
        f fVar;
        if (this.bmg != null) {
            if (z) {
                fVar = this.bmg.RS();
            } else {
                fVar = this.bmg.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean a(f fVar, c cVar) {
        boolean z;
        if (this.bmj != null && this.bmj.h(fVar)) {
            this.bmj.a(cVar);
            z = true;
        } else {
            f Y = this.bmg.Y(fVar);
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
