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
/* loaded from: classes10.dex */
public class b {
    private f cxs;
    private AtomicBoolean cxt = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b cxu = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.cxs = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.cxs == fVar) {
                b.this.cxs = null;
            }
        }
    };
    private l cxv = new l(this.cxu);
    private com.baidu.swan.pms.c.a.d.a cxw = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable eS(boolean z) {
            return b.this.eR(z);
        }
    };
    private c cxp = new c();
    private BlockingQueue<Runnable> cxq = new LinkedBlockingQueue();
    private ThreadPoolExecutor cxr = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.cxq);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.cxv.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.cxv.f(bVar);
    }

    public b() {
        a(this.cxp);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.cxp.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.cxp);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.cxq);
        }
    }

    public synchronized void start() {
        if (this.cxq.size() < 1) {
            this.cxr.execute(new g(this.cxt, this.cxv, this.cxw));
        }
    }

    public synchronized Runnable eR(boolean z) {
        f fVar;
        if (this.cxp != null) {
            if (z) {
                fVar = this.cxp.arB();
            } else {
                fVar = this.cxp.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }
}
