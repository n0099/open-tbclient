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
    private f bmk;
    private AtomicBoolean bml = new AtomicBoolean(false);
    private com.baidu.swan.pms.b.a.c.b bmm = new com.baidu.swan.pms.b.a.c.b() { // from class: com.baidu.swan.pms.b.a.b.b.1
        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void d(f<T> fVar) {
            b.this.bmk = fVar;
        }

        @Override // com.baidu.swan.pms.b.a.c.b
        public <T> void e(f<T> fVar) {
            if (b.this.bmk == fVar) {
                b.this.bmk = null;
            }
        }
    };
    private l bmn = new l(this.bmm);
    private com.baidu.swan.pms.b.a.c.a bmo = new com.baidu.swan.pms.b.a.c.a() { // from class: com.baidu.swan.pms.b.a.b.b.2
        @Override // com.baidu.swan.pms.b.a.c.a
        public Runnable cR(boolean z) {
            return b.this.cQ(z);
        }
    };
    private a<f> bmh = new a<>();
    private BlockingQueue<Runnable> bmi = new LinkedBlockingQueue();
    private ThreadPoolExecutor bmj = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.bmi);

    public void a(com.baidu.swan.pms.b.a.c.b bVar) {
        this.bmn.e(bVar);
    }

    public void b(com.baidu.swan.pms.b.a.c.b bVar) {
        this.bmn.f(bVar);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.bmh.X(fVar);
        if (e.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.bmh);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.bmi);
        }
    }

    public synchronized void start() {
        if (this.bmi.size() < 1) {
            this.bmj.execute(new g(this.bml, this.bmn, this.bmo));
        }
    }

    public synchronized Runnable cQ(boolean z) {
        f fVar;
        if (this.bmh != null) {
            if (z) {
                fVar = this.bmh.RS();
            } else {
                fVar = this.bmh.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean a(f fVar, c cVar) {
        boolean z;
        if (this.bmk != null && this.bmk.h(fVar)) {
            this.bmk.a(cVar);
            z = true;
        } else {
            f Y = this.bmh.Y(fVar);
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
