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
    private f egp;
    private AtomicBoolean egq = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b egr = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.egp = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.egp == fVar) {
                b.this.egp = null;
            }
        }
    };
    private l egs = new l(this.egr);
    private com.baidu.swan.pms.c.a.d.a egt = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable hW(boolean z) {
            return b.this.hV(z);
        }
    };
    private c egm = new c();
    private BlockingQueue<Runnable> egn = new LinkedBlockingQueue();
    private ThreadPoolExecutor ego = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.egn);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.egs.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.egs.f(bVar);
    }

    public b() {
        a(this.egm);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.egm.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.egm);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.egn);
        }
    }

    public synchronized void start() {
        if (this.egn.size() < 1) {
            this.ego.execute(new g(this.egq, this.egs, this.egt));
        }
    }

    public synchronized Runnable hV(boolean z) {
        f fVar;
        if (this.egm != null) {
            if (z) {
                fVar = this.egm.baW();
            } else {
                fVar = this.egm.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean ye(String str) {
        boolean z;
        if (this.egp == null) {
            z = false;
        } else {
            Object bbd = this.egp.bbd();
            if (bbd instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) bbd;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.efY + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.efY, str);
            } else if (bbd instanceof a.C0556a) {
                a.C0556a c0556a = (a.C0556a) bbd;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0556a.efY + ", checking id: " + str);
                }
                z = TextUtils.equals(c0556a.efY, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + bbd.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean yf(String str) {
        boolean z;
        Iterator<f> baX = this.egm.baX();
        while (true) {
            if (baX.hasNext()) {
                f next = baX.next();
                if (next != null) {
                    Object bbd = next.bbd();
                    if (bbd instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) bbd;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.efY + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.efY, str)) {
                            z = true;
                            break;
                        }
                    } else if (bbd instanceof a.C0556a) {
                        a.C0556a c0556a = (a.C0556a) bbd;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0556a.efY + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0556a.efY, str)) {
                            z = true;
                            break;
                        }
                    } else if (d.DEBUG) {
                        Log.v("PMSThreadQueue", "Queue model type not match: " + bbd.getClass().getSimpleName());
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
