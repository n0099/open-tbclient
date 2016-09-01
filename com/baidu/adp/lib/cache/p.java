package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.f;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class p<T> implements o.d<T> {
    protected final String md;
    private boolean my = false;
    protected final n<T> mz;

    public p(String str, n<T> nVar) {
        this.md = str;
        this.mz = nVar;
    }

    @Override // com.baidu.adp.lib.cache.o
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.gC()) {
            if (this.my) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.mz.k(this.md, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public o.c<T> T(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.gC()) {
            if (this.my) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.mz.l(this.md, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.gC()) {
            if (this.my) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.mz.a(this.md, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.o
    public void k(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.gC()) {
            if (this.my) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.mz.m(this.md, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, o.a<T> aVar) {
        com.baidu.adp.lib.h.k.eH().f(new q(this, str, aVar));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, o.b<T> bVar) {
        com.baidu.adp.lib.h.k.eH().f(new r(this, str, bVar));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.h.k.eH().f(new s(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void l(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void U(String str) {
        com.baidu.adp.lib.h.k.eH().f(new t(this, str));
    }

    @Override // com.baidu.adp.lib.cache.o.d
    public String dD() {
        return this.md;
    }

    @Override // com.baidu.adp.lib.cache.o.d
    public n<T> dE() {
        return this.mz;
    }

    public void dG() {
        this.mz.S(this.md);
    }

    protected void dH() {
        f dt = dE().dt();
        if (dt instanceof f.b) {
            ((f.b) dt).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.o.d
    public void dF() {
        this.mz.R(this.md);
        dH();
    }
}
