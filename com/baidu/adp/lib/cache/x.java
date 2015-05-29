package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class x<T> implements w<T> {
    private boolean tA = false;
    protected final s<T> tB;
    protected final String tg;

    public x(String str, s<T> sVar) {
        this.tg = str;
        this.tB = sVar;
    }

    @Override // com.baidu.adp.lib.cache.t
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.n.jl()) {
            if (this.tA) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tB.l(this.tg, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public v<T> ad(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.n.jl()) {
            if (this.tA) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tB.m(this.tg, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.n.jl()) {
            if (this.tA) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.tB.a(this.tg, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.t
    public void f(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.n.jl()) {
            if (this.tA) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.tB.n(this.tg, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void a(String str, u<T> uVar) {
        com.baidu.adp.lib.g.l.ht().c(new y(this, str, uVar));
    }

    @Override // com.baidu.adp.lib.cache.t
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.g.l.ht().c(new z(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.t
    public void g(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void ae(String str) {
        com.baidu.adp.lib.g.l.ht().c(new aa(this, str));
    }

    @Override // com.baidu.adp.lib.cache.w
    public String gv() {
        return this.tg;
    }

    @Override // com.baidu.adp.lib.cache.w
    public s<T> gw() {
        return this.tB;
    }

    public void gy() {
        this.tB.ac(this.tg);
    }

    protected void gz() {
        f gk = gw().gk();
        if (gk instanceof h) {
            ((h) gk).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.w
    public void gx() {
        this.tB.ab(this.tg);
        gz();
    }
}
