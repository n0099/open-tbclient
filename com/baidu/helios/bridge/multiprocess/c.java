package com.baidu.helios.bridge.multiprocess;

import android.os.Bundle;
import com.baidu.helios.bridge.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes14.dex */
public class c extends com.baidu.helios.bridge.a {
    private volatile h awe;
    private volatile com.baidu.helios.bridge.a.a awf;
    private volatile Future<Boolean> awg;
    private volatile Future<Boolean> awh;
    private volatile boolean g;
    private volatile boolean j;
    private String k;
    private Object l = new Object();
    private Object awi = new Object();
    private volatile boolean e = true;
    private volatile boolean f = false;

    public c(String str) {
        this.k = str;
    }

    private void b() {
        if (this.e || this.f) {
            return;
        }
        synchronized (this.awi) {
            c();
        }
        try {
            this.awh.get();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f || this.awh != null) {
            return;
        }
        this.awh = this.avF.avJ.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.awf = new com.baidu.helios.bridge.a.a();
                c.this.awf.a(c.this.avF);
                c.this.awf.a(c.this.avG);
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
                this.awg.get();
            } catch (Exception e) {
            }
        }
    }

    private void e() {
        if (this.g || this.awg != null) {
            return;
        }
        this.awg = this.avF.avJ.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.awe = new h(c.this, c.this.k);
                c.this.awe.a(c.this.avF);
                c.this.awe.a(c.this.avG);
                c.this.g = true;
                if (c.this.awe.a()) {
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
                this.awe.a(str, bundle, cVar);
                return;
            }
        }
        b();
        this.awf.a(str, bundle, cVar);
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        if (this.e) {
            synchronized (this.l) {
                e();
            }
            return;
        }
        synchronized (this.awi) {
            c();
        }
    }

    @Override // com.baidu.helios.bridge.a
    public a.d c(String str, Bundle bundle) {
        if (this.e) {
            d();
            if (this.j) {
                a.d c = this.awe.c(str, bundle);
                if (c.isSuccess()) {
                    return c;
                }
                this.e = false;
            }
        }
        b();
        return this.awf.c(str, bundle);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean fv(String str) {
        if (this.e) {
            d();
            if (this.j) {
                return this.awe.fv(str);
            }
        }
        b();
        return this.awf.fv(str);
    }
}
