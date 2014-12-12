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
    private static BdCacheService hH;
    private Context context;
    private ad hI;
    private final String hJ;
    private HashMap<String, t<String>> hK;
    private HashMap<String, t<byte[]>> hL;
    private boolean hM;
    private com.baidu.adp.base.a.c hk;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (hN) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (hO) with 'values()' method */
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
        return this.hM;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.hK = new HashMap<>();
        this.hL = new HashMap<>();
        this.hJ = str;
        if (BdBaseApplication.getInst() != null) {
            this.hM = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static void cv() {
        hH = null;
    }

    public static BdCacheService cS() {
        if (hH == null) {
            hH = new BdCacheService("baidu_adp.db");
        }
        return hH;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        n W;
        int cF = cVar.cF();
        ad cT = cT();
        W = cT.W(str);
        if (W == null) {
            W = new n();
            W.hx = str;
            W.hC = cF;
            W.hB = str2;
            W.maxSize = i;
            W.hD = System.currentTimeMillis();
            W.hl = cVar.G(str);
            cT.a(W);
        } else if (!str2.equalsIgnoreCase(W.hB)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + W.hB);
        } else {
            W.maxSize = i;
            W.hD = System.currentTimeMillis();
            if (cF != W.hC) {
                cVar.a(str, W.hl, cF, W.hC);
            }
            cT.a(W);
        }
        return W.hl;
    }

    public synchronized t<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        t<String> tVar;
        f cQ;
        af aeVar;
        boolean z;
        tVar = this.hK.get(str);
        if (tVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                cQ = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                cQ = i.a(i, true);
            } else {
                cQ = i.cQ();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aeVar = new af(cI());
                z = false;
            } else {
                aeVar = new ae(cI(), "cache_kv_tshare");
                z = true;
            }
            aeVar.a(cQ, a(aeVar, str, "text", i));
            tVar = a(str, new p(aeVar, cQ, z));
        }
        return tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.x] */
    public synchronized t<String> a(String str, s<String> sVar) {
        ab abVar;
        ab abVar2;
        t<String> tVar = this.hK.get(str);
        abVar2 = tVar;
        if (tVar != null) {
            if (sVar != null) {
                boolean z = tVar instanceof w;
                abVar2 = tVar;
                if (z) {
                    s<String> cV = ((w) tVar).cV();
                    abVar2 = tVar;
                    if (cV != sVar) {
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
            this.hK.put(str, abVar);
            abVar.cX();
            abVar2 = abVar;
        }
        return abVar2;
    }

    public synchronized t<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        t<byte[]> tVar;
        f cQ;
        b aVar;
        boolean z;
        tVar = this.hL.get(str);
        if (tVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                cQ = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                cQ = i.a(i, true);
            } else {
                cQ = i.cQ();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(cI());
                z = false;
            } else {
                aVar = new a(cI(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(cQ, a(aVar, str, "blob", i));
            tVar = b(str, new p(aVar, cQ, z));
        }
        return tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.x] */
    public synchronized t<byte[]> b(String str, s<byte[]> sVar) {
        ab abVar;
        ab abVar2;
        t<byte[]> tVar = this.hL.get(str);
        abVar2 = tVar;
        if (tVar != null) {
            if (sVar != null) {
                boolean z = tVar instanceof w;
                abVar2 = tVar;
                if (z) {
                    s<byte[]> cV = ((w) tVar).cV();
                    abVar2 = tVar;
                    if (cV != sVar) {
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
            this.hL.put(str, abVar);
            abVar.cX();
            abVar2 = abVar;
        }
        return abVar2;
    }

    public void a(t<?> tVar) {
        if (tVar instanceof w) {
            w wVar = (w) tVar;
            synchronized (wVar) {
                String cU = wVar.cU();
                wVar.cW();
                this.hK.remove(cU);
            }
        }
    }

    public ad cT() {
        if (this.hI == null) {
            this.hI = new ad(getContext(), cI());
        }
        return this.hI;
    }

    public com.baidu.adp.base.a.c cI() {
        if (this.hk == null) {
            this.hk = new com.baidu.adp.base.a.c(new o(getContext(), this.hJ));
        }
        return this.hk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.hJ)) {
            this.hK.clear();
            this.hL.clear();
        }
    }
}
