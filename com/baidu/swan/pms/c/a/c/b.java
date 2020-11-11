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
    private f ehW;
    private AtomicBoolean ehX = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b ehY = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.ehW = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.ehW == fVar) {
                b.this.ehW = null;
            }
        }
    };
    private l ehZ = new l(this.ehY);
    private com.baidu.swan.pms.c.a.d.a eia = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable hT(boolean z) {
            return b.this.hS(z);
        }
    };
    private c ehT = new c();
    private BlockingQueue<Runnable> ehU = new LinkedBlockingQueue();
    private ThreadPoolExecutor ehV = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.ehU);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.ehZ.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.ehZ.f(bVar);
    }

    public b() {
        a(this.ehT);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.ehT.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.ehT);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.ehU);
        }
    }

    public synchronized void start() {
        if (this.ehU.size() < 1) {
            this.ehV.execute(new g(this.ehX, this.ehZ, this.eia));
        }
    }

    public synchronized Runnable hS(boolean z) {
        f fVar;
        if (this.ehT != null) {
            if (z) {
                fVar = this.ehT.bbD();
            } else {
                fVar = this.ehT.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean yj(String str) {
        boolean z;
        if (this.ehW == null) {
            z = false;
        } else {
            Object bbK = this.ehW.bbK();
            if (bbK instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) bbK;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.ehG + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.ehG, str);
            } else if (bbK instanceof a.C0558a) {
                a.C0558a c0558a = (a.C0558a) bbK;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0558a.ehG + ", checking id: " + str);
                }
                z = TextUtils.equals(c0558a.ehG, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + bbK.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean yk(String str) {
        boolean z;
        Iterator<f> bbE = this.ehT.bbE();
        while (true) {
            if (bbE.hasNext()) {
                f next = bbE.next();
                if (next != null) {
                    Object bbK = next.bbK();
                    if (bbK instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) bbK;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.ehG + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.ehG, str)) {
                            z = true;
                            break;
                        }
                    } else if (bbK instanceof a.C0558a) {
                        a.C0558a c0558a = (a.C0558a) bbK;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0558a.ehG + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0558a.ehG, str)) {
                            z = true;
                            break;
                        }
                    } else if (d.DEBUG) {
                        Log.v("PMSThreadQueue", "Queue model type not match: " + bbK.getClass().getSimpleName());
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
