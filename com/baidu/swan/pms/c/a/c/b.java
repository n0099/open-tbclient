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
    private f dFD;
    private AtomicBoolean dFE = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b dFF = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.dFD = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.dFD == fVar) {
                b.this.dFD = null;
            }
        }
    };
    private l dFG = new l(this.dFF);
    private com.baidu.swan.pms.c.a.d.a dFH = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable hd(boolean z) {
            return b.this.hc(z);
        }
    };
    private c dFA = new c();
    private BlockingQueue<Runnable> dFB = new LinkedBlockingQueue();
    private ThreadPoolExecutor dFC = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.dFB);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.dFG.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.dFG.f(bVar);
    }

    public b() {
        a(this.dFA);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.dFA.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.dFA);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.dFB);
        }
    }

    public synchronized void start() {
        if (this.dFB.size() < 1) {
            this.dFC.execute(new g(this.dFE, this.dFG, this.dFH));
        }
    }

    public synchronized Runnable hc(boolean z) {
        f fVar;
        if (this.dFA != null) {
            if (z) {
                fVar = this.dFA.aTP();
            } else {
                fVar = this.dFA.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean wx(String str) {
        boolean z;
        if (this.dFD == null) {
            z = false;
        } else {
            Object aTW = this.dFD.aTW();
            if (aTW instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aTW;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.dFn + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.dFn, str);
            } else if (aTW instanceof a.C0520a) {
                a.C0520a c0520a = (a.C0520a) aTW;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0520a.dFn + ", checking id: " + str);
                }
                z = TextUtils.equals(c0520a.dFn, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + aTW.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean wy(String str) {
        boolean z;
        Iterator<f> aTQ = this.dFA.aTQ();
        while (true) {
            if (aTQ.hasNext()) {
                f next = aTQ.next();
                if (next != null) {
                    Object aTW = next.aTW();
                    if (aTW instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aTW;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.dFn + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.dFn, str)) {
                            z = true;
                            break;
                        }
                    } else if (aTW instanceof a.C0520a) {
                        a.C0520a c0520a = (a.C0520a) aTW;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0520a.dFn + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0520a.dFn, str)) {
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
