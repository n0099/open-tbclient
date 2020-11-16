package com.baidu.helios.bridge.multiprocess;

import android.os.Bundle;
import com.baidu.helios.bridge.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes5.dex */
public class c extends com.baidu.helios.bridge.a {
    private volatile h avg;
    private volatile com.baidu.helios.bridge.a.a avh;
    private volatile Future<Boolean> avi;
    private volatile Future<Boolean> avj;
    private volatile boolean g;
    private volatile boolean j;
    private String k;
    private Object l = new Object();
    private Object avk = new Object();
    private volatile boolean e = true;
    private volatile boolean f = false;

    public c(String str) {
        this.k = str;
    }

    private void b() {
        if (this.e || this.f) {
            return;
        }
        synchronized (this.avk) {
            c();
        }
        try {
            this.avj.get();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f || this.avj != null) {
            return;
        }
        this.avj = this.auH.auL.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.avh = new com.baidu.helios.bridge.a.a();
                c.this.avh.a(c.this.auH);
                c.this.avh.a(c.this.auI);
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
                this.avi.get();
            } catch (Exception e) {
            }
        }
    }

    private void e() {
        if (this.g || this.avi != null) {
            return;
        }
        this.avi = this.auH.auL.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.avg = new h(c.this, c.this.k);
                c.this.avg.a(c.this.auH);
                c.this.avg.a(c.this.auI);
                c.this.g = true;
                if (c.this.avg.a()) {
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
                this.avg.a(str, bundle, cVar);
                return;
            }
        }
        b();
        this.avh.a(str, bundle, cVar);
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        if (this.e) {
            synchronized (this.l) {
                e();
            }
            return;
        }
        synchronized (this.avk) {
            c();
        }
    }

    @Override // com.baidu.helios.bridge.a
    public a.d c(String str, Bundle bundle) {
        if (this.e) {
            d();
            if (this.j) {
                a.d c = this.avg.c(str, bundle);
                if (c.isSuccess()) {
                    return c;
                }
                this.e = false;
            }
        }
        b();
        return this.avh.c(str, bundle);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean fr(String str) {
        if (this.e) {
            d();
            if (this.j) {
                return this.avg.fr(str);
            }
        }
        b();
        return this.avh.fr(str);
    }
}
