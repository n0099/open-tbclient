package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.f;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class p<T> implements o.c<T> {
    private boolean jF = false;
    protected final n<T> jG;
    protected final String jm;

    public p(String str, n<T> nVar) {
        this.jm = str;
        this.jG = nVar;
    }

    @Override // com.baidu.adp.lib.cache.o
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.fG()) {
            if (this.jF) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.jG.k(this.jm, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public o.b<T> Q(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.fG()) {
            if (this.jF) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.jG.l(this.jm, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.fG()) {
            if (this.jF) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.jG.a(this.jm, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.o
    public void e(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.fG()) {
            if (this.jF) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.jG.m(this.jm, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, o.a<T> aVar) {
        com.baidu.adp.lib.h.k.dM().c(new q(this, str, aVar));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.h.k.dM().c(new r(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void f(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void R(String str) {
        com.baidu.adp.lib.h.k.dM().c(new s(this, str));
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public String cI() {
        return this.jm;
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public n<T> cJ() {
        return this.jG;
    }

    public void cL() {
        this.jG.P(this.jm);
    }

    protected void cM() {
        f cy = cJ().cy();
        if (cy instanceof f.b) {
            ((f.b) cy).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public void cK() {
        this.jG.O(this.jm);
        cM();
    }
}
