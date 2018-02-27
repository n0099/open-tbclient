package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final boolean agY;
    protected final e agZ;

    public abstract g<T> Y(String str);

    public abstract void Z(String str);

    protected abstract void aa(String str);

    public abstract void c(g<T> gVar);

    public d(e eVar, boolean z) {
        this.agZ = eVar;
        this.agY = z;
    }

    protected String h(String str, String str2) {
        if (this.agY) {
            return str + "@" + str2;
        }
        return str2;
    }

    protected g<T> j(String str, String str2) {
        String h = h(str, str2);
        g<T> Y = Y(h);
        if (Y == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (Y.ahg < System.currentTimeMillis()) {
            aa(h);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.agZ.mc()) {
                Y.ahf = System.currentTimeMillis();
                c(Y);
            }
            if (BdLog.isDebugMode()) {
            }
            return Y;
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
        bVar.ahg = j.ahg;
        bVar.ahv = j.ahe;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.k
    public void a(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.ahc = h(str, str2);
        gVar.ahd = str;
        gVar.ahg = j;
        gVar.value = t;
        gVar.ahf = System.currentTimeMillis();
        gVar.ahe = System.currentTimeMillis();
        c(gVar);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void m(String str, String str2) {
        Z(h(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.k
    public e mb() {
        return this.agZ;
    }
}
