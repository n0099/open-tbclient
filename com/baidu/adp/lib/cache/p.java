package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.f;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class p<T> implements o.c<T> {
    protected final String td;
    private boolean ty = false;
    protected final n<T> tz;

    public p(String str, n<T> nVar) {
        this.td = str;
        this.tz = nVar;
    }

    @Override // com.baidu.adp.lib.cache.o
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.je()) {
            if (this.ty) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tz.l(this.td, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public o.b<T> ac(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.je()) {
            if (this.ty) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tz.m(this.td, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.je()) {
            if (this.ty) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.tz.a(this.td, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.o
    public void f(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.je()) {
            if (this.ty) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.tz.n(this.td, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, o.a<T> aVar) {
        com.baidu.adp.lib.g.k.hj().c(new q(this, str, aVar));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.g.k.hj().c(new r(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void g(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void ad(String str) {
        com.baidu.adp.lib.g.k.hj().c(new s(this, str));
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public String gq() {
        return this.td;
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public n<T> gr() {
        return this.tz;
    }

    public void gt() {
        this.tz.ab(this.td);
    }

    protected void gu() {
        f gf = gr().gf();
        if (gf instanceof f.b) {
            ((f.b) gf).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public void gs() {
        this.tz.aa(this.td);
        gu();
    }
}
