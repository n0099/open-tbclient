package com.baidu.helios.bridge.multiprocess;

import android.os.Bundle;
import com.baidu.helios.bridge.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes23.dex */
public class c extends com.baidu.helios.bridge.a {
    private volatile h awh;
    private volatile com.baidu.helios.bridge.a.a awi;
    private volatile Future<Boolean> awj;
    private volatile Future<Boolean> awk;
    private volatile boolean g;
    private volatile boolean j;
    private String k;
    private Object l = new Object();
    private Object awl = new Object();
    private volatile boolean e = true;
    private volatile boolean f = false;

    public c(String str) {
        this.k = str;
    }

    private void b() {
        if (this.e || this.f) {
            return;
        }
        synchronized (this.awl) {
            c();
        }
        try {
            this.awk.get();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f || this.awk != null) {
            return;
        }
        this.awk = this.avI.avM.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.awi = new com.baidu.helios.bridge.a.a();
                c.this.awi.a(c.this.avI);
                c.this.awi.a(c.this.avJ);
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
                this.awj.get();
            } catch (Exception e) {
            }
        }
    }

    private void e() {
        if (this.g || this.awj != null) {
            return;
        }
        this.awj = this.avI.avM.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.awh = new h(c.this, c.this.k);
                c.this.awh.a(c.this.avI);
                c.this.awh.a(c.this.avJ);
                c.this.g = true;
                if (c.this.awh.a()) {
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
                this.awh.a(str, bundle, cVar);
                return;
            }
        }
        b();
        this.awi.a(str, bundle, cVar);
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        if (this.e) {
            synchronized (this.l) {
                e();
            }
            return;
        }
        synchronized (this.awl) {
            c();
        }
    }

    @Override // com.baidu.helios.bridge.a
    public a.d c(String str, Bundle bundle) {
        if (this.e) {
            d();
            if (this.j) {
                a.d c = this.awh.c(str, bundle);
                if (c.isSuccess()) {
                    return c;
                }
                this.e = false;
            }
        }
        b();
        return this.awi.c(str, bundle);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean fs(String str) {
        if (this.e) {
            d();
            if (this.j) {
                return this.awh.fs(str);
            }
        }
        b();
        return this.awi.fs(str);
    }
}
