package com.baidu.adp.lib.cache;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService {

    /* renamed from: a  reason: collision with root package name */
    private static BdCacheService f425a;
    private z b;
    private Context c;
    private com.baidu.adp.a.h d;
    private final String e;
    private boolean f;
    private HashMap<String, s<String>> g = new HashMap<>();
    private HashMap<String, s<byte[]>> h = new HashMap<>();

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT
    }

    /* loaded from: classes.dex */
    public enum CacheStorage {
        SQLite_CACHE_PER_TABLE,
        SQLite_CACHE_All_IN_ONE_TABLE
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
        if (f425a == null) {
            f425a = new BdCacheService("baidu_adp.db");
        }
        return f425a;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        n a2;
        int a3 = cVar.a();
        z d = d();
        a2 = d.a(str);
        if (a2 == null) {
            a2 = new n();
            a2.f434a = str;
            a2.e = a3;
            a2.d = str2;
            a2.c = i;
            a2.f = System.currentTimeMillis();
            a2.b = cVar.a(str);
            d.a(a2);
        } else if (!str2.equalsIgnoreCase(a2.d)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + a2.d);
        } else {
            a2.c = i;
            a2.f = System.currentTimeMillis();
            if (a3 != a2.e) {
                cVar.a(str, a2.b, a3, a2.e);
            }
            d.a(a2);
        }
        return a2.b;
    }

    public synchronized s<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        s<String> sVar;
        f a2;
        ab aaVar;
        boolean z;
        sVar = this.g.get(str);
        if (sVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                a2 = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                a2 = i.a(i, true);
            } else {
                a2 = i.a();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aaVar = new ab(e());
                z = false;
            } else {
                aaVar = new aa(e(), "cache_kv_tshare");
                z = true;
            }
            aaVar.a(a2, a(aaVar, str, "text", i));
            sVar = a(str, new o(aaVar, a2, z));
        }
        return sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.v] */
    public synchronized s<String> a(String str, r<String> rVar) {
        x xVar;
        x xVar2;
        s<String> sVar = this.g.get(str);
        xVar2 = sVar;
        if (sVar != null) {
            if (rVar != null) {
                boolean z = sVar instanceof u;
                xVar2 = sVar;
                if (z) {
                    r<String> b = ((u) sVar).b();
                    xVar2 = sVar;
                    if (b != rVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + rVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (a()) {
                xVar = new v(str, rVar);
            } else {
                xVar = new x(str, rVar);
            }
            this.g.put(str, xVar);
            xVar.d();
            xVar2 = xVar;
        }
        return xVar2;
    }

    public synchronized s<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        s<byte[]> sVar;
        f a2;
        b aVar;
        boolean z;
        sVar = this.h.get(str);
        if (sVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                a2 = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                a2 = i.a(i, true);
            } else {
                a2 = i.a();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(e());
                z = false;
            } else {
                aVar = new a(e(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(a2, a(aVar, str, "blob", i));
            sVar = b(str, new o(aVar, a2, z));
        }
        return sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.v] */
    public synchronized s<byte[]> b(String str, r<byte[]> rVar) {
        x xVar;
        x xVar2;
        s<byte[]> sVar = this.h.get(str);
        xVar2 = sVar;
        if (sVar != null) {
            if (rVar != null) {
                boolean z = sVar instanceof u;
                xVar2 = sVar;
                if (z) {
                    r<byte[]> b = ((u) sVar).b();
                    xVar2 = sVar;
                    if (b != rVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + rVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (a()) {
                xVar = new v(str, rVar);
            } else {
                xVar = new x(str, rVar);
            }
            this.h.put(str, xVar);
            xVar.d();
            xVar2 = xVar;
        }
        return xVar2;
    }

    public void a(s<?> sVar) {
        if (sVar instanceof u) {
            u uVar = (u) sVar;
            synchronized (uVar) {
                String a2 = uVar.a();
                uVar.c();
                this.g.remove(a2);
            }
        }
    }

    public z d() {
        if (this.b == null) {
            this.b = new z(b(), e());
        }
        return this.b;
    }

    public com.baidu.adp.a.h e() {
        if (this.d == null) {
            this.d = new com.baidu.adp.a.h(b(), this.e);
        }
        return this.d;
    }
}
