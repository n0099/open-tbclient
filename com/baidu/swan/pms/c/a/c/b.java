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
    private f daI;
    private AtomicBoolean daJ = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b daK = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.daI = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.daI == fVar) {
                b.this.daI = null;
            }
        }
    };
    private l daL = new l(this.daK);
    private com.baidu.swan.pms.c.a.d.a daM = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable fX(boolean z) {
            return b.this.fW(z);
        }
    };
    private c daF = new c();
    private BlockingQueue<Runnable> daG = new LinkedBlockingQueue();
    private ThreadPoolExecutor daH = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.daG);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.daL.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.daL.f(bVar);
    }

    public b() {
        a(this.daF);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.daF.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.daF);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.daG);
        }
    }

    public synchronized void start() {
        if (this.daG.size() < 1) {
            this.daH.execute(new g(this.daJ, this.daL, this.daM));
        }
    }

    public synchronized Runnable fW(boolean z) {
        f fVar;
        if (this.daF != null) {
            if (z) {
                fVar = this.daF.aCe();
            } else {
                fVar = this.daF.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }
}
