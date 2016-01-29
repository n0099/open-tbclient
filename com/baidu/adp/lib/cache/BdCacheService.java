package com.baidu.adp.lib.cache;

import android.content.Context;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.o;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService extends CustomMessageListener {
    private static volatile BdCacheService tz;
    private Context context;
    private com.baidu.adp.base.a.b sZ;
    private v tA;
    private final String tB;
    private HashMap<String, o<String>> tC;
    private HashMap<String, o<byte[]>> tD;
    private boolean tE;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (tF) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (tG) with 'values()' method */
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
        return this.tE;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.tC = new HashMap<>();
        this.tD = new HashMap<>();
        this.tB = str;
        if (BdBaseApplication.getInst() != null) {
            this.tE = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService gs() {
        if (tz == null) {
            synchronized (BdCacheService.class) {
                if (tz == null) {
                    tz = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return tz;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        i ab;
        int gg = cVar.gg();
        v gt = gt();
        ab = gt.ab(str);
        if (ab == null) {
            ab = new i();
            ab.tp = str;
            ab.tu = gg;
            ab.tt = str2;
            ab.maxSize = i;
            ab.tv = System.currentTimeMillis();
            ab.tb = cVar.M(str);
            gt.a(ab);
        } else if (!str2.equalsIgnoreCase(ab.tt)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + ab.tt);
        } else {
            ab.maxSize = i;
            ab.tv = System.currentTimeMillis();
            if (gg != ab.tu) {
                cVar.a(str, ab.tb, gg, ab.tu);
            }
            gt.a(ab);
        }
        return ab.tb;
    }

    public synchronized o<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<String> oVar;
        f gq;
        x wVar;
        boolean z;
        oVar = this.tC.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                gq = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                gq = g.a(i, true);
            } else {
                gq = g.gq();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                wVar = new x(gj());
                z = false;
            } else {
                wVar = new w(gj(), "cache_kv_tshare");
                z = true;
            }
            wVar.a(gq, a(wVar, str, "text", i));
            oVar = a(str, new k(wVar, gq, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<String> a(String str, n<String> nVar) {
        t tVar;
        t tVar2;
        o<String> oVar = this.tC.get(str);
        tVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.c;
                tVar2 = oVar;
                if (z) {
                    n<String> gv = ((o.c) oVar).gv();
                    tVar2 = oVar;
                    if (gv != nVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + nVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                tVar = new p(str, nVar);
            } else {
                tVar = new t(str, nVar);
            }
            this.tC.put(str, tVar);
            tVar.gx();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public synchronized o<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<byte[]> oVar;
        f gq;
        b aVar;
        boolean z;
        oVar = this.tD.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                gq = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                gq = g.a(i, true);
            } else {
                gq = g.gq();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(gj());
                z = false;
            } else {
                aVar = new a(gj(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(gq, a(aVar, str, "blob", i));
            oVar = b(str, new k(aVar, gq, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<byte[]> b(String str, n<byte[]> nVar) {
        t tVar;
        t tVar2;
        o<byte[]> oVar = this.tD.get(str);
        tVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.c;
                tVar2 = oVar;
                if (z) {
                    n<byte[]> gv = ((o.c) oVar).gv();
                    tVar2 = oVar;
                    if (gv != nVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + nVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                tVar = new p(str, nVar);
            } else {
                tVar = new t(str, nVar);
            }
            this.tD.put(str, tVar);
            tVar.gx();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public void a(o<?> oVar) {
        if (oVar instanceof o.c) {
            o.c cVar = (o.c) oVar;
            synchronized (cVar) {
                String gu = cVar.gu();
                cVar.gw();
                this.tC.remove(gu);
            }
        }
    }

    public v gt() {
        if (this.tA == null) {
            this.tA = new v(getContext(), gj());
        }
        return this.tA;
    }

    public com.baidu.adp.base.a.b gj() {
        if (this.sZ == null) {
            this.sZ = new com.baidu.adp.base.a.b(new j(getContext(), this.tB));
        }
        return this.sZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.tB)) {
            this.tC.clear();
            this.tD.clear();
        }
    }
}
