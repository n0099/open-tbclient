package com.baidu.b.a.f.d;

import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class k {
    private f aal;
    private AtomicBoolean aam = new AtomicBoolean(false);
    private com.baidu.b.a.f.d.a.a aan = new com.baidu.b.a.f.d.a.a() { // from class: com.baidu.b.a.f.d.k.1
        @Override // com.baidu.b.a.f.d.a.a
        public void a(f fVar) {
            k.this.aal = fVar;
        }

        @Override // com.baidu.b.a.f.d.a.a
        public void b(f fVar) {
            if (k.this.aal == fVar) {
                k.this.aal = null;
            }
        }
    };
    private com.baidu.b.a.f.d.a.b aao = new com.baidu.b.a.f.d.a.b(this.aan);
    private b aap = new b() { // from class: com.baidu.b.a.f.d.k.2
        @Override // com.baidu.b.a.f.d.k.b
        public Runnable aw(boolean z) {
            return k.this.av(z);
        }
    };
    private h<f> aai = new h<>();
    private BlockingQueue<Runnable> aaj = new LinkedBlockingQueue();
    private ThreadPoolExecutor aak = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.aaj);

    /* loaded from: classes2.dex */
    public interface b {
        Runnable aw(boolean z);
    }

    public void c(com.baidu.b.a.f.d.a.a aVar) {
        this.aao.e(aVar);
    }

    public void d(com.baidu.b.a.f.d.a.a aVar) {
        this.aao.f(aVar);
    }

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        private AtomicBoolean aam;
        private com.baidu.b.a.f.d.a.a aar;
        private b aas;

        public a(AtomicBoolean atomicBoolean, com.baidu.b.a.f.d.a.a aVar, b bVar) {
            this.aam = atomicBoolean;
            this.aar = aVar;
            this.aas = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable aw;
            while (!this.aam.get() && (aw = this.aas.aw(true)) != null && (aw instanceof f)) {
                try {
                    l((f) aw);
                } catch (Throwable th) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        Log.e("ThreadQueue", "runTask error:" + th.toString());
                    }
                }
            }
        }

        private void l(f fVar) {
            this.aar.a(fVar);
            try {
                fVar.run();
            } catch (Exception e) {
                if (com.baidu.b.a.h.b.isDebug()) {
                    Log.e("ThreadQueue", "run task error:" + e.toString());
                }
            } finally {
                this.aar.b(fVar);
            }
        }
    }

    public synchronized void h(f fVar) {
        i(fVar);
        start();
    }

    public synchronized void i(f fVar) {
        this.aai.E(fVar);
    }

    public synchronized void start() {
        if (this.aaj.size() < 1) {
            this.aak.execute(new a(this.aam, this.aao, this.aap));
        }
    }

    public synchronized Runnable av(boolean z) {
        f fVar;
        if (this.aai != null) {
            if (z) {
                fVar = this.aai.rW();
            } else {
                fVar = this.aai.get();
            }
        } else {
            fVar = null;
        }
        return fVar;
    }

    public synchronized boolean b(f fVar, com.baidu.b.a.f.d.b bVar) {
        boolean z;
        if (this.aal != null && this.aal.d(fVar)) {
            this.aal.a(bVar);
            z = true;
        } else {
            f F = this.aai.F(fVar);
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
            if (this.aal == null || !this.aal.d(fVar)) {
                i = 0;
            } else {
                this.aal.at(true);
                i = 1;
            }
            if (this.aai.contains(fVar)) {
                this.aai.remove(fVar);
                i++;
            }
            z = i > 0;
        }
        return z;
    }

    public synchronized boolean k(f fVar) {
        f fVar2;
        fVar2 = this.aal;
        return (fVar2 == null || fVar == null) ? false : fVar2.d(fVar);
    }
}
