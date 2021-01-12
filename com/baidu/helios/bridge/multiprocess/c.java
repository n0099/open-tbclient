package com.baidu.helios.bridge.multiprocess;

import android.os.Bundle;
import com.baidu.helios.bridge.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes14.dex */
public class c extends com.baidu.helios.bridge.a {
    private volatile h arP;
    private volatile com.baidu.helios.bridge.a.a arQ;
    private volatile Future<Boolean> arR;
    private volatile boolean g;
    private volatile Future<Boolean> h;
    private volatile boolean j;
    private String k;
    private Object l = new Object();
    private Object m = new Object();
    private volatile boolean e = true;
    private volatile boolean f = false;

    public c(String str) {
        this.k = str;
    }

    private void b() {
        if (this.e || this.f) {
            return;
        }
        synchronized (this.m) {
            c();
        }
        try {
            this.arR.get();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f || this.arR != null) {
            return;
        }
        this.arR = this.arq.aru.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.arQ = new com.baidu.helios.bridge.a.a();
                c.this.arQ.a(c.this.arq);
                c.this.arQ.a(c.this.arr);
                c.this.f = true;
                return true;
            }
        });
    }

    private void d() {
        if (this.e) {
            if (!this.g) {
                synchronized (this.l) {
                    e();
                }
            }
            try {
                this.h.get();
            } catch (Exception e) {
            }
        }
    }

    private void e() {
        if (this.g || this.h != null) {
            return;
        }
        this.h = this.arq.aru.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.arP = new h(c.this, c.this.k);
                c.this.arP.a(c.this.arq);
                c.this.arP.a(c.this.arr);
                c.this.g = true;
                if (c.this.arP.a()) {
                    c.this.j = true;
                    return true;
                }
                c.this.j = false;
                c.this.e = false;
                c.this.c();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.e = false;
        c();
    }

    @Override // com.baidu.helios.bridge.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        if (this.e) {
            d();
            if (this.j) {
                this.arP.a(str, bundle, cVar);
                return;
            }
        }
        b();
        this.arQ.a(str, bundle, cVar);
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        if (this.e) {
            synchronized (this.l) {
                e();
            }
            return;
        }
        synchronized (this.m) {
            c();
        }
    }

    @Override // com.baidu.helios.bridge.a
    public a.d d(String str, Bundle bundle) {
        if (this.e) {
            d();
            if (this.j) {
                a.d d = this.arP.d(str, bundle);
                if (d.isSuccess()) {
                    return d;
                }
                this.e = false;
            }
        }
        b();
        return this.arQ.d(str, bundle);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean dU(String str) {
        if (this.e) {
            d();
            if (this.j) {
                return this.arP.dU(str);
            }
        }
        b();
        return this.arQ.dU(str);
    }
}
