package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final boolean AC;
    protected final e AD;

    public abstract void aA(String str);

    protected abstract void aB(String str);

    public abstract g<T> az(String str);

    public abstract void c(g<T> gVar);

    public d(e eVar, boolean z) {
        this.AD = eVar;
        this.AC = z;
    }

    protected String q(String str, String str2) {
        if (this.AC) {
            return str + "@" + str2;
        }
        return str2;
    }

    protected g<T> r(String str, String str2) {
        String q = q(str, str2);
        g<T> az = az(q);
        if (az == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (az.AK < System.currentTimeMillis()) {
            aB(q);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.AD.ir()) {
                az.AJ = System.currentTimeMillis();
                c(az);
            }
            if (BdLog.isDebugMode()) {
            }
            return az;
        }
    }

    @Override // com.baidu.adp.lib.cache.k
    public T s(String str, String str2) {
        g<T> r = r(str, str2);
        if (r == null) {
            return null;
        }
        return r.value;
    }

    @Override // com.baidu.adp.lib.cache.k
    public l.b<T> t(String str, String str2) {
        g<T> r = r(str, str2);
        if (r == null) {
            return null;
        }
        l.b<T> bVar = new l.b<>();
        bVar.key = str2;
        bVar.value = r.value;
        bVar.AK = r.AK;
        bVar.AZ = r.AI;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.k
    public void a(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.AG = q(str, str2);
        gVar.AH = str;
        gVar.AK = j;
        gVar.value = t;
        gVar.AJ = System.currentTimeMillis();
        gVar.AI = System.currentTimeMillis();
        c(gVar);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void u(String str, String str2) {
        aA(q(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.k
    public e iq() {
        return this.AD;
    }
}
