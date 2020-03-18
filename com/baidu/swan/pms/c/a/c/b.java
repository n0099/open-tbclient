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
    private f cBD;
    private AtomicBoolean cBE = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b cBF = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.cBD = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.cBD == fVar) {
                b.this.cBD = null;
            }
        }
    };
    private l cBG = new l(this.cBF);
    private com.baidu.swan.pms.c.a.d.a cBH = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable fa(boolean z) {
            return b.this.eZ(z);
        }
    };
    private c cBA = new c();
    private BlockingQueue<Runnable> cBB = new LinkedBlockingQueue();
    private ThreadPoolExecutor cBC = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.cBB);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.cBG.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.cBG.f(bVar);
    }

    public b() {
        a(this.cBA);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.cBA.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.cBA);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.cBB);
        }
    }

    public synchronized void start() {
        if (this.cBB.size() < 1) {
            this.cBC.execute(new g(this.cBE, this.cBG, this.cBH));
        }
    }

    public synchronized Runnable eZ(boolean z) {
        f fVar;
        if (this.cBA != null) {
            if (z) {
                fVar = this.cBA.atU();
            } else {
                fVar = this.cBA.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }
}
