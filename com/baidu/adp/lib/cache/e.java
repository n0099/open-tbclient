package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements n<T> {
    protected final boolean tt;
    protected final f tu;

    public abstract h<T> T(String str);

    public abstract void U(String str);

    protected abstract void V(String str);

    public abstract void c(h<T> hVar);

    public e(f fVar, boolean z) {
        this.tu = fVar;
        this.tt = z;
    }

    protected String k(String str, String str2) {
        if (this.tt) {
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
        } else if (T.tB < System.currentTimeMillis()) {
            V(k);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.tu.gl()) {
                T.tA = System.currentTimeMillis();
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
        return l.sI;
    }

    @Override // com.baidu.adp.lib.cache.n
    public o.b<T> n(String str, String str2) {
        h<T> l = l(str, str2);
        if (l == null) {
            return null;
        }
        o.b<T> bVar = new o.b<>();
        bVar.key = str2;
        bVar.sI = l.sI;
        bVar.tB = l.tB;
        bVar.tQ = l.tz;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.n
    public void a(String str, String str2, T t, long j) {
        h<T> hVar = new h<>();
        hVar.tx = k(str, str2);
        hVar.ty = str;
        hVar.tB = j;
        hVar.sI = t;
        hVar.tA = System.currentTimeMillis();
        hVar.tz = System.currentTimeMillis();
        c(hVar);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void o(String str, String str2) {
        U(k(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.n
    public f gk() {
        return this.tu;
    }
}
