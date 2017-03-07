package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.f;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class p<T> implements o.d<T> {
    protected final String tT;
    private boolean um = false;
    protected final n<T> uo;

    public p(String str, n<T> nVar) {
        this.tT = str;
        this.uo = nVar;
    }

    @Override // com.baidu.adp.lib.cache.o
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hu()) {
            if (this.um) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.uo.k(this.tT, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public o.c<T> S(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hu()) {
            if (this.um) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.uo.l(this.tT, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hu()) {
            if (this.um) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.uo.a(this.tT, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.o
    public void k(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hu()) {
            if (this.um) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.uo.m(this.tT, str);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, o.a<T> aVar) {
        com.baidu.adp.lib.g.k.fN().f(new q(this, str, aVar));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void a(String str, o.b<T> bVar) {
        com.baidu.adp.lib.g.k.fN().f(new r(this, str, bVar));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.g.k.fN().f(new s(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.o
    public void l(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.o
    public void T(String str) {
        com.baidu.adp.lib.g.k.fN().f(new t(this, str));
    }

    @Override // com.baidu.adp.lib.cache.o.d
    public String eK() {
        return this.tT;
    }

    @Override // com.baidu.adp.lib.cache.o.d
    public n<T> eL() {
        return this.uo;
    }

    public void eN() {
        this.uo.R(this.tT);
    }

    protected void eO() {
        f eA = eL().eA();
        if (eA instanceof f.b) {
            ((f.b) eA).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.o.d
    public void eM() {
        this.uo.Q(this.tT);
        eO();
    }
}
