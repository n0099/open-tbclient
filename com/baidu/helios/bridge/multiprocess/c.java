package com.baidu.helios.bridge.multiprocess;

import android.os.Bundle;
import com.baidu.helios.bridge.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class c extends com.baidu.helios.bridge.a {
    private volatile h awB;
    private volatile com.baidu.helios.bridge.a.a awC;
    private volatile Future<Boolean> awD;
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
            this.awD.get();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f || this.awD != null) {
            return;
        }
        this.awD = this.awc.awg.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.awC = new com.baidu.helios.bridge.a.a();
                c.this.awC.a(c.this.awc);
                c.this.awC.a(c.this.awd);
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
        this.h = this.awc.awg.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.awB = new h(c.this, c.this.k);
                c.this.awB.a(c.this.awc);
                c.this.awB.a(c.this.awd);
                c.this.g = true;
                if (c.this.awB.a()) {
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
                this.awB.a(str, bundle, cVar);
                return;
            }
        }
        b();
        this.awC.a(str, bundle, cVar);
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
    public a.d c(String str, Bundle bundle) {
        if (this.e) {
            d();
            if (this.j) {
                a.d c = this.awB.c(str, bundle);
                if (c.isSuccess()) {
                    return c;
                }
                this.e = false;
            }
        }
        b();
        return this.awC.c(str, bundle);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean fg(String str) {
        if (this.e) {
            d();
            if (this.j) {
                return this.awB.fg(str);
            }
        }
        b();
        return this.awC.fg(str);
    }
}
