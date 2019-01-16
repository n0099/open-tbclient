package com.baidu.b.a.f.d;

import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class k {
    private f aau;
    private AtomicBoolean aav = new AtomicBoolean(false);
    private com.baidu.b.a.f.d.a.a aaw = new com.baidu.b.a.f.d.a.a() { // from class: com.baidu.b.a.f.d.k.1
        @Override // com.baidu.b.a.f.d.a.a
        public void a(f fVar) {
            k.this.aau = fVar;
        }

        @Override // com.baidu.b.a.f.d.a.a
        public void b(f fVar) {
            if (k.this.aau == fVar) {
                k.this.aau = null;
            }
        }
    };
    private com.baidu.b.a.f.d.a.b aax = new com.baidu.b.a.f.d.a.b(this.aaw);
    private b aay = new b() { // from class: com.baidu.b.a.f.d.k.2
        @Override // com.baidu.b.a.f.d.k.b
        public Runnable aK(boolean z) {
            return k.this.aJ(z);
        }
    };
    private h<f> aar = new h<>();
    private BlockingQueue<Runnable> aas = new LinkedBlockingQueue();
    private ThreadPoolExecutor aat = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.aas);

    /* loaded from: classes2.dex */
    public interface b {
        Runnable aK(boolean z);
    }

    public void c(com.baidu.b.a.f.d.a.a aVar) {
        this.aax.e(aVar);
    }

    public void d(com.baidu.b.a.f.d.a.a aVar) {
        this.aax.f(aVar);
    }

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        private com.baidu.b.a.f.d.a.a aaA;
        private b aaB;
        private AtomicBoolean aav;

        public a(AtomicBoolean atomicBoolean, com.baidu.b.a.f.d.a.a aVar, b bVar) {
            this.aav = atomicBoolean;
            this.aaA = aVar;
            this.aaB = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable aK;
            while (!this.aav.get() && (aK = this.aaB.aK(true)) != null && (aK instanceof f)) {
                try {
                    l((f) aK);
                } catch (Throwable th) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        Log.e("ThreadQueue", "runTask error:" + th.toString());
                    }
                }
            }
        }

        private void l(f fVar) {
            this.aaA.a(fVar);
            try {
                fVar.run();
            } catch (Exception e) {
                if (com.baidu.b.a.h.b.isDebug()) {
                    Log.e("ThreadQueue", "run task error:" + e.toString());
                }
            } finally {
                this.aaA.b(fVar);
            }
        }
    }

    public synchronized void h(f fVar) {
        i(fVar);
        start();
    }

    public synchronized void i(f fVar) {
        this.aar.E(fVar);
    }

    public synchronized void start() {
        if (this.aas.size() < 1) {
            this.aat.execute(new a(this.aav, this.aax, this.aay));
        }
    }

    public synchronized Runnable aJ(boolean z) {
        f fVar;
        if (this.aar != null) {
            if (z) {
                fVar = this.aar.rW();
            } else {
                fVar = this.aar.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean b(f fVar, com.baidu.b.a.f.d.b bVar) {
        boolean z;
        if (this.aau != null && this.aau.d(fVar)) {
            this.aau.a(bVar);
            z = true;
        } else {
            f F = this.aar.F(fVar);
            if (F != null) {
                if (com.baidu.b.a.h.b.isDebug()) {
                    Log.w("ThreadQueue", "found duplicated task in mWaitingQueue:" + fVar.toString());
                }
                F.a(bVar);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean j(f fVar) {
        int i;
        boolean z;
        synchronized (this) {
            if (this.aau == null || !this.aau.d(fVar)) {
                i = 0;
            } else {
                this.aau.aH(true);
                i = 1;
            }
            if (this.aar.contains(fVar)) {
                this.aar.remove(fVar);
                i++;
            }
            z = i > 0;
        }
        return z;
    }

    public synchronized boolean k(f fVar) {
        f fVar2;
        fVar2 = this.aau;
        return (fVar2 == null || fVar == null) ? false : fVar2.d(fVar);
    }
}
