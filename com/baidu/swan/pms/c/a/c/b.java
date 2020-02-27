package com.baidu.swan.pms.c.a.c;

import android.util.Log;
import com.baidu.swan.pms.c.a.d.f;
import com.baidu.swan.pms.c.a.d.g;
import com.baidu.swan.pms.c.a.d.l;
import com.baidu.swan.pms.d;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class b {
    private f cBq;
    private AtomicBoolean cBr = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b cBs = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.cBq = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.cBq == fVar) {
                b.this.cBq = null;
            }
        }
    };
    private l cBt = new l(this.cBs);
    private com.baidu.swan.pms.c.a.d.a cBu = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable eZ(boolean z) {
            return b.this.eY(z);
        }
    };
    private c cBn = new c();
    private BlockingQueue<Runnable> cBo = new LinkedBlockingQueue();
    private ThreadPoolExecutor cBp = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.cBo);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.cBt.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.cBt.f(bVar);
    }

    public b() {
        a(this.cBn);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.cBn.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.cBn);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.cBo);
        }
    }

    public synchronized void start() {
        if (this.cBo.size() < 1) {
            this.cBp.execute(new g(this.cBr, this.cBt, this.cBu));
        }
    }

    public synchronized Runnable eY(boolean z) {
        f fVar;
        if (this.cBn != null) {
            if (z) {
                fVar = this.cBn.atP();
            } else {
                fVar = this.cBn.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }
}
