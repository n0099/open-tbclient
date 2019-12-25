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
/* loaded from: classes9.dex */
public class b {
    private f cxh;
    private AtomicBoolean cxi = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b cxj = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.cxh = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.cxh == fVar) {
                b.this.cxh = null;
            }
        }
    };
    private l cxk = new l(this.cxj);
    private com.baidu.swan.pms.c.a.d.a cxl = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable eN(boolean z) {
            return b.this.eM(z);
        }
    };
    private c cxe = new c();
    private BlockingQueue<Runnable> cxf = new LinkedBlockingQueue();
    private ThreadPoolExecutor cxg = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.cxf);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.cxk.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.cxk.f(bVar);
    }

    public b() {
        a(this.cxe);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.cxe.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.cxe);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.cxf);
        }
    }

    public synchronized void start() {
        if (this.cxf.size() < 1) {
            this.cxg.execute(new g(this.cxi, this.cxk, this.cxl));
        }
    }

    public synchronized Runnable eM(boolean z) {
        f fVar;
        if (this.cxe != null) {
            if (z) {
                fVar = this.cxe.ari();
            } else {
                fVar = this.cxe.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }
}
