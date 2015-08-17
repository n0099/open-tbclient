package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements n<T> {
    protected final boolean sX;
    protected final f sY;

    public abstract h<T> W(String str);

    public abstract void X(String str);

    protected abstract void Y(String str);

    public abstract void c(h<T> hVar);

    public e(f fVar, boolean z) {
        this.sY = fVar;
        this.sX = z;
    }

    protected String j(String str, String str2) {
        if (this.sX) {
            return String.valueOf(str) + "@" + str2;
        }
        return str2;
    }

    protected h<T> k(String str, String str2) {
        String j = j(str, str2);
        h<T> W = W(j);
        if (W == null) {
            BdLog.isDebugMode();
            return null;
        } else if (W.tg < System.currentTimeMillis()) {
            Y(j);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.sY.gh()) {
                W.tf = System.currentTimeMillis();
                c(W);
            }
            BdLog.isDebugMode();
            return W;
        }
    }

    @Override // com.baidu.adp.lib.cache.n
    public T l(String str, String str2) {
        h<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        return k.so;
    }

    @Override // com.baidu.adp.lib.cache.n
    public o.b<T> m(String str, String str2) {
        h<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        o.b<T> bVar = new o.b<>();
        bVar.key = str2;
        bVar.so = k.so;
        bVar.tg = k.tg;
        bVar.tx = k.te;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.n
    public void a(String str, String str2, T t, long j) {
        h<T> hVar = new h<>();
        hVar.tc = j(str, str2);
        hVar.td = str;
        hVar.tg = j;
        hVar.so = t;
        hVar.tf = System.currentTimeMillis();
        hVar.te = System.currentTimeMillis();
        c(hVar);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void n(String str, String str2) {
        X(j(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.n
    public f gf() {
        return this.sY;
    }
}
