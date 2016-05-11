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
    private static volatile BdCacheService jw;
    private Context context;
    private com.baidu.adp.base.a.b iZ;
    private HashMap<String, o<byte[]>> jA;
    private boolean jB;
    private v jx;
    private final String jy;
    private HashMap<String, o<String>> jz;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (jC) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (jD) with 'values()' method */
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
        return this.jB;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.jz = new HashMap<>();
        this.jA = new HashMap<>();
        this.jy = str;
        if (BdBaseApplication.getInst() != null) {
            this.jB = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService cG() {
        if (jw == null) {
            synchronized (BdCacheService.class) {
                if (jw == null) {
                    jw = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return jw;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        i S;
        int cu = cVar.cu();
        v cH = cH();
        S = cH.S(str);
        if (S == null) {
            S = new i();
            S.jm = str;
            S.jr = cu;
            S.jq = str2;
            S.maxSize = i;
            S.js = System.currentTimeMillis();
            S.ja = cVar.D(str);
            cH.a(S);
        } else if (!str2.equalsIgnoreCase(S.jq)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + S.jq);
        } else {
            S.maxSize = i;
            S.js = System.currentTimeMillis();
            if (cu != S.jr) {
                cVar.a(str, S.ja, cu, S.jr);
            }
            cH.a(S);
        }
        return S.ja;
    }

    public synchronized o<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<String> oVar;
        f cE;
        x wVar;
        boolean z;
        oVar = this.jz.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                cE = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                cE = g.a(i, true);
            } else {
                cE = g.cE();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                wVar = new x(cx());
                z = false;
            } else {
                wVar = new w(cx(), "cache_kv_tshare");
                z = true;
            }
            wVar.a(cE, a(wVar, str, "text", i));
            oVar = a(str, new k(wVar, cE, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<String> a(String str, n<String> nVar) {
        t tVar;
        t tVar2;
        o<String> oVar = this.jz.get(str);
        tVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.c;
                tVar2 = oVar;
                if (z) {
                    n<String> cJ = ((o.c) oVar).cJ();
                    tVar2 = oVar;
                    if (cJ != nVar) {
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
            this.jz.put(str, tVar);
            tVar.cL();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public synchronized o<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<byte[]> oVar;
        f cE;
        b aVar;
        boolean z;
        oVar = this.jA.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                cE = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                cE = g.a(i, true);
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
        t tVar;
        t tVar2;
        o<byte[]> oVar = this.jA.get(str);
        tVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.c;
                tVar2 = oVar;
                if (z) {
                    n<byte[]> cJ = ((o.c) oVar).cJ();
                    tVar2 = oVar;
                    if (cJ != nVar) {
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
            this.jA.put(str, tVar);
            tVar.cL();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public void a(o<?> oVar) {
        if (oVar instanceof o.c) {
            o.c cVar = (o.c) oVar;
            synchronized (cVar) {
                String cI = cVar.cI();
                cVar.cK();
                this.jz.remove(cI);
            }
        }
    }

    public v cH() {
        if (this.jx == null) {
            this.jx = new v(getContext(), cx());
        }
        return this.jx;
    }

    public com.baidu.adp.base.a.b cx() {
        if (this.iZ == null) {
            this.iZ = new com.baidu.adp.base.a.b(new j(getContext(), this.jy));
        }
        return this.iZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.jy)) {
            this.jz.clear();
            this.jA.clear();
        }
    }
}
