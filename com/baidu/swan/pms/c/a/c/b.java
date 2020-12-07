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
    private f enq;
    private AtomicBoolean enr = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b ens = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.enq = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.enq == fVar) {
                b.this.enq = null;
            }
        }
    };
    private l ent = new l(this.ens);
    private com.baidu.swan.pms.c.a.d.a enu = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable il(boolean z) {
            return b.this.ik(z);
        }
    };
    private c enn = new c();
    private BlockingQueue<Runnable> eno = new LinkedBlockingQueue();
    private ThreadPoolExecutor enp = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.eno);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.ent.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.ent.f(bVar);
    }

    public b() {
        a(this.enn);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.enn.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.enn);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.eno);
        }
    }

    public synchronized void start() {
        if (this.eno.size() < 1) {
            this.enp.execute(new g(this.enr, this.ent, this.enu));
        }
    }

    public synchronized Runnable ik(boolean z) {
        f fVar;
        if (this.enn != null) {
            if (z) {
                fVar = this.enn.beb();
            } else {
                fVar = this.enn.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean yL(String str) {
        boolean z;
        if (this.enq == null) {
            z = false;
        } else {
            Object bei = this.enq.bei();
            if (bei instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) bei;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.emZ + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.emZ, str);
            } else if (bei instanceof a.C0568a) {
                a.C0568a c0568a = (a.C0568a) bei;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0568a.emZ + ", checking id: " + str);
                }
                z = TextUtils.equals(c0568a.emZ, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + bei.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean yM(String str) {
        boolean z;
        Iterator<f> bec = this.enn.bec();
        while (true) {
            if (bec.hasNext()) {
                f next = bec.next();
                if (next != null) {
                    Object bei = next.bei();
                    if (bei instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) bei;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.emZ + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.emZ, str)) {
                            z = true;
                            break;
                        }
                    } else if (bei instanceof a.C0568a) {
                        a.C0568a c0568a = (a.C0568a) bei;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0568a.emZ + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0568a.emZ, str)) {
                            z = true;
                            break;
                        }
                    } else if (d.DEBUG) {
                        Log.v("PMSThreadQueue", "Queue model type not match: " + bei.getClass().getSimpleName());
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
