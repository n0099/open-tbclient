package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class x<T> implements w<T> {
    private boolean hS = false;
    protected final s<T> hT;
    protected final String hz;

    public x(String str, s<T> sVar) {
        this.hz = str;
        this.hT = sVar;
    }

    @Override // com.baidu.adp.lib.cache.t
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.ft()) {
            if (this.hS) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.hT.l(this.hz, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public v<T> U(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.ft()) {
            if (this.hS) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.hT.m(this.hz, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.ft()) {
            if (this.hS) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.hT.a(this.hz, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.t
    public void f(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.ft()) {
            if (this.hS) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.hT.n(this.hz, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void a(String str, u<T> uVar) {
        com.baidu.adp.lib.g.l.ek().c(new y(this, str, uVar));
    }

    @Override // com.baidu.adp.lib.cache.t
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.g.l.ek().c(new z(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.t
    public void g(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void V(String str) {
        com.baidu.adp.lib.g.l.ek().c(new aa(this, str));
    }

    @Override // com.baidu.adp.lib.cache.w
    public String cS() {
        return this.hz;
    }

    @Override // com.baidu.adp.lib.cache.w
    public s<T> cT() {
        return this.hT;
    }

    public void cV() {
        this.hT.T(this.hz);
    }

    protected void cW() {
        f cH = cT().cH();
        if (cH instanceof h) {
            ((h) cH).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.w
    public void cU() {
        this.hT.S(this.hz);
        cW();
    }
}
