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
    private f cBr;
    private AtomicBoolean cBs = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b cBt = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.cBr = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.cBr == fVar) {
                b.this.cBr = null;
            }
        }
    };
    private l cBu = new l(this.cBt);
    private com.baidu.swan.pms.c.a.d.a cBv = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable eZ(boolean z) {
            return b.this.eY(z);
        }
    };
    private c cBo = new c();
    private BlockingQueue<Runnable> cBp = new LinkedBlockingQueue();
    private ThreadPoolExecutor cBq = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.cBp);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.cBu.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.cBu.f(bVar);
    }

    public b() {
        a(this.cBo);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.cBo.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.cBo);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.cBp);
        }
    }

    public synchronized void start() {
        if (this.cBp.size() < 1) {
            this.cBq.execute(new g(this.cBs, this.cBu, this.cBv));
        }
    }

    public synchronized Runnable eY(boolean z) {
        f fVar;
        if (this.cBo != null) {
            if (z) {
                fVar = this.cBo.atR();
            } else {
                fVar = this.cBo.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }
}
