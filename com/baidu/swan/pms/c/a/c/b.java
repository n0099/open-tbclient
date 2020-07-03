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
    private f dqE;
    private AtomicBoolean dqF = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b dqG = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.dqE = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.dqE == fVar) {
                b.this.dqE = null;
            }
        }
    };
    private l dqH = new l(this.dqG);
    private com.baidu.swan.pms.c.a.d.a dqI = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable gn(boolean z) {
            return b.this.gm(z);
        }
    };
    private c dqB = new c();
    private BlockingQueue<Runnable> dqC = new LinkedBlockingQueue();
    private ThreadPoolExecutor dqD = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.dqC);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.dqH.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.dqH.f(bVar);
    }

    public b() {
        a(this.dqB);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.dqB.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.dqB);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.dqC);
        }
    }

    public synchronized void start() {
        if (this.dqC.size() < 1) {
            this.dqD.execute(new g(this.dqF, this.dqH, this.dqI));
        }
    }

    public synchronized Runnable gm(boolean z) {
        f fVar;
        if (this.dqB != null) {
            if (z) {
                fVar = this.dqB.aHz();
            } else {
                fVar = this.dqB.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean tl(String str) {
        boolean z;
        if (this.dqE == null) {
            z = false;
        } else {
            Object aHG = this.dqE.aHG();
            if (aHG instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aHG;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.dqi + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.dqi, str);
            } else if (aHG instanceof a.C0462a) {
                a.C0462a c0462a = (a.C0462a) aHG;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0462a.dqi + ", checking id: " + str);
                }
                z = TextUtils.equals(c0462a.dqi, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + aHG.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean tm(String str) {
        boolean z;
        Iterator<f> aHA = this.dqB.aHA();
        while (true) {
            if (aHA.hasNext()) {
                f next = aHA.next();
                if (next != null) {
                    Object aHG = next.aHG();
                    if (aHG instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aHG;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.dqi + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.dqi, str)) {
                            z = true;
                            break;
                        }
                    } else if (aHG instanceof a.C0462a) {
                        a.C0462a c0462a = (a.C0462a) aHG;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0462a.dqi + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0462a.dqi, str)) {
                            z = true;
                            break;
                        }
                    } else if (d.DEBUG) {
                        Log.v("PMSThreadQueue", "Queue model type not match: " + aHG.getClass().getSimpleName());
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
