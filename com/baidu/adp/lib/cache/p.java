package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.f;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class p<T> implements o.c<T> {
    protected final String tb;
    private boolean tw = false;
    protected final n<T> tx;

    public p(String str, n<T> nVar) {
        this.tb = str;
        this.tx = nVar;
    }

    @Override // com.baidu.adp.lib.cache.o
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jb()) {
            if (this.tw) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tx.l(this.tb, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public o.b<T> ac(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jb()) {
            if (this.tw) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tx.m(this.tb, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jb()) {
            if (this.tw) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.tx.a(this.tb, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.o
    public void f(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.jb()) {
            if (this.tw) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.tx.n(this.tb, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, o.a<T> aVar) {
        com.baidu.adp.lib.g.k.hg().c(new q(this, str, aVar));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.g.k.hg().c(new r(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void g(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void ad(String str) {
        com.baidu.adp.lib.g.k.hg().c(new s(this, str));
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public String gn() {
        return this.tb;
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public n<T> go() {
        return this.tx;
    }

    public void gq() {
        this.tx.ab(this.tb);
    }

    protected void gr() {
        f gb = go().gb();
        if (gb instanceof f.b) {
            ((f.b) gb).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.o.c
    public void gp() {
        this.tx.aa(this.tb);
        gr();
    }
}
