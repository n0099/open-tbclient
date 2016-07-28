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
    private static volatile BdCacheService jW;
    private Context context;
    private w jX;
    private final String jY;
    private HashMap<String, o<String>> jZ;
    private com.baidu.adp.base.a.b jz;
    private HashMap<String, o<byte[]>> kb;
    private boolean kc;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (kd) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (ke) with 'values()' method */
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
        return this.kc;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.jZ = new HashMap<>();
        this.kb = new HashMap<>();
        this.jY = str;
        if (BdBaseApplication.getInst() != null) {
            this.kc = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService cG() {
        if (jW == null) {
            synchronized (BdCacheService.class) {
                if (jW == null) {
                    jW = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return jW;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        i U;
        int cu = cVar.cu();
        w cH = cH();
        U = cH.U(str);
        if (U == null) {
            U = new i();
            U.jM = str;
            U.jR = cu;
            U.jQ = str2;
            U.maxSize = i;
            U.jS = System.currentTimeMillis();
            U.jA = cVar.F(str);
            cH.a(U);
        } else if (!str2.equalsIgnoreCase(U.jQ)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + U.jQ);
        } else {
            U.maxSize = i;
            U.jS = System.currentTimeMillis();
            if (cu != U.jR) {
                cVar.b(str, U.jA, cu, U.jR);
            }
            cH.a(U);
        }
        return U.jA;
    }

    public synchronized o<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<String> oVar;
        f cE;
        y xVar;
        boolean z;
        oVar = this.jZ.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                cE = g.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                cE = g.c(i, true);
            } else {
                cE = g.cE();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                xVar = new y(cx());
                z = false;
            } else {
                xVar = new x(cx(), "cache_kv_tshare");
                z = true;
            }
            xVar.a(cE, a(xVar, str, "text", i));
            oVar = a(str, new k(xVar, cE, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<String> a(String str, n<String> nVar) {
        u uVar;
        u uVar2;
        o<String> oVar = this.jZ.get(str);
        uVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.d;
                uVar2 = oVar;
                if (z) {
                    n<String> cJ = ((o.d) oVar).cJ();
                    uVar2 = oVar;
                    if (cJ != nVar) {
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
            this.jZ.put(str, uVar);
            uVar.cL();
            uVar2 = uVar;
        }
        return uVar2;
    }

    public synchronized o<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<byte[]> oVar;
        f cE;
        b aVar;
        boolean z;
        oVar = this.kb.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                cE = g.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                cE = g.c(i, true);
            } else {
                cE = g.cE();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(cx());
                z = false;
            } else {
                aVar = new a(cx(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(cE, a(aVar, str, "blob", i));
            oVar = b(str, new k(aVar, cE, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<byte[]> b(String str, n<byte[]> nVar) {
        u uVar;
        u uVar2;
        o<byte[]> oVar = this.kb.get(str);
        uVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.d;
                uVar2 = oVar;
                if (z) {
                    n<byte[]> cJ = ((o.d) oVar).cJ();
                    uVar2 = oVar;
                    if (cJ != nVar) {
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
            this.kb.put(str, uVar);
            uVar.cL();
            uVar2 = uVar;
        }
        return uVar2;
    }

    public void a(o<?> oVar) {
        if (oVar instanceof o.d) {
            o.d dVar = (o.d) oVar;
            synchronized (dVar) {
                String cI = dVar.cI();
                dVar.cK();
                this.jZ.remove(cI);
            }
        }
    }

    public w cH() {
        if (this.jX == null) {
            this.jX = new w(getContext(), cx());
        }
        return this.jX;
    }

    public com.baidu.adp.base.a.b cx() {
        if (this.jz == null) {
            this.jz = new com.baidu.adp.base.a.b(new j(getContext(), this.jY));
        }
        return this.jz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.jY)) {
            this.jZ.clear();
            this.kb.clear();
        }
    }
}
