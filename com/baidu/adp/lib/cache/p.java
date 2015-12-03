package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.f;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class p<T> implements o.c<T> {
    protected final String tc;
    private boolean tx = false;
    protected final n<T> ty;

    public p(String str, n<T> nVar) {
        this.tc = str;
        this.ty = nVar;
    }

    @Override // com.baidu.adp.lib.cache.o
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jf()) {
            if (this.tx) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.ty.l(this.tc, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public o.b<T> aa(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jf()) {
            if (this.tx) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.ty.m(this.tc, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jf()) {
            if (this.tx) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.ty.a(this.tc, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.o
    public void f(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jf()) {
            if (this.tx) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.ty.n(this.tc, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, o.a<T> aVar) {
        com.baidu.adp.lib.h.k.hk().c(new q(this, str, aVar));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.h.k.hk().c(new r(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void g(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void ab(String str) {
        com.baidu.adp.lib.h.k.hk().c(new s(this, str));
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public String gm() {
        return this.tc;
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public n<T> gn() {
        return this.ty;
    }

    public void gp() {
        this.ty.Z(this.tc);
    }

    protected void gq() {
        f gb = gn().gb();
        if (gb instanceof f.b) {
            ((f.b) gb).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public void go() {
        this.ty.Y(this.tc);
        gq();
    }
}
