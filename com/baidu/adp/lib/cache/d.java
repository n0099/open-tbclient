package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final boolean rs;
    protected final e rt;

    public abstract g<T> V(String str);

    public abstract void W(String str);

    protected abstract void X(String str);

    public abstract void c(g<T> gVar);

    public d(e eVar, boolean z) {
        this.rt = eVar;
        this.rs = z;
    }

    protected String h(String str, String str2) {
        if (this.rs) {
            return str + "@" + str2;
        }
        return str2;
    }

    protected g<T> j(String str, String str2) {
        String h = h(str, str2);
        g<T> V = V(h);
        if (V == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (V.rA < System.currentTimeMillis()) {
            X(h);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.rt.eg()) {
                V.rz = System.currentTimeMillis();
                c(V);
            }
            if (BdLog.isDebugMode()) {
            }
            return V;
        }
    }

    @Override // com.baidu.adp.lib.cache.k
    public T k(String str, String str2) {
        g<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        return j.value;
    }

    @Override // com.baidu.adp.lib.cache.k
    public l.b<T> l(String str, String str2) {
        g<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        l.b<T> bVar = new l.b<>();
        bVar.key = str2;
        bVar.value = j.value;
        bVar.rA = j.rA;
        bVar.rN = j.ry;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.k
    public void a(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.rw = h(str, str2);
        gVar.rx = str;
        gVar.rA = j;
        gVar.value = t;
        gVar.rz = System.currentTimeMillis();
        gVar.ry = System.currentTimeMillis();
        c(gVar);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void m(String str, String str2) {
        W(h(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.k
    public e ef() {
        return this.rt;
    }
}
