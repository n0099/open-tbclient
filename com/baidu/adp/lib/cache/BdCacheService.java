package com.baidu.adp.lib.cache;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class BdCacheService {
    private static BdCacheService a;
    private aa b;
    private Context c;
    private com.baidu.adp.a.i d;
    private final String e;
    private boolean f;
    private HashMap<String, s<String>> g = new HashMap<>();
    private HashMap<String, s<byte[]>> h = new HashMap<>();

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

    private BdCacheService(String str) {
        this.e = str;
        if (com.baidu.adp.a.b.a() != null) {
            this.f = com.baidu.adp.a.b.a().d();
        }
    }

    private Context c() {
        return this.c == null ? com.baidu.adp.a.b.a().b() : this.c;
    }

    public static BdCacheService a() {
        if (a == null) {
            a = new BdCacheService("baidu_adp.db");
        }
        return a;
    }

    private synchronized String a(c<?> cVar, String str, String str2, int i) {
        n a2;
        aa b = b();
        a2 = b.a(str);
        if (a2 == null) {
            a2 = new n();
            a2.a = str;
            a2.e = 1;
            a2.d = str2;
            a2.c = i;
            a2.f = System.currentTimeMillis();
            a2.b = cVar.a(str);
        } else if (!str2.equalsIgnoreCase(a2.d)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + a2.d);
        } else {
            a2.c = i;
            a2.f = System.currentTimeMillis();
            if (1 != a2.e) {
                String str3 = a2.b;
                int i2 = a2.e;
            }
        }
        b.a(a2);
        return a2.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.baidu.adp.lib.cache.f] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.baidu.adp.lib.cache.f] */
    public final synchronized s<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        s<String> sVar;
        l lVar;
        ac abVar;
        boolean z;
        sVar = this.g.get(str);
        if (sVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                lVar = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                lVar = i.a(i, true);
            } else {
                lVar = new l();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                abVar = new ac(d());
                z = false;
            } else {
                abVar = new ab(d(), "cache_kv_tshare");
                z = true;
            }
            abVar.a(lVar, a(abVar, str, "text", i));
            sVar = a(str, new o(abVar, lVar, z));
        }
        return sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.v] */
    private synchronized s<String> a(String str, r<String> rVar) {
        y yVar;
        y yVar2;
        s<String> sVar = this.g.get(str);
        yVar2 = sVar;
        if (sVar != null) {
            if (rVar != null) {
                boolean z = sVar instanceof u;
                yVar2 = sVar;
                if (z) {
                    r<String> b = ((u) sVar).b();
                    yVar2 = sVar;
                    if (b != rVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + rVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (this.f) {
                yVar = new v(str, rVar);
            } else {
                yVar = new y(str, rVar);
            }
            this.g.put(str, yVar);
            yVar.d();
            yVar2 = yVar;
        }
        return yVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.baidu.adp.lib.cache.f] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.baidu.adp.lib.cache.f] */
    public final synchronized s<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        s<byte[]> sVar;
        l lVar;
        b aVar;
        boolean z;
        sVar = this.h.get(str);
        if (sVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                lVar = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                lVar = i.a(i, true);
            } else {
                lVar = new l();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(d());
                z = false;
            } else {
                aVar = new a(d(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(lVar, a(aVar, str, "blob", i));
            sVar = b(str, new o(aVar, lVar, z));
        }
        return sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.v] */
    private synchronized s<byte[]> b(String str, r<byte[]> rVar) {
        y yVar;
        y yVar2;
        s<byte[]> sVar = this.h.get(str);
        yVar2 = sVar;
        if (sVar != null) {
            if (rVar != null) {
                boolean z = sVar instanceof u;
                yVar2 = sVar;
                if (z) {
                    r<byte[]> b = ((u) sVar).b();
                    yVar2 = sVar;
                    if (b != rVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + rVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (this.f) {
                yVar = new v(str, rVar);
            } else {
                yVar = new y(str, rVar);
            }
            this.h.put(str, yVar);
            yVar.d();
            yVar2 = yVar;
        }
        return yVar2;
    }

    public final void a(s<?> sVar) {
        if (sVar instanceof u) {
            u uVar = (u) sVar;
            synchronized (uVar) {
                String a2 = uVar.a();
                uVar.c();
                this.g.remove(a2);
            }
        }
    }

    public final aa b() {
        if (this.b == null) {
            c();
            this.b = new aa(d());
        }
        return this.b;
    }

    private com.baidu.adp.a.i d() {
        if (this.d == null) {
            this.d = new com.baidu.adp.a.i(c(), this.e);
        }
        return this.d;
    }
}
