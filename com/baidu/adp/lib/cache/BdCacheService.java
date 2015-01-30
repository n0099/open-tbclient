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
    private static BdCacheService hJ;
    private Context context;
    private ad hK;
    private final String hL;
    private HashMap<String, t<String>> hM;
    private HashMap<String, t<byte[]>> hN;
    private boolean hO;
    private com.baidu.adp.base.a.c hm;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (hP) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (hQ) with 'values()' method */
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
        return this.hO;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.hM = new HashMap<>();
        this.hN = new HashMap<>();
        this.hL = str;
        if (BdBaseApplication.getInst() != null) {
            this.hO = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static void ct() {
        hJ = null;
    }

    public static BdCacheService cQ() {
        if (hJ == null) {
            hJ = new BdCacheService("baidu_adp.db");
        }
        return hJ;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        n W;
        int cD = cVar.cD();
        ad cR = cR();
        W = cR.W(str);
        if (W == null) {
            W = new n();
            W.hz = str;
            W.hE = cD;
            W.hD = str2;
            W.maxSize = i;
            W.hF = System.currentTimeMillis();
            W.hn = cVar.G(str);
            cR.a(W);
        } else if (!str2.equalsIgnoreCase(W.hD)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + W.hD);
        } else {
            W.maxSize = i;
            W.hF = System.currentTimeMillis();
            if (cD != W.hE) {
                cVar.a(str, W.hn, cD, W.hE);
            }
            cR.a(W);
        }
        return W.hn;
    }

    public synchronized t<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        t<String> tVar;
        f cO;
        af aeVar;
        boolean z;
        tVar = this.hM.get(str);
        if (tVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                cO = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                cO = i.a(i, true);
            } else {
                cO = i.cO();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aeVar = new af(cG());
                z = false;
            } else {
                aeVar = new ae(cG(), "cache_kv_tshare");
                z = true;
            }
            aeVar.a(cO, a(aeVar, str, "text", i));
            tVar = a(str, new p(aeVar, cO, z));
        }
        return tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.x] */
    public synchronized t<String> a(String str, s<String> sVar) {
        ab abVar;
        ab abVar2;
        t<String> tVar = this.hM.get(str);
        abVar2 = tVar;
        if (tVar != null) {
            if (sVar != null) {
                boolean z = tVar instanceof w;
                abVar2 = tVar;
                if (z) {
                    s<String> cT = ((w) tVar).cT();
                    abVar2 = tVar;
                    if (cT != sVar) {
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
            this.hM.put(str, abVar);
            abVar.cV();
            abVar2 = abVar;
        }
        return abVar2;
    }

    public synchronized t<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        t<byte[]> tVar;
        f cO;
        b aVar;
        boolean z;
        tVar = this.hN.get(str);
        if (tVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                cO = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                cO = i.a(i, true);
            } else {
                cO = i.cO();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(cG());
                z = false;
            } else {
                aVar = new a(cG(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(cO, a(aVar, str, "blob", i));
            tVar = b(str, new p(aVar, cO, z));
        }
        return tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.x] */
    public synchronized t<byte[]> b(String str, s<byte[]> sVar) {
        ab abVar;
        ab abVar2;
        t<byte[]> tVar = this.hN.get(str);
        abVar2 = tVar;
        if (tVar != null) {
            if (sVar != null) {
                boolean z = tVar instanceof w;
                abVar2 = tVar;
                if (z) {
                    s<byte[]> cT = ((w) tVar).cT();
                    abVar2 = tVar;
                    if (cT != sVar) {
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
            this.hN.put(str, abVar);
            abVar.cV();
            abVar2 = abVar;
        }
        return abVar2;
    }

    public void a(t<?> tVar) {
        if (tVar instanceof w) {
            w wVar = (w) tVar;
            synchronized (wVar) {
                String cS = wVar.cS();
                wVar.cU();
                this.hM.remove(cS);
            }
        }
    }

    public ad cR() {
        if (this.hK == null) {
            this.hK = new ad(getContext(), cG());
        }
        return this.hK;
    }

    public com.baidu.adp.base.a.c cG() {
        if (this.hm == null) {
            this.hm = new com.baidu.adp.base.a.c(new o(getContext(), this.hL));
        }
        return this.hm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.hL)) {
            this.hM.clear();
            this.hN.clear();
        }
    }
}
