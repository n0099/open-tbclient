package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements n<T> {
    protected final boolean ti;
    protected final f tj;

    public abstract h<T> T(String str);

    public abstract void U(String str);

    protected abstract void V(String str);

    public abstract void c(h<T> hVar);

    public e(f fVar, boolean z) {
        this.tj = fVar;
        this.ti = z;
    }

    protected String k(String str, String str2) {
        if (this.ti) {
            return String.valueOf(str) + "@" + str2;
        }
        return str2;
    }

    protected h<T> l(String str, String str2) {
        String k = k(str, str2);
        h<T> T = T(k);
        if (T == null) {
            BdLog.isDebugMode();
            return null;
        } else if (T.ts < System.currentTimeMillis()) {
            V(k);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.tj.gl()) {
                T.tr = System.currentTimeMillis();
                c(T);
            }
            BdLog.isDebugMode();
            return T;
        }
    }

    @Override // com.baidu.adp.lib.cache.n
    public T m(String str, String str2) {
        h<T> l = l(str, str2);
        if (l == null) {
            return null;
        }
        return l.sz;
    }

    @Override // com.baidu.adp.lib.cache.n
    public o.b<T> n(String str, String str2) {
        h<T> l = l(str, str2);
        if (l == null) {
            return null;
        }
        o.b<T> bVar = new o.b<>();
        bVar.key = str2;
        bVar.sz = l.sz;
        bVar.ts = l.ts;
        bVar.tH = l.tq;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.n
    public void a(String str, String str2, T t, long j) {
        h<T> hVar = new h<>();
        hVar.tm = k(str, str2);
        hVar.tp = str;
        hVar.ts = j;
        hVar.sz = t;
        hVar.tr = System.currentTimeMillis();
        hVar.tq = System.currentTimeMillis();
        c(hVar);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void o(String str, String str2) {
        U(k(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.n
    public f gk() {
        return this.tj;
    }
}
