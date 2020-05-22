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
/* loaded from: classes11.dex */
public class b {
    private f dlT;
    private AtomicBoolean dlU = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b dlV = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.dlT = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.dlT == fVar) {
                b.this.dlT = null;
            }
        }
    };
    private l dlW = new l(this.dlV);
    private com.baidu.swan.pms.c.a.d.a dlX = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable gi(boolean z) {
            return b.this.gh(z);
        }
    };
    private c dlQ = new c();
    private BlockingQueue<Runnable> dlR = new LinkedBlockingQueue();
    private ThreadPoolExecutor dlS = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.dlR);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.dlW.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.dlW.f(bVar);
    }

    public b() {
        a(this.dlQ);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.dlQ.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.dlQ);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.dlR);
        }
    }

    public synchronized void start() {
        if (this.dlR.size() < 1) {
            this.dlS.execute(new g(this.dlU, this.dlW, this.dlX));
        }
    }

    public synchronized Runnable gh(boolean z) {
        f fVar;
        if (this.dlQ != null) {
            if (z) {
                fVar = this.dlQ.aGt();
            } else {
                fVar = this.dlQ.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean td(String str) {
        boolean z;
        if (this.dlT == null) {
            z = false;
        } else {
            Object aGA = this.dlT.aGA();
            if (aGA instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aGA;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.dlx + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.dlx, str);
            } else if (aGA instanceof a.C0456a) {
                a.C0456a c0456a = (a.C0456a) aGA;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0456a.dlx + ", checking id: " + str);
                }
                z = TextUtils.equals(c0456a.dlx, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + aGA.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean te(String str) {
        boolean z;
        Iterator<f> aGu = this.dlQ.aGu();
        while (true) {
            if (aGu.hasNext()) {
                f next = aGu.next();
                if (next != null) {
                    Object aGA = next.aGA();
                    if (aGA instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aGA;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.dlx + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.dlx, str)) {
                            z = true;
                            break;
                        }
                    } else if (aGA instanceof a.C0456a) {
                        a.C0456a c0456a = (a.C0456a) aGA;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0456a.dlx + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0456a.dlx, str)) {
                            z = true;
                            break;
                        }
                    } else if (d.DEBUG) {
                        Log.v("PMSThreadQueue", "Queue model type not match: " + aGA.getClass().getSimpleName());
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
