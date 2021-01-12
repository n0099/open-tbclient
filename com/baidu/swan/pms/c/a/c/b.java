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
    private f esl;
    private AtomicBoolean esm = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b esn = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.esl = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.esl == fVar) {
                b.this.esl = null;
            }
        }
    };
    private l eso = new l(this.esn);
    private com.baidu.swan.pms.c.a.d.a esp = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable iB(boolean z) {
            return b.this.iA(z);
        }
    };
    private c esi = new c();
    private BlockingQueue<Runnable> esj = new LinkedBlockingQueue();
    private ThreadPoolExecutor esk = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.esj);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.eso.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.eso.f(bVar);
    }

    public b() {
        a(this.esi);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.esi.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.esi);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.esj);
        }
    }

    public synchronized void start() {
        if (this.esj.size() < 1) {
            this.esk.execute(new g(this.esm, this.eso, this.esp));
        }
    }

    public synchronized Runnable iA(boolean z) {
        f fVar;
        if (this.esi != null) {
            if (z) {
                fVar = this.esi.bcE();
            } else {
                fVar = this.esi.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean xz(String str) {
        boolean z;
        if (this.esl == null) {
            z = false;
        } else {
            Object bcL = this.esl.bcL();
            if (bcL instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) bcL;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.erV + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.erV, str);
            } else if (bcL instanceof a.C0542a) {
                a.C0542a c0542a = (a.C0542a) bcL;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0542a.erV + ", checking id: " + str);
                }
                z = TextUtils.equals(c0542a.erV, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + bcL.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean xA(String str) {
        boolean z;
        Iterator<f> bcF = this.esi.bcF();
        while (true) {
            if (bcF.hasNext()) {
                f next = bcF.next();
                if (next != null) {
                    Object bcL = next.bcL();
                    if (bcL instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) bcL;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.erV + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.erV, str)) {
                            z = true;
                            break;
                        }
                    } else if (bcL instanceof a.C0542a) {
                        a.C0542a c0542a = (a.C0542a) bcL;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0542a.erV + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0542a.erV, str)) {
                            z = true;
                            break;
                        }
                    } else if (d.DEBUG) {
                        Log.v("PMSThreadQueue", "Queue model type not match: " + bcL.getClass().getSimpleName());
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
