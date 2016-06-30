package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.f;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class p<T> implements o.c<T> {
    private boolean jD = false;
    protected final n<T> jE;
    protected final String jk;

    public p(String str, n<T> nVar) {
        this.jk = str;
        this.jE = nVar;
    }

    @Override // com.baidu.adp.lib.cache.o
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.fH()) {
            if (this.jD) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.jE.k(this.jk, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public o.b<T> Q(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.fH()) {
            if (this.jD) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.jE.l(this.jk, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.fH()) {
            if (this.jD) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.jE.a(this.jk, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.o
    public void e(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.fH()) {
            if (this.jD) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.jE.m(this.jk, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, o.a<T> aVar) {
        com.baidu.adp.lib.h.k.dN().c(new q(this, str, aVar));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.h.k.dN().c(new r(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void f(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void R(String str) {
        com.baidu.adp.lib.h.k.dN().c(new s(this, str));
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public String cJ() {
        return this.jk;
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public n<T> cK() {
        return this.jE;
    }

    public void cM() {
        this.jE.P(this.jk);
    }

    protected void cN() {
        f cz = cK().cz();
        if (cz instanceof f.b) {
            ((f.b) cz).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public void cL() {
        this.jE.O(this.jk);
        cN();
    }
}
