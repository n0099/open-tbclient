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
/* loaded from: classes14.dex */
public class b {
    private AtomicBoolean dFA = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b dFB = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.dFz = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.dFz == fVar) {
                b.this.dFz = null;
            }
        }
    };
    private l dFC = new l(this.dFB);
    private com.baidu.swan.pms.c.a.d.a dFD = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable hc(boolean z) {
            return b.this.hb(z);
        }
    };
    private c dFw = new c();
    private BlockingQueue<Runnable> dFx = new LinkedBlockingQueue();
    private ThreadPoolExecutor dFy = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.dFx);
    private f dFz;

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.dFC.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.dFC.f(bVar);
    }

    public b() {
        a(this.dFw);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.dFw.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.dFw);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.dFx);
        }
    }

    public synchronized void start() {
        if (this.dFx.size() < 1) {
            this.dFy.execute(new g(this.dFA, this.dFC, this.dFD));
        }
    }

    public synchronized Runnable hb(boolean z) {
        f fVar;
        if (this.dFw != null) {
            if (z) {
                fVar = this.dFw.aTP();
            } else {
                fVar = this.dFw.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean ww(String str) {
        boolean z;
        if (this.dFz == null) {
            z = false;
        } else {
            Object aTW = this.dFz.aTW();
            if (aTW instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aTW;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.dFj + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.dFj, str);
            } else if (aTW instanceof a.C0520a) {
                a.C0520a c0520a = (a.C0520a) aTW;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0520a.dFj + ", checking id: " + str);
                }
                z = TextUtils.equals(c0520a.dFj, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + aTW.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean wx(String str) {
        boolean z;
        Iterator<f> aTQ = this.dFw.aTQ();
        while (true) {
            if (aTQ.hasNext()) {
                f next = aTQ.next();
                if (next != null) {
                    Object aTW = next.aTW();
                    if (aTW instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aTW;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.dFj + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.dFj, str)) {
                            z = true;
                            break;
                        }
                    } else if (aTW instanceof a.C0520a) {
                        a.C0520a c0520a = (a.C0520a) aTW;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0520a.dFj + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0520a.dFj, str)) {
                            z = true;
                            break;
                        }
                    } else if (d.DEBUG) {
                        Log.v("PMSThreadQueue", "Queue model type not match: " + aTW.getClass().getSimpleName());
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
