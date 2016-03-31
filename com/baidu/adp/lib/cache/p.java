package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.f;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class p<T> implements o.c<T> {
    private boolean tR = false;
    protected final n<T> tS;
    protected final String ty;

    public p(String str, n<T> nVar) {
        this.ty = str;
        this.tS = nVar;
    }

    @Override // com.baidu.adp.lib.cache.o
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jv()) {
            if (this.tR) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tS.m(this.ty, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public o.b<T> Z(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jv()) {
            if (this.tR) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tS.n(this.ty, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jv()) {
            if (this.tR) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.tS.a(this.ty, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.o
    public void e(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jv()) {
            if (this.tR) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.tS.o(this.ty, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, o.a<T> aVar) {
        com.baidu.adp.lib.h.k.hy().c(new q(this, str, aVar));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.h.k.hy().c(new r(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void f(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void aa(String str) {
        com.baidu.adp.lib.h.k.hy().c(new s(this, str));
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public String gu() {
        return this.ty;
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public n<T> gv() {
        return this.tS;
    }

    public void gx() {
        this.tS.Y(this.ty);
    }

    protected void gy() {
        f gk = gv().gk();
        if (gk instanceof f.b) {
            ((f.b) gk).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public void gw() {
        this.tS.X(this.ty);
        gy();
    }
}
