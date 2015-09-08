package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements n<T> {
    protected final boolean sV;
    protected final f sW;

    public abstract h<T> W(String str);

    public abstract void X(String str);

    protected abstract void Y(String str);

    public abstract void c(h<T> hVar);

    public e(f fVar, boolean z) {
        this.sW = fVar;
        this.sV = z;
    }

    protected String j(String str, String str2) {
        if (this.sV) {
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
        } else if (W.te < System.currentTimeMillis()) {
            Y(j);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.sW.ge()) {
                W.td = System.currentTimeMillis();
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
        return k.sl;
    }

    @Override // com.baidu.adp.lib.cache.n
    public o.b<T> m(String str, String str2) {
        h<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        o.b<T> bVar = new o.b<>();
        bVar.key = str2;
        bVar.sl = k.sl;
        bVar.te = k.te;
        bVar.tv = k.tc;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.n
    public void a(String str, String str2, T t, long j) {
        h<T> hVar = new h<>();
        hVar.sZ = j(str, str2);
        hVar.tb = str;
        hVar.te = j;
        hVar.sl = t;
        hVar.td = System.currentTimeMillis();
        hVar.tc = System.currentTimeMillis();
        c(hVar);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void n(String str, String str2) {
        X(j(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.n
    public f gb() {
        return this.sW;
    }
}
