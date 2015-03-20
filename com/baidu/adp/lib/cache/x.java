package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class x<T> implements w<T> {
    protected final String sU;
    private boolean tp = false;
    protected final s<T> tq;

    public x(String str, s<T> sVar) {
        this.sU = str;
        this.tq = sVar;
    }

    @Override // com.baidu.adp.lib.cache.t
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.n.iW()) {
            if (this.tp) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tq.l(this.sU, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public v<T> ab(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.n.iW()) {
            if (this.tp) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tq.m(this.sU, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.n.iW()) {
            if (this.tp) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.tq.a(this.sU, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.t
    public void f(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.n.iW()) {
            if (this.tp) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.tq.n(this.sU, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void a(String str, u<T> uVar) {
        com.baidu.adp.lib.g.l.hJ().c(new y(this, str, uVar));
    }

    @Override // com.baidu.adp.lib.cache.t
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.g.l.hJ().c(new z(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.t
    public void g(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void ac(String str) {
        com.baidu.adp.lib.g.l.hJ().c(new aa(this, str));
    }

    @Override // com.baidu.adp.lib.cache.w
    public String gr() {
        return this.sU;
    }

    @Override // com.baidu.adp.lib.cache.w
    public s<T> gs() {
        return this.tq;
    }

    public void gu() {
        this.tq.aa(this.sU);
    }

    protected void gv() {
        f gg = gs().gg();
        if (gg instanceof h) {
            ((h) gg).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.w
    public void gt() {
        this.tq.Z(this.sU);
        gv();
    }
}
