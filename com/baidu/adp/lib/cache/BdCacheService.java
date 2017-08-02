package com.baidu.adp.lib.cache;

import android.content.Context;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService extends CustomMessageListener {
    private static volatile BdCacheService tH;
    private Context context;
    private p tI;
    private final String tJ;
    private HashMap<String, l<String>> tK;
    private HashMap<String, l<byte[]>> tL;
    private boolean tM;
    private com.baidu.adp.base.a.b ti;

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

    public boolean isDebugMode() {
        return this.tM;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.tK = new HashMap<>();
        this.tL = new HashMap<>();
        this.tJ = str;
        if (BdBaseApplication.getInst() != null) {
            this.tM = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService eF() {
        if (tH == null) {
            synchronized (BdCacheService.class) {
                if (tH == null) {
                    tH = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return tH;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h Y;
        int et = cVar.et();
        p eG = eG();
        Y = eG.Y(str);
        if (Y == null) {
            Y = new h();
            Y.tx = str;
            Y.tC = et;
            Y.tB = str2;
            Y.maxSize = i;
            Y.tD = System.currentTimeMillis();
            Y.tj = cVar.J(str);
            eG.a(Y);
        } else if (!str2.equalsIgnoreCase(Y.tB)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + Y.tB);
        } else {
            Y.maxSize = i;
            Y.tD = System.currentTimeMillis();
            if (et != Y.tC) {
                cVar.b(str, Y.tj, et, Y.tC);
            }
            eG.a(Y);
        }
        return Y.tj;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e eD;
        r qVar;
        boolean z;
        lVar = this.tK.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                eD = f.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                eD = f.c(i, true);
            } else {
                eD = f.eD();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(ew());
                z = false;
            } else {
                qVar = new q(ew(), "cache_kv_tshare");
                z = true;
            }
            qVar.a(eD, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, eD, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<String> a(String str, k<String> kVar) {
        n nVar;
        n nVar2;
        l<String> lVar = this.tK.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.d;
                nVar2 = lVar;
                if (z) {
                    k<String> eI = ((l.d) lVar).eI();
                    nVar2 = lVar;
                    if (eI != kVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + kVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                nVar = new m(str, kVar);
            } else {
                nVar = new n(str, kVar);
            }
            this.tK.put(str, nVar);
            nVar.eK();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public synchronized l<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<byte[]> lVar;
        e eD;
        b aVar;
        boolean z;
        lVar = this.tL.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                eD = f.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                eD = f.c(i, true);
            } else {
                eD = f.eD();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ew());
                z = false;
            } else {
                aVar = new a(ew(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(eD, a(aVar, str, "blob", i));
            lVar = b(str, new j(aVar, eD, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        n nVar;
        n nVar2;
        l<byte[]> lVar = this.tL.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.d;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> eI = ((l.d) lVar).eI();
                    nVar2 = lVar;
                    if (eI != kVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + kVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                nVar = new m(str, kVar);
            } else {
                nVar = new n(str, kVar);
            }
            this.tL.put(str, nVar);
            nVar.eK();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.d) {
            l.d dVar = (l.d) lVar;
            synchronized (dVar) {
                String eH = dVar.eH();
                dVar.eJ();
                this.tK.remove(eH);
            }
        }
    }

    public p eG() {
        if (this.tI == null) {
            this.tI = new p(getContext(), ew());
        }
        return this.tI;
    }

    public com.baidu.adp.base.a.b ew() {
        if (this.ti == null) {
            this.ti = new com.baidu.adp.base.a.b(new i(getContext(), this.tJ));
        }
        return this.ti;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.tJ)) {
            this.tK.clear();
            this.tL.clear();
        }
    }
}
