package com.baidu.swan.pms.c.a.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.c.a.d.f;
import com.baidu.swan.pms.c.a.d.g;
import com.baidu.swan.pms.c.a.d.l;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.d;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b {
    private f eus;
    private AtomicBoolean eut = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b euu = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.eus = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.eus == fVar) {
                b.this.eus = null;
            }
        }
    };
    private l euv = new l(this.euu);
    private com.baidu.swan.pms.c.a.d.a euw = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable iD(boolean z) {
            return b.this.iC(z);
        }
    };
    private c eup = new c();
    private BlockingQueue<Runnable> euq = new LinkedBlockingQueue();
    private ThreadPoolExecutor eur = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.euq);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.euv.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.euv.f(bVar);
    }

    public b() {
        a(this.eup);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.eup.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.eup);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.euq);
        }
    }

    public synchronized void start() {
        if (this.euq.size() < 1) {
            this.eur.execute(new g(this.eut, this.euv, this.euw));
        }
    }

    public synchronized Runnable iC(boolean z) {
        f fVar;
        if (this.eup != null) {
            if (z) {
                fVar = this.eup.bcR();
            } else {
                fVar = this.eup.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean xS(String str) {
        boolean z;
        if (this.eus == null) {
            z = false;
        } else {
            Object bcY = this.eus.bcY();
            if (bcY instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) bcY;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.euc + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.euc, str);
            } else if (bcY instanceof a.C0539a) {
                a.C0539a c0539a = (a.C0539a) bcY;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0539a.euc + ", checking id: " + str);
                }
                z = TextUtils.equals(c0539a.euc, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + bcY.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean xT(String str) {
        boolean z;
        Iterator<f> bcS = this.eup.bcS();
        while (true) {
            if (bcS.hasNext()) {
                f next = bcS.next();
                if (next != null) {
                    Object bcY = next.bcY();
                    if (bcY instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) bcY;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.euc + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.euc, str)) {
                            z = true;
                            break;
                        }
                    } else if (bcY instanceof a.C0539a) {
                        a.C0539a c0539a = (a.C0539a) bcY;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0539a.euc + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0539a.euc, str)) {
                            z = true;
                            break;
                        }
                    } else if (d.DEBUG) {
                        Log.v("PMSThreadQueue", "Queue model type not match: " + bcY.getClass().getSimpleName());
                    }
                }
            } else {
                z = false;
                break;
            }
        }
        return z;
    }
}
