package com.baidu.helios.bridge.multiprocess;

import android.os.Bundle;
import com.baidu.helios.bridge.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes4.dex */
public class c extends com.baidu.helios.bridge.a {
    private volatile h aqG;
    private volatile com.baidu.helios.bridge.a.a aqH;
    private volatile Future<Boolean> aqI;
    private volatile Future<Boolean> aqJ;
    private volatile boolean g;
    private volatile boolean j;
    private String k;
    private Object l = new Object();
    private Object aqK = new Object();
    private volatile boolean e = true;
    private volatile boolean f = false;

    public c(String str) {
        this.k = str;
    }

    private void b() {
        if (this.e || this.f) {
            return;
        }
        synchronized (this.aqK) {
            c();
        }
        try {
            this.aqJ.get();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f || this.aqJ != null) {
            return;
        }
        this.aqJ = this.aqh.aql.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.aqH = new com.baidu.helios.bridge.a.a();
                c.this.aqH.a(c.this.aqh);
                c.this.aqH.a(c.this.aqi);
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
                this.aqI.get();
            } catch (Exception e) {
            }
        }
    }

    private void e() {
        if (this.g || this.aqI != null) {
            return;
        }
        this.aqI = this.aqh.aql.submit(new Callable<Boolean>() { // from class: com.baidu.helios.bridge.multiprocess.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                c.this.aqG = new h(c.this, c.this.k);
                c.this.aqG.a(c.this.aqh);
                c.this.aqG.a(c.this.aqi);
                c.this.g = true;
                if (c.this.aqG.a()) {
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
                this.aqG.a(str, bundle, cVar);
                return;
            }
        }
        b();
        this.aqH.a(str, bundle, cVar);
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        if (this.e) {
            synchronized (this.l) {
                e();
            }
            return;
        }
        synchronized (this.aqK) {
            c();
        }
    }

    @Override // com.baidu.helios.bridge.a
    public a.d d(String str, Bundle bundle) {
        if (this.e) {
            d();
            if (this.j) {
                a.d d = this.aqG.d(str, bundle);
                if (d.isSuccess()) {
                    return d;
                }
                this.e = false;
            }
        }
        b();
        return this.aqH.d(str, bundle);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean dW(String str) {
        if (this.e) {
            d();
            if (this.j) {
                return this.aqG.dW(str);
            }
        }
        b();
        return this.aqH.dW(str);
    }
}
