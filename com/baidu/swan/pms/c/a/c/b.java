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
    private f daD;
    private AtomicBoolean daE = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b daF = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.daD = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.daD == fVar) {
                b.this.daD = null;
            }
        }
    };
    private l daG = new l(this.daF);
    private com.baidu.swan.pms.c.a.d.a daH = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable fX(boolean z) {
            return b.this.fW(z);
        }
    };
    private c daA = new c();
    private BlockingQueue<Runnable> daB = new LinkedBlockingQueue();
    private ThreadPoolExecutor daC = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.daB);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.daG.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.daG.f(bVar);
    }

    public b() {
        a(this.daA);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.daA.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.daA);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.daB);
        }
    }

    public synchronized void start() {
        if (this.daB.size() < 1) {
            this.daC.execute(new g(this.daE, this.daG, this.daH));
        }
    }

    public synchronized Runnable fW(boolean z) {
        f fVar;
        if (this.daA != null) {
            if (z) {
                fVar = this.daA.aCe();
            } else {
                fVar = this.daA.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }
}
