package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements n<T> {
    protected final boolean jf;
    protected final f jg;

    public abstract h<T> K(String str);

    public abstract void L(String str);

    protected abstract void M(String str);

    public abstract void c(h<T> hVar);

    public e(f fVar, boolean z) {
        this.jg = fVar;
        this.jf = z;
    }

    protected String h(String str, String str2) {
        if (this.jf) {
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
        } else if (K.jn < System.currentTimeMillis()) {
            M(h);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.jg.cA()) {
                K.jm = System.currentTimeMillis();
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
        return j.ix;
    }

    @Override // com.baidu.adp.lib.cache.n
    public o.b<T> l(String str, String str2) {
        h<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        o.b<T> bVar = new o.b<>();
        bVar.key = str2;
        bVar.ix = j.ix;
        bVar.jn = j.jn;
        bVar.jC = j.jl;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.n
    public void a(String str, String str2, T t, long j) {
        h<T> hVar = new h<>();
        hVar.jj = h(str, str2);
        hVar.jk = str;
        hVar.jn = j;
        hVar.ix = t;
        hVar.jm = System.currentTimeMillis();
        hVar.jl = System.currentTimeMillis();
        c(hVar);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void m(String str, String str2) {
        L(h(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.n
    public f cz() {
        return this.jg;
    }
}
