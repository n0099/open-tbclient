package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.f;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class p<T> implements o.d<T> {
    private boolean tP = false;
    protected final n<T> tQ;
    protected final String tw;

    public p(String str, n<T> nVar) {
        this.tw = str;
        this.tQ = nVar;
    }

    @Override // com.baidu.adp.lib.cache.o
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hz()) {
            if (this.tP) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tQ.k(this.tw, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public o.c<T> U(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hz()) {
            if (this.tP) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tQ.l(this.tw, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hz()) {
            if (this.tP) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.tQ.a(this.tw, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.o
    public void k(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hz()) {
            if (this.tP) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.tQ.m(this.tw, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, o.a<T> aVar) {
        com.baidu.adp.lib.g.k.fS().f(new q(this, str, aVar));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, o.b<T> bVar) {
        com.baidu.adp.lib.g.k.fS().f(new r(this, str, bVar));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.g.k.fS().f(new s(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void l(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void V(String str) {
        com.baidu.adp.lib.g.k.fS().f(new t(this, str));
    }

    @Override // com.baidu.adp.lib.cache.o.d
    public String eJ() {
        return this.tw;
    }

    @Override // com.baidu.adp.lib.cache.o.d
    public n<T> eK() {
        return this.tQ;
    }

    public void eM() {
        this.tQ.T(this.tw);
    }

    protected void eN() {
        f ez = eK().ez();
        if (ez instanceof f.b) {
            ((f.b) ez).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.o.d
    public void eL() {
        this.tQ.S(this.tw);
        eN();
    }
}
