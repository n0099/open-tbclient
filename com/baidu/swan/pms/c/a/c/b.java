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
    private f dTI;
    private AtomicBoolean dTJ = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b dTK = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.dTI = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.dTI == fVar) {
                b.this.dTI = null;
            }
        }
    };
    private l dTL = new l(this.dTK);
    private com.baidu.swan.pms.c.a.d.a dTM = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable hx(boolean z) {
            return b.this.hw(z);
        }
    };
    private c dTF = new c();
    private BlockingQueue<Runnable> dTG = new LinkedBlockingQueue();
    private ThreadPoolExecutor dTH = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.dTG);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.dTL.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.dTL.f(bVar);
    }

    public b() {
        a(this.dTF);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.dTF.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.dTF);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.dTG);
        }
    }

    public synchronized void start() {
        if (this.dTG.size() < 1) {
            this.dTH.execute(new g(this.dTJ, this.dTL, this.dTM));
        }
    }

    public synchronized Runnable hw(boolean z) {
        f fVar;
        if (this.dTF != null) {
            if (z) {
                fVar = this.dTF.aXk();
            } else {
                fVar = this.dTF.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean xC(String str) {
        boolean z;
        if (this.dTI == null) {
            z = false;
        } else {
            Object aXr = this.dTI.aXr();
            if (aXr instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aXr;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.dTs + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.dTs, str);
            } else if (aXr instanceof a.C0532a) {
                a.C0532a c0532a = (a.C0532a) aXr;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0532a.dTs + ", checking id: " + str);
                }
                z = TextUtils.equals(c0532a.dTs, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + aXr.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean xD(String str) {
        boolean z;
        Iterator<f> aXl = this.dTF.aXl();
        while (true) {
            if (aXl.hasNext()) {
                f next = aXl.next();
                if (next != null) {
                    Object aXr = next.aXr();
                    if (aXr instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aXr;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.dTs + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.dTs, str)) {
                            z = true;
                            break;
                        }
                    } else if (aXr instanceof a.C0532a) {
                        a.C0532a c0532a = (a.C0532a) aXr;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0532a.dTs + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0532a.dTs, str)) {
                            z = true;
                            break;
                        }
                    } else if (d.DEBUG) {
                        Log.v("PMSThreadQueue", "Queue model type not match: " + aXr.getClass().getSimpleName());
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
