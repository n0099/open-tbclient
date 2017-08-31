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
    private static volatile BdCacheService sZ;
    private Context context;
    private com.baidu.adp.base.a.b sC;
    private p tb;
    private final String tc;
    private HashMap<String, l<String>> td;
    private HashMap<String, l<byte[]>> te;
    private boolean tf;

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
        return this.tf;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.td = new HashMap<>();
        this.te = new HashMap<>();
        this.tc = str;
        if (BdBaseApplication.getInst() != null) {
            this.tf = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService eF() {
        if (sZ == null) {
            synchronized (BdCacheService.class) {
                if (sZ == null) {
                    sZ = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return sZ;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h Y;
        int et = cVar.et();
        p eG = eG();
        Y = eG.Y(str);
        if (Y == null) {
            Y = new h();
            Y.sP = str;
            Y.sU = et;
            Y.sT = str2;
            Y.maxSize = i;
            Y.sV = System.currentTimeMillis();
            Y.sD = cVar.J(str);
            eG.a(Y);
        } else if (!str2.equalsIgnoreCase(Y.sT)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + Y.sT);
        } else {
            Y.maxSize = i;
            Y.sV = System.currentTimeMillis();
            if (et != Y.sU) {
                cVar.b(str, Y.sD, et, Y.sU);
            }
            eG.a(Y);
        }
        return Y.sD;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e eD;
        r qVar;
        boolean z;
        lVar = this.td.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                eD = f.b(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                eD = f.b(i, true);
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
        l<String> lVar = this.td.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<String> eI = ((l.c) lVar).eI();
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
            this.td.put(str, nVar);
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
        lVar = this.te.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                eD = f.b(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                eD = f.b(i, true);
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
        l<byte[]> lVar = this.te.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> eI = ((l.c) lVar).eI();
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
            this.te.put(str, nVar);
            nVar.eK();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String eH = cVar.eH();
                cVar.eJ();
                this.td.remove(eH);
            }
        }
    }

    public p eG() {
        if (this.tb == null) {
            this.tb = new p(getContext(), ew());
        }
        return this.tb;
    }

    public com.baidu.adp.base.a.b ew() {
        if (this.sC == null) {
            this.sC = new com.baidu.adp.base.a.b(new i(getContext(), this.tc));
        }
        return this.sC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.tc)) {
            this.td.clear();
            this.te.clear();
        }
    }
}
