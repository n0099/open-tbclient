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
/* loaded from: classes15.dex */
public class b {
    private f ece;
    private AtomicBoolean ecf = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b ecg = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.ece = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.ece == fVar) {
                b.this.ece = null;
            }
        }
    };
    private l ech = new l(this.ecg);
    private com.baidu.swan.pms.c.a.d.a eci = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable hK(boolean z) {
            return b.this.hJ(z);
        }
    };
    private c ecb = new c();
    private BlockingQueue<Runnable> ecc = new LinkedBlockingQueue();
    private ThreadPoolExecutor ecd = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.ecc);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.ech.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.ech.f(bVar);
    }

    public b() {
        a(this.ecb);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.ecb.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.ecb);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.ecc);
        }
    }

    public synchronized void start() {
        if (this.ecc.size() < 1) {
            this.ecd.execute(new g(this.ecf, this.ech, this.eci));
        }
    }

    public synchronized Runnable hJ(boolean z) {
        f fVar;
        if (this.ecb != null) {
            if (z) {
                fVar = this.ecb.aZd();
            } else {
                fVar = this.ecb.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean xV(String str) {
        boolean z;
        if (this.ece == null) {
            z = false;
        } else {
            Object aZk = this.ece.aZk();
            if (aZk instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aZk;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.ebO + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.ebO, str);
            } else if (aZk instanceof a.C0546a) {
                a.C0546a c0546a = (a.C0546a) aZk;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0546a.ebO + ", checking id: " + str);
                }
                z = TextUtils.equals(c0546a.ebO, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + aZk.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean xW(String str) {
        boolean z;
        Iterator<f> aZe = this.ecb.aZe();
        while (true) {
            if (aZe.hasNext()) {
                f next = aZe.next();
                if (next != null) {
                    Object aZk = next.aZk();
                    if (aZk instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aZk;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.ebO + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.ebO, str)) {
                            z = true;
                            break;
                        }
                    } else if (aZk instanceof a.C0546a) {
                        a.C0546a c0546a = (a.C0546a) aZk;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0546a.ebO + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0546a.ebO, str)) {
                            z = true;
                            break;
                        }
                    } else if (d.DEBUG) {
                        Log.v("PMSThreadQueue", "Queue model type not match: " + aZk.getClass().getSimpleName());
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
