package com.baidu.adp.lib.cache;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService {

    /* renamed from: a  reason: collision with root package name */
    private static BdCacheService f376a;
    private x b;
    private Context c;
    private com.baidu.adp.a.f d;
    private final String e;
    private boolean f;
    private HashMap<String, q<String>> g = new HashMap<>();
    private HashMap<String, q<byte[]>> h = new HashMap<>();

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
        if (f376a == null) {
            f376a = new BdCacheService("baidu_adp.db");
        }
        return f376a;
    }

    public synchronized String a(a<?> aVar, String str, String str2, int i) {
        l a2;
        int a3 = aVar.a();
        x d = d();
        a2 = d.a(str);
        if (a2 == null) {
            a2 = new l();
            a2.f385a = str;
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

    public synchronized q<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        q<String> qVar;
        d a2;
        z yVar;
        boolean z;
        qVar = this.g.get(str);
        if (qVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                a2 = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                a2 = g.a(i, true);
            } else {
                a2 = g.a();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                yVar = new z(e());
                z = false;
            } else {
                yVar = new y(e(), "cache_kv_tshare");
                z = true;
            }
            yVar.a(a2, a(yVar, str, "text", i));
            qVar = a(str, new m(yVar, a2, z));
        }
        return qVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.t] */
    public synchronized q<String> a(String str, p<String> pVar) {
        v vVar;
        v vVar2;
        q<String> qVar = this.g.get(str);
        vVar2 = qVar;
        if (qVar != null) {
            if (pVar != null) {
                boolean z = qVar instanceof s;
                vVar2 = qVar;
                if (z) {
                    p<String> a2 = ((s) qVar).a();
                    vVar2 = qVar;
                    if (a2 != pVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + pVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (a()) {
                vVar = new t(str, pVar);
            } else {
                vVar = new v(str, pVar);
            }
            this.g.put(str, vVar);
            vVar.b();
            vVar2 = vVar;
        }
        return vVar2;
    }

    public x d() {
        if (this.b == null) {
            this.b = new x(b(), e());
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
