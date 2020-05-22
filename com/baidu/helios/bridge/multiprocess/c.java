package com.baidu.helios.bridge.multiprocess;

import android.os.Bundle;
import com.baidu.helios.bridge.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class c extends com.baidu.helios.bridge.a {
    private volatile h aps;
    private volatile com.baidu.helios.bridge.a.a apt;
    private volatile Future<Boolean> apu;
    private volatile Future<Boolean> apv;
    private volatile boolean g;
    private volatile boolean j;
    private String k;
    private Object l = new Object();
    private Object apw = new Object();
    private volatile boolean e = true;
    private volatile boolean f = false;

    public c(String str) {
        this.k = str;
    }

    private void b() {
        if (this.e || this.f) {
            return;
        }
        synchronized (this.apw) {
            c();
        }
        try {
            this.apv.get();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f || this.apv != null) {
            return;
        }
        this.apv = this.aoS.aoW.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.apt = new com.baidu.helios.bridge.a.a();
                c.this.apt.a(c.this.aoS);
                c.this.apt.a(c.this.aoT);
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
                this.apu.get();
            } catch (Exception e) {
            }
        }
    }

    private void e() {
        if (this.g || this.apu != null) {
            return;
        }
        this.apu = this.aoS.aoW.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.aps = new h(c.this, c.this.k);
                c.this.aps.a(c.this.aoS);
                c.this.aps.a(c.this.aoT);
                c.this.g = true;
                if (c.this.aps.a()) {
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
                this.aps.a(str, bundle, cVar);
                return;
            }
        }
        b();
        this.apt.a(str, bundle, cVar);
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        if (this.e) {
            synchronized (this.l) {
                e();
            }
            return;
        }
        synchronized (this.apw) {
            c();
        }
    }

    @Override // com.baidu.helios.bridge.a
    public a.d d(String str, Bundle bundle) {
        if (this.e) {
            d();
            if (this.j) {
                a.d d = this.aps.d(str, bundle);
                if (d.isSuccess()) {
                    return d;
                }
                this.e = false;
            }
        }
        b();
        return this.apt.d(str, bundle);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean dV(String str) {
        if (this.e) {
            d();
            if (this.j) {
                return this.aps.dV(str);
            }
        }
        b();
        return this.apt.dV(str);
    }
}
