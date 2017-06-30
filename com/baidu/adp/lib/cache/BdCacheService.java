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
    private static volatile BdCacheService tG;
    private Context context;
    private w tH;
    private final String tI;
    private HashMap<String, o<String>> tJ;
    private HashMap<String, o<byte[]>> tK;
    private boolean tL;
    private com.baidu.adp.base.a.b th;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (tM) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (tN) with 'values()' method */
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
        return this.tL;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.tJ = new HashMap<>();
        this.tK = new HashMap<>();
        this.tI = str;
        if (BdBaseApplication.getInst() != null) {
            this.tL = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService eH() {
        if (tG == null) {
            synchronized (BdCacheService.class) {
                if (tG == null) {
                    tG = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return tG;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        i W;
        int ev = cVar.ev();
        w eI = eI();
        W = eI.W(str);
        if (W == null) {
            W = new i();
            W.tw = str;
            W.tB = ev;
            W.tA = str2;
            W.maxSize = i;
            W.tC = System.currentTimeMillis();
            W.ti = cVar.H(str);
            eI.a(W);
        } else if (!str2.equalsIgnoreCase(W.tA)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + W.tA);
        } else {
            W.maxSize = i;
            W.tC = System.currentTimeMillis();
            if (ev != W.tB) {
                cVar.b(str, W.ti, ev, W.tB);
            }
            eI.a(W);
        }
        return W.ti;
    }

    public synchronized o<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<String> oVar;
        f eF;
        y xVar;
        boolean z;
        oVar = this.tJ.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                eF = g.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                eF = g.c(i, true);
            } else {
                eF = g.eF();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                xVar = new y(ey());
                z = false;
            } else {
                xVar = new x(ey(), "cache_kv_tshare");
                z = true;
            }
            xVar.a(eF, a(xVar, str, "text", i));
            oVar = a(str, new k(xVar, eF, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<String> a(String str, n<String> nVar) {
        u uVar;
        u uVar2;
        o<String> oVar = this.tJ.get(str);
        uVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.d;
                uVar2 = oVar;
                if (z) {
                    n<String> eK = ((o.d) oVar).eK();
                    uVar2 = oVar;
                    if (eK != nVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + nVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                uVar = new p(str, nVar);
            } else {
                uVar = new u(str, nVar);
            }
            this.tJ.put(str, uVar);
            uVar.eM();
            uVar2 = uVar;
        }
        return uVar2;
    }

    public synchronized o<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<byte[]> oVar;
        f eF;
        b aVar;
        boolean z;
        oVar = this.tK.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                eF = g.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                eF = g.c(i, true);
            } else {
                eF = g.eF();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ey());
                z = false;
            } else {
                aVar = new a(ey(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(eF, a(aVar, str, "blob", i));
            oVar = b(str, new k(aVar, eF, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<byte[]> b(String str, n<byte[]> nVar) {
        u uVar;
        u uVar2;
        o<byte[]> oVar = this.tK.get(str);
        uVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.d;
                uVar2 = oVar;
                if (z) {
                    n<byte[]> eK = ((o.d) oVar).eK();
                    uVar2 = oVar;
                    if (eK != nVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + nVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                uVar = new p(str, nVar);
            } else {
                uVar = new u(str, nVar);
            }
            this.tK.put(str, uVar);
            uVar.eM();
            uVar2 = uVar;
        }
        return uVar2;
    }

    public void a(o<?> oVar) {
        if (oVar instanceof o.d) {
            o.d dVar = (o.d) oVar;
            synchronized (dVar) {
                String eJ = dVar.eJ();
                dVar.eL();
                this.tJ.remove(eJ);
            }
        }
    }

    public w eI() {
        if (this.tH == null) {
            this.tH = new w(getContext(), ey());
        }
        return this.tH;
    }

    public com.baidu.adp.base.a.b ey() {
        if (this.th == null) {
            this.th = new com.baidu.adp.base.a.b(new j(getContext(), this.tI));
        }
        return this.th;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.tI)) {
            this.tJ.clear();
            this.tK.clear();
        }
    }
}
