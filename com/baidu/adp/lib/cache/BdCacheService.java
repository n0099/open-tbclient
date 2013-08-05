package com.baidu.adp.lib.cache;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService {

    /* renamed from: a  reason: collision with root package name */
    private static BdCacheService f366a;
    private u b;
    private Context c;
    private com.baidu.adp.a.f d;
    private final String e;
    private boolean f;
    private HashMap g = new HashMap();
    private HashMap h = new HashMap();

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static CacheEvictPolicy[] valuesCustom() {
            CacheEvictPolicy[] valuesCustom = values();
            int length = valuesCustom.length;
            CacheEvictPolicy[] cacheEvictPolicyArr = new CacheEvictPolicy[length];
            System.arraycopy(valuesCustom, 0, cacheEvictPolicyArr, 0, length);
            return cacheEvictPolicyArr;
        }
    }

    /* loaded from: classes.dex */
    public enum CacheStorage {
        SQLite_CACHE_PER_TABLE,
        SQLite_CACHE_All_IN_ONE_TABLE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static CacheStorage[] valuesCustom() {
            CacheStorage[] valuesCustom = values();
            int length = valuesCustom.length;
            CacheStorage[] cacheStorageArr = new CacheStorage[length];
            System.arraycopy(valuesCustom, 0, cacheStorageArr, 0, length);
            return cacheStorageArr;
        }
    }

    public boolean a() {
        return this.f;
    }

    private BdCacheService(String str) {
        this.e = str;
        if (com.baidu.adp.a.b.a() != null) {
            this.f = com.baidu.adp.a.b.a().b();
        }
    }

    public Context b() {
        return this.c == null ? com.baidu.adp.a.b.a() : this.c;
    }

    public static BdCacheService c() {
        if (f366a == null) {
            f366a = new BdCacheService("baidu_adp.db");
        }
        return f366a;
    }

    public synchronized String a(a aVar, String str, String str2, int i) {
        l a2;
        int a3 = aVar.a();
        u d = d();
        a2 = d.a(str);
        if (a2 == null) {
            a2 = new l();
            a2.f375a = str;
            a2.e = a3;
            a2.d = str2;
            a2.c = i;
            a2.f = System.currentTimeMillis();
            a2.b = aVar.a(str);
            d.a(a2);
        } else if (!str2.equalsIgnoreCase(a2.d)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + a2.d);
        } else {
            a2.c = i;
            a2.f = System.currentTimeMillis();
            if (a3 != a2.e) {
                aVar.a(str, a2.b, a3, a2.e);
            }
            d.a(a2);
        }
        return a2.b;
    }

    public synchronized q a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        q qVar;
        d a2;
        w vVar;
        boolean z;
        qVar = (q) this.g.get(str);
        if (qVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                a2 = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                a2 = g.a(i, true);
            } else {
                a2 = g.a();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                vVar = new w(e());
                z = false;
            } else {
                vVar = new v(e(), "cache_kv_tshare");
                z = true;
            }
            vVar.a(a2, a(vVar, str, "text", i));
            qVar = a(str, new m(vVar, a2, z));
        }
        return qVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.s] */
    public synchronized q a(String str, p pVar) {
        t tVar;
        t tVar2;
        q qVar = (q) this.g.get(str);
        tVar2 = qVar;
        if (qVar != null) {
            if (pVar != null) {
                boolean z = qVar instanceof r;
                tVar2 = qVar;
                if (z) {
                    p a2 = ((r) qVar).a();
                    tVar2 = qVar;
                    if (a2 != pVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + pVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (a()) {
                tVar = new s(str, pVar);
            } else {
                tVar = new t(str, pVar);
            }
            this.g.put(str, tVar);
            tVar.b();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public u d() {
        if (this.b == null) {
            this.b = new u(b(), e());
        }
        return this.b;
    }

    public com.baidu.adp.a.f e() {
        if (this.d == null) {
            this.d = new com.baidu.adp.a.f(b(), this.e);
        }
        return this.d;
    }
}
