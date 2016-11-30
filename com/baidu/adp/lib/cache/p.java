package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.f;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class p<T> implements o.d<T> {
    protected final n<T> mA;
    protected final String mf;
    private boolean mz = false;

    public p(String str, n<T> nVar) {
        this.mf = str;
        this.mA = nVar;
    }

    @Override // com.baidu.adp.lib.cache.o
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.gC()) {
            if (this.mz) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.mA.k(this.mf, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public o.c<T> T(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.gC()) {
            if (this.mz) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.mA.l(this.mf, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.gC()) {
            if (this.mz) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.mA.a(this.mf, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.o
    public void k(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.gC()) {
            if (this.mz) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.mA.m(this.mf, str);
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
        return this.mf;
    }

    @Override // com.baidu.adp.lib.cache.o.d
    public n<T> dE() {
        return this.mA;
    }

    public void dG() {
        this.mA.S(this.mf);
    }

    protected void dH() {
        f dt = dE().dt();
        if (dt instanceof f.b) {
            ((f.b) dt).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.o.d
    public void dF() {
        this.mA.R(this.mf);
        dH();
    }
}
