package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements n<T> {
    protected final boolean sW;
    protected final f sX;

    public abstract h<T> U(String str);

    public abstract void V(String str);

    protected abstract void W(String str);

    public abstract void c(h<T> hVar);

    public e(f fVar, boolean z) {
        this.sX = fVar;
        this.sW = z;
    }

    protected String j(String str, String str2) {
        if (this.sW) {
            return String.valueOf(str) + "@" + str2;
        }
        return str2;
    }

    protected h<T> k(String str, String str2) {
        String j = j(str, str2);
        h<T> U = U(j);
        if (U == null) {
            BdLog.isDebugMode();
            return null;
        } else if (U.tf < System.currentTimeMillis()) {
            W(j);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.sX.gd()) {
                U.te = System.currentTimeMillis();
                c(U);
            }
            BdLog.isDebugMode();
            return U;
        }
    }

    @Override // com.baidu.adp.lib.cache.n
    public T l(String str, String str2) {
        h<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        return k.sm;
    }

    @Override // com.baidu.adp.lib.cache.n
    public o.b<T> m(String str, String str2) {
        h<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        o.b<T> bVar = new o.b<>();
        bVar.key = str2;
        bVar.sm = k.sm;
        bVar.tf = k.tf;
        bVar.tw = k.td;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.n
    public void a(String str, String str2, T t, long j) {
        h<T> hVar = new h<>();
        hVar.tb = j(str, str2);
        hVar.tc = str;
        hVar.tf = j;
        hVar.sm = t;
        hVar.te = System.currentTimeMillis();
        hVar.td = System.currentTimeMillis();
        c(hVar);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void n(String str, String str2) {
        V(j(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.n
    public f gb() {
        return this.sX;
    }
}
