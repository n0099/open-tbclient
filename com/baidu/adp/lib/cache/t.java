package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public class t extends s {
    public t(String str, p pVar) {
        super(str, pVar);
    }

    @Override // com.baidu.adp.lib.cache.s, com.baidu.adp.lib.cache.q
    public Object a(String str) {
        try {
            return super.a(str);
        } catch (Throwable th) {
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.a(getClass(), "failed to get cache:" + str, th);
            }
            return null;
        }
    }

    @Override // com.baidu.adp.lib.cache.s, com.baidu.adp.lib.cache.q
    public void a(String str, Object obj, long j) {
        try {
            super.a(str, obj, j);
        } catch (Throwable th) {
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.a(getClass(), "failed to store cache key:" + str + ", value:" + obj, th);
            }
        }
    }

    @Override // com.baidu.adp.lib.cache.s
    public void b(String str) {
        try {
            super.b(str);
        } catch (Throwable th) {
            if (com.baidu.adp.lib.e.d.a()) {
                com.baidu.adp.lib.e.d.a(getClass(), "failed to remove cache:" + str, th);
            }
        }
    }
}
