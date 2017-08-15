package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final boolean uY;
    protected final e uZ;

    public abstract g<T> W(String str);

    public abstract void X(String str);

    protected abstract void Y(String str);

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
        g<T> W = W(h);
        if (W == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (W.vg < System.currentTimeMillis()) {
            Y(h);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.uZ.eJ()) {
                W.vf = System.currentTimeMillis();
                c(W);
            }
            if (BdLog.isDebugMode()) {
            }
            return W;
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
        X(h(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.k
    public e eI() {
        return this.uZ;
    }
}
