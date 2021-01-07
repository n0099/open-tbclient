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
/* loaded from: classes6.dex */
public class b {
    private f ewY;
    private AtomicBoolean ewZ = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b exa = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.ewY = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.ewY == fVar) {
                b.this.ewY = null;
            }
        }
    };
    private l exb = new l(this.exa);
    private com.baidu.swan.pms.c.a.d.a exc = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable iF(boolean z) {
            return b.this.iE(z);
        }
    };
    private c ewV = new c();
    private BlockingQueue<Runnable> ewW = new LinkedBlockingQueue();
    private ThreadPoolExecutor ewX = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.ewW);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.exb.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.exb.f(bVar);
    }

    public b() {
        a(this.ewV);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.ewV.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.ewV);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.ewW);
        }
    }

    public synchronized void start() {
        if (this.ewW.size() < 1) {
            this.ewX.execute(new g(this.ewZ, this.exb, this.exc));
        }
    }

    public synchronized Runnable iE(boolean z) {
        f fVar;
        if (this.ewV != null) {
            if (z) {
                fVar = this.ewV.bgy();
            } else {
                fVar = this.ewV.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean yK(String str) {
        boolean z;
        if (this.ewY == null) {
            z = false;
        } else {
            Object bgF = this.ewY.bgF();
            if (bgF instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) bgF;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.ewI + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.ewI, str);
            } else if (bgF instanceof a.C0559a) {
                a.C0559a c0559a = (a.C0559a) bgF;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0559a.ewI + ", checking id: " + str);
                }
                z = TextUtils.equals(c0559a.ewI, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + bgF.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean yL(String str) {
        boolean z;
        Iterator<f> bgz = this.ewV.bgz();
        while (true) {
            if (bgz.hasNext()) {
                f next = bgz.next();
                if (next != null) {
                    Object bgF = next.bgF();
                    if (bgF instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) bgF;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.ewI + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.ewI, str)) {
                            z = true;
                            break;
                        }
                    } else if (bgF instanceof a.C0559a) {
                        a.C0559a c0559a = (a.C0559a) bgF;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0559a.ewI + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0559a.ewI, str)) {
                            z = true;
                            break;
                        }
                    } else if (d.DEBUG) {
                        Log.v("PMSThreadQueue", "Queue model type not match: " + bgF.getClass().getSimpleName());
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
