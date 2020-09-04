package com.baidu.helios.bridge.multiprocess;

import android.os.Bundle;
import com.baidu.helios.bridge.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes14.dex */
public class c extends com.baidu.helios.bridge.a {
    private volatile h avF;
    private volatile com.baidu.helios.bridge.a.a avG;
    private volatile Future<Boolean> avH;
    private volatile Future<Boolean> avI;
    private volatile boolean g;
    private volatile boolean j;
    private String k;
    private Object l = new Object();
    private Object avJ = new Object();
    private volatile boolean e = true;
    private volatile boolean f = false;

    public c(String str) {
        this.k = str;
    }

    private void b() {
        if (this.e || this.f) {
            return;
        }
        synchronized (this.avJ) {
            c();
        }
        try {
            this.avI.get();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f || this.avI != null) {
            return;
        }
        this.avI = this.avg.avk.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.avG = new com.baidu.helios.bridge.a.a();
                c.this.avG.a(c.this.avg);
                c.this.avG.a(c.this.avh);
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
                this.avH.get();
            } catch (Exception e) {
            }
        }
    }

    private void e() {
        if (this.g || this.avH != null) {
            return;
        }
        this.avH = this.avg.avk.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.avF = new h(c.this, c.this.k);
                c.this.avF.a(c.this.avg);
                c.this.avF.a(c.this.avh);
                c.this.g = true;
                if (c.this.avF.a()) {
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
                this.avF.a(str, bundle, cVar);
                return;
            }
        }
        b();
        this.avG.a(str, bundle, cVar);
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        if (this.e) {
            synchronized (this.l) {
                e();
            }
            return;
        }
        synchronized (this.avJ) {
            c();
        }
    }

    @Override // com.baidu.helios.bridge.a
    public a.d c(String str, Bundle bundle) {
        if (this.e) {
            d();
            if (this.j) {
                a.d c = this.avF.c(str, bundle);
                if (c.isSuccess()) {
                    return c;
                }
                this.e = false;
            }
        }
        b();
        return this.avG.c(str, bundle);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean fq(String str) {
        if (this.e) {
            d();
            if (this.j) {
                return this.avF.fq(str);
            }
        }
        b();
        return this.avG.fq(str);
    }
}
