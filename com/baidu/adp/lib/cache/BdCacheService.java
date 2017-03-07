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
    private static volatile BdCacheService ud;
    private Context context;
    private com.baidu.adp.base.a.b tG;
    private w ue;
    private final String uf;
    private HashMap<String, o<String>> ug;
    private HashMap<String, o<byte[]>> uh;
    private boolean ui;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (uj) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (uk) with 'values()' method */
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
        return this.ui;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.ug = new HashMap<>();
        this.uh = new HashMap<>();
        this.uf = str;
        if (BdBaseApplication.getInst() != null) {
            this.ui = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService eI() {
        if (ud == null) {
            synchronized (BdCacheService.class) {
                if (ud == null) {
                    ud = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return ud;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        i U;
        int ew = cVar.ew();
        w eJ = eJ();
        U = eJ.U(str);
        if (U == null) {
            U = new i();
            U.tT = str;
            U.tY = ew;
            U.tX = str2;
            U.maxSize = i;
            U.tZ = System.currentTimeMillis();
            U.tH = cVar.F(str);
            eJ.a(U);
        } else if (!str2.equalsIgnoreCase(U.tX)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + U.tX);
        } else {
            U.maxSize = i;
            U.tZ = System.currentTimeMillis();
            if (ew != U.tY) {
                cVar.b(str, U.tH, ew, U.tY);
            }
            eJ.a(U);
        }
        return U.tH;
    }

    public synchronized o<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<String> oVar;
        f eG;
        y xVar;
        boolean z;
        oVar = this.ug.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                eG = g.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                eG = g.c(i, true);
            } else {
                eG = g.eG();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                xVar = new y(ez());
                z = false;
            } else {
                xVar = new x(ez(), "cache_kv_tshare");
                z = true;
            }
            xVar.a(eG, a(xVar, str, "text", i));
            oVar = a(str, new k(xVar, eG, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<String> a(String str, n<String> nVar) {
        u uVar;
        u uVar2;
        o<String> oVar = this.ug.get(str);
        uVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.d;
                uVar2 = oVar;
                if (z) {
                    n<String> eL = ((o.d) oVar).eL();
                    uVar2 = oVar;
                    if (eL != nVar) {
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
            this.ug.put(str, uVar);
            uVar.eN();
            uVar2 = uVar;
        }
        return uVar2;
    }

    public synchronized o<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<byte[]> oVar;
        f eG;
        b aVar;
        boolean z;
        oVar = this.uh.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                eG = g.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                eG = g.c(i, true);
            } else {
                eG = g.eG();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ez());
                z = false;
            } else {
                aVar = new a(ez(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(eG, a(aVar, str, "blob", i));
            oVar = b(str, new k(aVar, eG, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<byte[]> b(String str, n<byte[]> nVar) {
        u uVar;
        u uVar2;
        o<byte[]> oVar = this.uh.get(str);
        uVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.d;
                uVar2 = oVar;
                if (z) {
                    n<byte[]> eL = ((o.d) oVar).eL();
                    uVar2 = oVar;
                    if (eL != nVar) {
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
            this.uh.put(str, uVar);
            uVar.eN();
            uVar2 = uVar;
        }
        return uVar2;
    }

    public void a(o<?> oVar) {
        if (oVar instanceof o.d) {
            o.d dVar = (o.d) oVar;
            synchronized (dVar) {
                String eK = dVar.eK();
                dVar.eM();
                this.ug.remove(eK);
            }
        }
    }

    public w eJ() {
        if (this.ue == null) {
            this.ue = new w(getContext(), ez());
        }
        return this.ue;
    }

    public com.baidu.adp.base.a.b ez() {
        if (this.tG == null) {
            this.tG = new com.baidu.adp.base.a.b(new j(getContext(), this.uf));
        }
        return this.tG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.uf)) {
            this.ug.clear();
            this.uh.clear();
        }
    }
}
