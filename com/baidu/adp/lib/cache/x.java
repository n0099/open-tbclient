package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class x<T> implements w<T> {
    private boolean fO = false;
    protected final s<T> fP;
    protected final String fv;

    public x(String str, s<T> sVar) {
        this.fv = str;
        this.fP = sVar;
    }

    @Override // com.baidu.adp.lib.cache.t
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.m.fu()) {
            if (this.fO) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.fP.g(this.fv, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public v<T> G(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.m.fu()) {
            if (this.fO) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.fP.h(this.fv, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.m.fu()) {
            if (this.fO) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.fP.a(this.fv, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.t
    public void b(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.m.fu()) {
            if (this.fO) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.fP.j(this.fv, str);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void a(String str, u<T> uVar) {
        com.baidu.adp.lib.g.k.el().b(new y(this, str, uVar));
    }

    @Override // com.baidu.adp.lib.cache.t
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.g.k.el().b(new z(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.t
    public void c(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.t
    public void H(String str) {
        com.baidu.adp.lib.g.k.el().b(new aa(this, str));
    }

    @Override // com.baidu.adp.lib.cache.w
    public String ct() {
        return this.fv;
    }

    @Override // com.baidu.adp.lib.cache.w
    public s<T> cu() {
        return this.fP;
    }

    public void cw() {
        this.fP.F(this.fv);
    }

    protected void cx() {
        f ci = cu().ci();
        if (ci instanceof h) {
            ((h) ci).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.w
    public void cv() {
        this.fP.E(this.fv);
        cx();
    }
}
