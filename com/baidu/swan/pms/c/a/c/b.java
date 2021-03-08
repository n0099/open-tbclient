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
/* loaded from: classes3.dex */
public class b {
    private f evT;
    private AtomicBoolean evU = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b evV = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.evT = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.evT == fVar) {
                b.this.evT = null;
            }
        }
    };
    private l evW = new l(this.evV);
    private com.baidu.swan.pms.c.a.d.a evX = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable iD(boolean z) {
            return b.this.iC(z);
        }
    };
    private c evQ = new c();
    private BlockingQueue<Runnable> evR = new LinkedBlockingQueue();
    private ThreadPoolExecutor evS = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.evR);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.evW.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.evW.f(bVar);
    }

    public b() {
        a(this.evQ);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.evQ.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.evQ);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.evR);
        }
    }

    public synchronized void start() {
        if (this.evR.size() < 1) {
            this.evS.execute(new g(this.evU, this.evW, this.evX));
        }
    }

    public synchronized Runnable iC(boolean z) {
        f fVar;
        if (this.evQ != null) {
            if (z) {
                fVar = this.evQ.bcT();
            } else {
                fVar = this.evQ.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean xZ(String str) {
        boolean z;
        if (this.evT == null) {
            z = false;
        } else {
            Object bda = this.evT.bda();
            if (bda instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) bda;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.evD + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.evD, str);
            } else if (bda instanceof a.C0545a) {
                a.C0545a c0545a = (a.C0545a) bda;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0545a.evD + ", checking id: " + str);
                }
                z = TextUtils.equals(c0545a.evD, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + bda.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean ya(String str) {
        boolean z;
        Iterator<f> bcU = this.evQ.bcU();
        while (true) {
            if (bcU.hasNext()) {
                f next = bcU.next();
                if (next != null) {
                    Object bda = next.bda();
                    if (bda instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) bda;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.evD + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.evD, str)) {
                            z = true;
                            break;
                        }
                    } else if (bda instanceof a.C0545a) {
                        a.C0545a c0545a = (a.C0545a) bda;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0545a.evD + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0545a.evD, str)) {
                            z = true;
                            break;
                        }
                    } else if (d.DEBUG) {
                        Log.v("PMSThreadQueue", "Queue model type not match: " + bda.getClass().getSimpleName());
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
