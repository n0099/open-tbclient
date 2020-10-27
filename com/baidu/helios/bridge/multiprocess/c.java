package com.baidu.helios.bridge.multiprocess;

import android.os.Bundle;
import com.baidu.helios.bridge.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes17.dex */
public class c extends com.baidu.helios.bridge.a {
    private volatile h awR;
    private volatile com.baidu.helios.bridge.a.a awS;
    private volatile Future<Boolean> awT;
    private volatile Future<Boolean> awU;
    private volatile boolean g;
    private volatile boolean j;
    private String k;
    private Object l = new Object();
    private Object awV = new Object();
    private volatile boolean e = true;
    private volatile boolean f = false;

    public c(String str) {
        this.k = str;
    }

    private void b() {
        if (this.e || this.f) {
            return;
        }
        synchronized (this.awV) {
            c();
        }
        try {
            this.awU.get();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f || this.awU != null) {
            return;
        }
        this.awU = this.aws.aww.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.awS = new com.baidu.helios.bridge.a.a();
                c.this.awS.a(c.this.aws);
                c.this.awS.a(c.this.awt);
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
                this.awT.get();
            } catch (Exception e) {
            }
        }
    }

    private void e() {
        if (this.g || this.awT != null) {
            return;
        }
        this.awT = this.aws.aww.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.awR = new h(c.this, c.this.k);
                c.this.awR.a(c.this.aws);
                c.this.awR.a(c.this.awt);
                c.this.g = true;
                if (c.this.awR.a()) {
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
                this.awR.a(str, bundle, cVar);
                return;
            }
        }
        b();
        this.awS.a(str, bundle, cVar);
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        if (this.e) {
            synchronized (this.l) {
                e();
            }
            return;
        }
        synchronized (this.awV) {
            c();
        }
    }

    @Override // com.baidu.helios.bridge.a
    public a.d c(String str, Bundle bundle) {
        if (this.e) {
            d();
            if (this.j) {
                a.d c = this.awR.c(str, bundle);
                if (c.isSuccess()) {
                    return c;
                }
                this.e = false;
            }
        }
        b();
        return this.awS.c(str, bundle);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean fx(String str) {
        if (this.e) {
            d();
            if (this.j) {
                return this.awR.fx(str);
            }
        }
        b();
        return this.awS.fx(str);
    }
}
