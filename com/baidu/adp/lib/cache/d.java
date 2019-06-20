package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final boolean yl;
    protected final e ym;

    public abstract g<T> ai(String str);

    public abstract void aj(String str);

    protected abstract void ak(String str);

    public abstract void c(g<T> gVar);

    public d(e eVar, boolean z) {
        this.ym = eVar;
        this.yl = z;
    }

    protected String j(String str, String str2) {
        if (this.yl) {
            return str + "@" + str2;
        }
        return str2;
    }

    protected g<T> k(String str, String str2) {
        String j = j(str, str2);
        g<T> ai = ai(j);
        if (ai == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (ai.yt < System.currentTimeMillis()) {
            ak(j);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.ym.hj()) {
                ai.ys = System.currentTimeMillis();
                c(ai);
            }
            if (BdLog.isDebugMode()) {
            }
            return ai;
        }
    }

    @Override // com.baidu.adp.lib.cache.k
    public T l(String str, String str2) {
        g<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        return k.value;
    }

    @Override // com.baidu.adp.lib.cache.k
    public l.b<T> m(String str, String str2) {
        g<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        l.b<T> bVar = new l.b<>();
        bVar.key = str2;
        bVar.value = k.value;
        bVar.yt = k.yt;
        bVar.yG = k.yr;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.k
    public void a(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.yp = j(str, str2);
        gVar.yq = str;
        gVar.yt = j;
        gVar.value = t;
        gVar.ys = System.currentTimeMillis();
        gVar.yr = System.currentTimeMillis();
        c(gVar);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void n(String str, String str2) {
        aj(j(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.k
    public e hi() {
        return this.ym;
    }
}
