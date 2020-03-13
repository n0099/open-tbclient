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
    private f cBs;
    private AtomicBoolean cBt = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b cBu = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.cBs = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.cBs == fVar) {
                b.this.cBs = null;
            }
        }
    };
    private l cBv = new l(this.cBu);
    private com.baidu.swan.pms.c.a.d.a cBw = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable eZ(boolean z) {
            return b.this.eY(z);
        }
    };
    private c cBp = new c();
    private BlockingQueue<Runnable> cBq = new LinkedBlockingQueue();
    private ThreadPoolExecutor cBr = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.cBq);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.cBv.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.cBv.f(bVar);
    }

    public b() {
        a(this.cBp);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.cBp.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.cBp);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.cBq);
        }
    }

    public synchronized void start() {
        if (this.cBq.size() < 1) {
            this.cBr.execute(new g(this.cBt, this.cBv, this.cBw));
        }
    }

    public synchronized Runnable eY(boolean z) {
        f fVar;
        if (this.cBp != null) {
            if (z) {
                fVar = this.cBp.atR();
            } else {
                fVar = this.cBp.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }
}
