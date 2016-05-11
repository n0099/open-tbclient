package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements n<T> {
    protected final boolean jh;
    protected final f ji;

    public abstract h<T> K(String str);

    public abstract void L(String str);

    protected abstract void M(String str);

    public abstract void c(h<T> hVar);

    public e(f fVar, boolean z) {
        this.ji = fVar;
        this.jh = z;
    }

    protected String h(String str, String str2) {
        if (this.jh) {
            return String.valueOf(str) + "@" + str2;
        }
        return str2;
    }

    protected h<T> j(String str, String str2) {
        String h = h(str, str2);
        h<T> K = K(h);
        if (K == null) {
            BdLog.isDebugMode();
            return null;
        } else if (K.jp < System.currentTimeMillis()) {
            M(h);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.ji.cz()) {
                K.jo = System.currentTimeMillis();
                c(K);
            }
            BdLog.isDebugMode();
            return K;
        }
    }

    @Override // com.baidu.adp.lib.cache.n
    public T k(String str, String str2) {
        h<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        return j.iz;
    }

    @Override // com.baidu.adp.lib.cache.n
    public o.b<T> l(String str, String str2) {
        h<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        o.b<T> bVar = new o.b<>();
        bVar.key = str2;
        bVar.iz = j.iz;
        bVar.jp = j.jp;
        bVar.jE = j.jn;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.n
    public void a(String str, String str2, T t, long j) {
        h<T> hVar = new h<>();
        hVar.jl = h(str, str2);
        hVar.jm = str;
        hVar.jp = j;
        hVar.iz = t;
        hVar.jo = System.currentTimeMillis();
        hVar.jn = System.currentTimeMillis();
        c(hVar);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void m(String str, String str2) {
        L(h(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.n
    public f cy() {
        return this.ji;
    }
}
