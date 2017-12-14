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
    private static volatile BdCacheService sX;
    private Context context;
    private com.baidu.adp.base.a.b sA;
    private p sY;
    private final String sZ;
    private HashMap<String, l<String>> tb;
    private HashMap<String, l<byte[]>> tc;
    private boolean td;

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
        return this.td;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.tb = new HashMap<>();
        this.tc = new HashMap<>();
        this.sZ = str;
        if (BdBaseApplication.getInst() != null) {
            this.td = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService eE() {
        if (sX == null) {
            synchronized (BdCacheService.class) {
                if (sX == null) {
                    sX = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return sX;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h Y;
        int es = cVar.es();
        p eF = eF();
        Y = eF.Y(str);
        if (Y == null) {
            Y = new h();
            Y.sN = str;
            Y.sS = es;
            Y.sR = str2;
            Y.maxSize = i;
            Y.sT = System.currentTimeMillis();
            Y.sB = cVar.J(str);
            eF.a(Y);
        } else if (!str2.equalsIgnoreCase(Y.sR)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + Y.sR);
        } else {
            Y.maxSize = i;
            Y.sT = System.currentTimeMillis();
            if (es != Y.sS) {
                cVar.b(str, Y.sB, es, Y.sS);
            }
            eF.a(Y);
        }
        return Y.sB;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e eC;
        r qVar;
        boolean z;
        lVar = this.tb.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                eC = f.b(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                eC = f.b(i, true);
            } else {
                eC = f.eC();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(ev());
                z = false;
            } else {
                qVar = new q(ev(), "cache_kv_tshare");
                z = true;
            }
            qVar.a(eC, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, eC, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<String> a(String str, k<String> kVar) {
        n nVar;
        n nVar2;
        l<String> lVar = this.tb.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<String> eH = ((l.c) lVar).eH();
                    nVar2 = lVar;
                    if (eH != kVar) {
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
            this.tb.put(str, nVar);
            nVar.eJ();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public synchronized l<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<byte[]> lVar;
        e eC;
        b aVar;
        boolean z;
        lVar = this.tc.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                eC = f.b(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                eC = f.b(i, true);
            } else {
                eC = f.eC();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ev());
                z = false;
            } else {
                aVar = new a(ev(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(eC, a(aVar, str, "blob", i));
            lVar = b(str, new j(aVar, eC, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        n nVar;
        n nVar2;
        l<byte[]> lVar = this.tc.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> eH = ((l.c) lVar).eH();
                    nVar2 = lVar;
                    if (eH != kVar) {
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
            this.tc.put(str, nVar);
            nVar.eJ();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String eG = cVar.eG();
                cVar.eI();
                this.tb.remove(eG);
            }
        }
    }

    public p eF() {
        if (this.sY == null) {
            this.sY = new p(getContext(), ev());
        }
        return this.sY;
    }

    public com.baidu.adp.base.a.b ev() {
        if (this.sA == null) {
            this.sA = new com.baidu.adp.base.a.b(new i(getContext(), this.sZ));
        }
        return this.sA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.sZ)) {
            this.tb.clear();
            this.tc.clear();
        }
    }
}
