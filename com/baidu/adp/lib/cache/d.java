package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final boolean uY;
    protected final e uZ;

    public abstract g<T> X(String str);

    public abstract void Y(String str);

    protected abstract void Z(String str);

    public abstract void c(g<T> gVar);

    public d(e eVar, boolean z) {
        this.uZ = eVar;
        this.uY = z;
    }

    protected String h(String str, String str2) {
        if (this.uY) {
            return str + "@" + str2;
        }
        return str2;
    }

    protected g<T> j(String str, String str2) {
        String h = h(str, str2);
        g<T> X = X(h);
        if (X == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (X.vg < System.currentTimeMillis()) {
            Z(h);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.uZ.eJ()) {
                X.vf = System.currentTimeMillis();
                c(X);
            }
            if (BdLog.isDebugMode()) {
            }
            return X;
        }
    }

    @Override // com.baidu.adp.lib.cache.k
    public T k(String str, String str2) {
        g<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        return j.up;
    }

    @Override // com.baidu.adp.lib.cache.k
    public l.c<T> l(String str, String str2) {
        g<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        l.c<T> cVar = new l.c<>();
        cVar.key = str2;
        cVar.up = j.up;
        cVar.vg = j.vg;
        cVar.vv = j.ve;
        return cVar;
    }

    @Override // com.baidu.adp.lib.cache.k
    public void a(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.vc = h(str, str2);
        gVar.vd = str;
        gVar.vg = j;
        gVar.up = t;
        gVar.vf = System.currentTimeMillis();
        gVar.ve = System.currentTimeMillis();
        c(gVar);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void m(String str, String str2) {
        Y(h(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.k
    public e eI() {
        return this.uZ;
    }
}
