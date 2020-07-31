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
/* loaded from: classes19.dex */
public class b {
    private f dww;
    private AtomicBoolean dwx = new AtomicBoolean(false);
    private com.baidu.swan.pms.c.a.d.b dwy = new com.baidu.swan.pms.c.a.d.b() { // from class: com.baidu.swan.pms.c.a.c.b.1
        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void d(f<T> fVar) {
            b.this.dww = fVar;
        }

        @Override // com.baidu.swan.pms.c.a.d.b
        public <T> void e(f<T> fVar) {
            if (b.this.dww == fVar) {
                b.this.dww = null;
            }
        }
    };
    private l dwz = new l(this.dwy);
    private com.baidu.swan.pms.c.a.d.a dwA = new com.baidu.swan.pms.c.a.d.a() { // from class: com.baidu.swan.pms.c.a.c.b.2
        @Override // com.baidu.swan.pms.c.a.d.a
        public Runnable gI(boolean z) {
            return b.this.gH(z);
        }
    };
    private c dwt = new c();
    private BlockingQueue<Runnable> dwu = new LinkedBlockingQueue();
    private ThreadPoolExecutor dwv = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.dwu);

    public void a(com.baidu.swan.pms.c.a.d.b bVar) {
        this.dwz.e(bVar);
    }

    public void b(com.baidu.swan.pms.c.a.d.b bVar) {
        this.dwz.f(bVar);
    }

    public b() {
        a(this.dwt);
    }

    public synchronized <T> void b(f<T> fVar) {
        c(fVar);
        start();
    }

    public synchronized <T> void c(f<T> fVar) {
        this.dwt.f(fVar);
        if (d.DEBUG) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.dwt);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.dwu);
        }
    }

    public synchronized void start() {
        if (this.dwu.size() < 1) {
            this.dwv.execute(new g(this.dwx, this.dwz, this.dwA));
        }
    }

    public synchronized Runnable gH(boolean z) {
        f fVar;
        if (this.dwt != null) {
            if (z) {
                fVar = this.dwt.aLq();
            } else {
                fVar = this.dwt.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean uo(String str) {
        boolean z;
        if (this.dww == null) {
            z = false;
        } else {
            Object aLx = this.dww.aLx();
            if (aLx instanceof com.baidu.swan.pms.model.f) {
                com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aLx;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.dvZ + ", checking id: " + str);
                }
                z = TextUtils.equals(fVar.dvZ, str);
            } else if (aLx instanceof a.C0474a) {
                a.C0474a c0474a = (a.C0474a) aLx;
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current Item appId: " + c0474a.dvZ + ", checking id: " + str);
                }
                z = TextUtils.equals(c0474a.dvZ, str);
            } else {
                if (d.DEBUG) {
                    Log.v("PMSThreadQueue", "Current model type not match: " + aLx.getClass().getSimpleName());
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean up(String str) {
        boolean z;
        Iterator<f> aLr = this.dwt.aLr();
        while (true) {
            if (aLr.hasNext()) {
                f next = aLr.next();
                if (next != null) {
                    Object aLx = next.aLx();
                    if (aLx instanceof com.baidu.swan.pms.model.f) {
                        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) aLx;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.dvZ + ", checking id: " + str);
                        }
                        if (TextUtils.equals(fVar.dvZ, str)) {
                            z = true;
                            break;
                        }
                    } else if (aLx instanceof a.C0474a) {
                        a.C0474a c0474a = (a.C0474a) aLx;
                        if (d.DEBUG) {
                            Log.v("PMSThreadQueue", "Queue Item appId: " + c0474a.dvZ + ", checking id: " + str);
                        }
                        if (TextUtils.equals(c0474a.dvZ, str)) {
                            z = true;
                            break;
                        }
                    } else if (d.DEBUG) {
                        Log.v("PMSThreadQueue", "Queue model type not match: " + aLx.getClass().getSimpleName());
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
