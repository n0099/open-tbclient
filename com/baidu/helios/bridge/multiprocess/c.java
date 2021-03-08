package com.baidu.helios.bridge.multiprocess;

import android.os.Bundle;
import com.baidu.helios.bridge.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes5.dex */
public class c extends com.baidu.helios.bridge.a {
    private volatile h atf;
    private volatile com.baidu.helios.bridge.a.a atg;
    private volatile Future<Boolean> ath;
    private volatile Future<Boolean> ati;
    private volatile boolean g;
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
            this.ati.get();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f || this.ati != null) {
            return;
        }
        this.ati = this.asG.asK.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.atg = new com.baidu.helios.bridge.a.a();
                c.this.atg.a(c.this.asG);
                c.this.atg.a(c.this.asH);
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
                this.ath.get();
            } catch (Exception e) {
            }
        }
    }

    private void e() {
        if (this.g || this.ath != null) {
            return;
        }
        this.ath = this.asG.asK.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.atf = new h(c.this, c.this.k);
                c.this.atf.a(c.this.asG);
                c.this.atf.a(c.this.asH);
                c.this.g = true;
                if (c.this.atf.a()) {
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
                this.atf.a(str, bundle, cVar);
                return;
            }
        }
        b();
        this.atg.a(str, bundle, cVar);
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
                a.d d = this.atf.d(str, bundle);
                if (d.isSuccess()) {
                    return d;
                }
                this.e = false;
            }
        }
        b();
        return this.atg.d(str, bundle);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean ea(String str) {
        if (this.e) {
            d();
            if (this.j) {
                return this.atf.ea(str);
            }
        }
        b();
        return this.atg.ea(str);
    }
}
