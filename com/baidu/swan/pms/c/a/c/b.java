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
/* loaded from: classes24.dex */
public class b {
    private f dHH;
    private AtomicBoolean dHI = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b dHJ = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.dHH = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.dHH == fVar) {
                b.this.dHH = null;
            }
        }
    };
    private l dHK = new l(this.dHJ);
    private com.baidu.swan.pms.c.a.d.a dHL = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable hb(boolean z) {
            return b.this.ha(z);
        }
    };
    private c dHE = new c();
    private BlockingQueue<Runnable> dHF = new LinkedBlockingQueue();
    private ThreadPoolExecutor dHG = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.dHF);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.dHK.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.dHK.f(bVar);
    }

    public b() {
        a(this.dHE);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.dHE.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.dHE);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.dHF);
        }
    }

    public synchronized void start() {
        if (this.dHF.size() < 1) {
            this.dHG.execute(new g(this.dHI, this.dHK, this.dHL));
        }
    }

    public synchronized Runnable ha(boolean z) {
        f fVar;
        if (this.dHE != null) {
            if (z) {
                fVar = this.dHE.aUB();
            } else {
                fVar = this.dHE.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean wQ(String str) {
        boolean z;
        if (this.dHH == null) {
            z = false;
        } else {
            Object aUI = this.dHH.aUI();
            if (aUI instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aUI;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.dHr + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.dHr, str);
            } else if (aUI instanceof a.C0515a) {
                a.C0515a c0515a = (a.C0515a) aUI;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0515a.dHr + ", checking id: " + str);
                }
                z = TextUtils.equals(c0515a.dHr, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + aUI.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean wR(String str) {
        boolean z;
        Iterator<f> aUC = this.dHE.aUC();
        while (true) {
            if (aUC.hasNext()) {
                f next = aUC.next();
                if (next != null) {
                    Object aUI = next.aUI();
                    if (aUI instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aUI;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.dHr + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.dHr, str)) {
                            z = true;
                            break;
                        }
                    } else if (aUI instanceof a.C0515a) {
                        a.C0515a c0515a = (a.C0515a) aUI;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0515a.dHr + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0515a.dHr, str)) {
                            z = true;
                            break;
                        }
                    } else if (d.DEBUG) {
                        Log.v("PMSThreadQueue", "Queue model type not match: " + aUI.getClass().getSimpleName());
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
