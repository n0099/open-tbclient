package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class x<T> implements w<T> {
    private boolean hQ = false;
    protected final s<T> hR;
    protected final String hx;

    public x(String str, s<T> sVar) {
        this.hx = str;
        this.hR = sVar;
    }

    @Override // com.baidu.adp.lib.cache.t
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.fu()) {
            if (this.hQ) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.hR.l(this.hx, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public v<T> U(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.fu()) {
            if (this.hQ) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.hR.m(this.hx, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.fu()) {
            if (this.hQ) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.hR.a(this.hx, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.t
    public void f(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.fu()) {
            if (this.hQ) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.hR.n(this.hx, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void a(String str, u<T> uVar) {
        com.baidu.adp.lib.g.l.em().c(new y(this, str, uVar));
    }

    @Override // com.baidu.adp.lib.cache.t
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.g.l.em().c(new z(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.t
    public void g(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void V(String str) {
        com.baidu.adp.lib.g.l.em().c(new aa(this, str));
    }

    @Override // com.baidu.adp.lib.cache.w
    public String cU() {
        return this.hx;
    }

    @Override // com.baidu.adp.lib.cache.w
    public s<T> cV() {
        return this.hR;
    }

    public void cX() {
        this.hR.T(this.hx);
    }

    protected void cY() {
        f cJ = cV().cJ();
        if (cJ instanceof h) {
            ((h) cJ).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.w
    public void cW() {
        this.hR.S(this.hx);
        cY();
    }
}
