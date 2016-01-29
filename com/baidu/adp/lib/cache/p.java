package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.f;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class p<T> implements o.c<T> {
    private boolean tI = false;
    protected final n<T> tJ;
    protected final String tp;

    public p(String str, n<T> nVar) {
        this.tp = str;
        this.tJ = nVar;
    }

    @Override // com.baidu.adp.lib.cache.o
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jp()) {
            if (this.tI) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tJ.m(this.tp, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public o.b<T> Z(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jp()) {
            if (this.tI) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tJ.n(this.tp, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jp()) {
            if (this.tI) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.tJ.a(this.tp, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.o
    public void f(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jp()) {
            if (this.tI) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.tJ.o(this.tp, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, o.a<T> aVar) {
        com.baidu.adp.lib.h.k.hs().c(new q(this, str, aVar));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.h.k.hs().c(new r(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void g(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void aa(String str) {
        com.baidu.adp.lib.h.k.hs().c(new s(this, str));
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public String gu() {
        return this.tp;
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public n<T> gv() {
        return this.tJ;
    }

    public void gx() {
        this.tJ.Y(this.tp);
    }

    protected void gy() {
        f gk = gv().gk();
        if (gk instanceof f.b) {
            ((f.b) gk).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public void gw() {
        this.tJ.X(this.tp);
        gy();
    }
}
