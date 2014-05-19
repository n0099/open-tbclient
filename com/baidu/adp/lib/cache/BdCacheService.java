package com.baidu.adp.lib.cache;

import android.content.Context;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService extends CustomMessageListener {
    private static BdCacheService a;
    private aa b;
    private Context c;
    private com.baidu.adp.base.h d;
    private final String e;
    private HashMap<String, s<String>> f;
    private HashMap<String, s<byte[]>> g;
    private boolean h;

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
        return this.h;
    }

    private BdCacheService(String str) {
        super(2002998);
        this.f = new HashMap<>();
        this.g = new HashMap<>();
        this.e = str;
        if (com.baidu.adp.base.a.getInst() != null) {
            this.h = com.baidu.adp.base.a.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context b() {
        return this.c == null ? com.baidu.adp.base.a.getInst().getApp() : this.c;
    }

    public static BdCacheService c() {
        if (a == null) {
            a = new BdCacheService("baidu_adp.db");
        }
        return a;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        n a2;
        int a3 = cVar.a();
        aa d = d();
        a2 = d.a(str);
        if (a2 == null) {
            a2 = new n();
            a2.a = str;
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
        ac abVar;
        boolean z;
        sVar = this.f.get(str);
        if (sVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                a2 = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                a2 = i.a(i, true);
            } else {
                a2 = i.a();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                abVar = new ac(e());
                z = false;
            } else {
                abVar = new ab(e(), "cache_kv_tshare");
                z = true;
            }
            abVar.a(a2, a(abVar, str, "text", i));
            sVar = a(str, new o(abVar, a2, z));
        }
        return sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.v] */
    public synchronized s<String> a(String str, r<String> rVar) {
        y yVar;
        y yVar2;
        s<String> sVar = this.f.get(str);
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
            if (a()) {
                yVar = new v(str, rVar);
            } else {
                yVar = new y(str, rVar);
            }
            this.f.put(str, yVar);
            yVar.d();
            yVar2 = yVar;
        }
        return yVar2;
    }

    public synchronized s<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        s<byte[]> sVar;
        f a2;
        b aVar;
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
        y yVar;
        y yVar2;
        s<byte[]> sVar = this.g.get(str);
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
            if (a()) {
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

    public void a(s<?> sVar) {
        if (sVar instanceof u) {
            u uVar = (u) sVar;
            synchronized (uVar) {
                String a2 = uVar.a();
                uVar.c();
                this.f.remove(a2);
            }
        }
    }

    public aa d() {
        if (this.b == null) {
            this.b = new aa(b(), e());
        }
        return this.b;
    }

    public com.baidu.adp.base.h e() {
        if (this.d == null) {
            this.d = new com.baidu.adp.base.h(b(), this.e);
        }
        return this.d;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.e)) {
            this.f.clear();
            this.g.clear();
        }
    }
}
