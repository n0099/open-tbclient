package com.baidu.adp.lib.cache;

import android.content.Context;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService extends CustomMessageListener {
    private static BdCacheService tr;
    private Context context;
    private com.baidu.adp.base.a.c sS;
    private ad ts;
    private final String tt;
    private HashMap<String, t<String>> tu;
    private HashMap<String, t<byte[]>> tv;
    private boolean tw;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (tx) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (ty) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static CacheStorage[] valuesCustom() {
            CacheStorage[] valuesCustom = values();
            int length = valuesCustom.length;
            CacheStorage[] cacheStorageArr = new CacheStorage[length];
            System.arraycopy(valuesCustom, 0, cacheStorageArr, 0, length);
            return cacheStorageArr;
        }
    }

    public boolean isDebugMode() {
        return this.tw;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.tu = new HashMap<>();
        this.tv = new HashMap<>();
        this.tt = str;
        if (BdBaseApplication.getInst() != null) {
            this.tw = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService gt() {
        if (tr == null) {
            tr = new BdCacheService("baidu_adp.db");
        }
        return tr;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        n af;
        int gg = cVar.gg();
        ad gu = gu();
        af = gu.af(str);
        if (af == null) {
            af = new n();
            af.tg = str;
            af.tl = gg;
            af.tk = str2;
            af.maxSize = i;
            af.tm = System.currentTimeMillis();
            af.sT = cVar.Q(str);
            gu.a(af);
        } else if (!str2.equalsIgnoreCase(af.tk)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + af.tk);
        } else {
            af.maxSize = i;
            af.tm = System.currentTimeMillis();
            if (gg != af.tl) {
                cVar.a(str, af.sT, gg, af.tl);
            }
            gu.a(af);
        }
        return af.sT;
    }

    public synchronized t<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        t<String> tVar;
        f gr;
        af aeVar;
        boolean z;
        tVar = this.tu.get(str);
        if (tVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                gr = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                gr = i.a(i, true);
            } else {
                gr = i.gr();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aeVar = new af(gj());
                z = false;
            } else {
                aeVar = new ae(gj(), "cache_kv_tshare");
                z = true;
            }
            aeVar.a(gr, a(aeVar, str, "text", i));
            tVar = a(str, new p(aeVar, gr, z));
        }
        return tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.x] */
    public synchronized t<String> a(String str, s<String> sVar) {
        ab abVar;
        ab abVar2;
        t<String> tVar = this.tu.get(str);
        abVar2 = tVar;
        if (tVar != null) {
            if (sVar != null) {
                boolean z = tVar instanceof w;
                abVar2 = tVar;
                if (z) {
                    s<String> gw = ((w) tVar).gw();
                    abVar2 = tVar;
                    if (gw != sVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + sVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                abVar = new x(str, sVar);
            } else {
                abVar = new ab(str, sVar);
            }
            this.tu.put(str, abVar);
            abVar.gy();
            abVar2 = abVar;
        }
        return abVar2;
    }

    public synchronized t<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        t<byte[]> tVar;
        f gr;
        b aVar;
        boolean z;
        tVar = this.tv.get(str);
        if (tVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                gr = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                gr = i.a(i, true);
            } else {
                gr = i.gr();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(gj());
                z = false;
            } else {
                aVar = new a(gj(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(gr, a(aVar, str, "blob", i));
            tVar = b(str, new p(aVar, gr, z));
        }
        return tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.x] */
    public synchronized t<byte[]> b(String str, s<byte[]> sVar) {
        ab abVar;
        ab abVar2;
        t<byte[]> tVar = this.tv.get(str);
        abVar2 = tVar;
        if (tVar != null) {
            if (sVar != null) {
                boolean z = tVar instanceof w;
                abVar2 = tVar;
                if (z) {
                    s<byte[]> gw = ((w) tVar).gw();
                    abVar2 = tVar;
                    if (gw != sVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + sVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                abVar = new x(str, sVar);
            } else {
                abVar = new ab(str, sVar);
            }
            this.tv.put(str, abVar);
            abVar.gy();
            abVar2 = abVar;
        }
        return abVar2;
    }

    public void a(t<?> tVar) {
        if (tVar instanceof w) {
            w wVar = (w) tVar;
            synchronized (wVar) {
                String gv = wVar.gv();
                wVar.gx();
                this.tu.remove(gv);
            }
        }
    }

    public ad gu() {
        if (this.ts == null) {
            this.ts = new ad(getContext(), gj());
        }
        return this.ts;
    }

    public com.baidu.adp.base.a.c gj() {
        if (this.sS == null) {
            this.sS = new com.baidu.adp.base.a.c(new o(getContext(), this.tt));
        }
        return this.sS;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.tt)) {
            this.tu.clear();
            this.tv.clear();
        }
    }
}
