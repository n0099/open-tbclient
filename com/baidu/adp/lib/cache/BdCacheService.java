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
    private static volatile BdCacheService ju;
    private Context context;
    private com.baidu.adp.base.a.b iX;
    private v jv;
    private final String jw;
    private HashMap<String, o<String>> jx;
    private HashMap<String, o<byte[]>> jy;
    private boolean jz;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (jA) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (jB) with 'values()' method */
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
        return this.jz;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.jx = new HashMap<>();
        this.jy = new HashMap<>();
        this.jw = str;
        if (BdBaseApplication.getInst() != null) {
            this.jz = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService cH() {
        if (ju == null) {
            synchronized (BdCacheService.class) {
                if (ju == null) {
                    ju = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return ju;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        i S;
        int cv = cVar.cv();
        v cI = cI();
        S = cI.S(str);
        if (S == null) {
            S = new i();
            S.jk = str;
            S.jp = cv;
            S.jo = str2;
            S.maxSize = i;
            S.jq = System.currentTimeMillis();
            S.iY = cVar.D(str);
            cI.a(S);
        } else if (!str2.equalsIgnoreCase(S.jo)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + S.jo);
        } else {
            S.maxSize = i;
            S.jq = System.currentTimeMillis();
            if (cv != S.jp) {
                cVar.b(str, S.iY, cv, S.jp);
            }
            cI.a(S);
        }
        return S.iY;
    }

    public synchronized o<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<String> oVar;
        f cF;
        x wVar;
        boolean z;
        oVar = this.jx.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                cF = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                cF = g.a(i, true);
            } else {
                cF = g.cF();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                wVar = new x(cy());
                z = false;
            } else {
                wVar = new w(cy(), "cache_kv_tshare");
                z = true;
            }
            wVar.a(cF, a(wVar, str, "text", i));
            oVar = a(str, new k(wVar, cF, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<String> a(String str, n<String> nVar) {
        t tVar;
        t tVar2;
        o<String> oVar = this.jx.get(str);
        tVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.c;
                tVar2 = oVar;
                if (z) {
                    n<String> cK = ((o.c) oVar).cK();
                    tVar2 = oVar;
                    if (cK != nVar) {
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
            this.jx.put(str, tVar);
            tVar.cM();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public synchronized o<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<byte[]> oVar;
        f cF;
        b aVar;
        boolean z;
        oVar = this.jy.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                cF = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                cF = g.a(i, true);
            } else {
                cF = g.cF();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(cy());
                z = false;
            } else {
                aVar = new a(cy(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(cF, a(aVar, str, "blob", i));
            oVar = b(str, new k(aVar, cF, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<byte[]> b(String str, n<byte[]> nVar) {
        t tVar;
        t tVar2;
        o<byte[]> oVar = this.jy.get(str);
        tVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.c;
                tVar2 = oVar;
                if (z) {
                    n<byte[]> cK = ((o.c) oVar).cK();
                    tVar2 = oVar;
                    if (cK != nVar) {
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
            this.jy.put(str, tVar);
            tVar.cM();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public void a(o<?> oVar) {
        if (oVar instanceof o.c) {
            o.c cVar = (o.c) oVar;
            synchronized (cVar) {
                String cJ = cVar.cJ();
                cVar.cL();
                this.jx.remove(cJ);
            }
        }
    }

    public v cI() {
        if (this.jv == null) {
            this.jv = new v(getContext(), cy());
        }
        return this.jv;
    }

    public com.baidu.adp.base.a.b cy() {
        if (this.iX == null) {
            this.iX = new com.baidu.adp.base.a.b(new j(getContext(), this.jw));
        }
        return this.iX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.jw)) {
            this.jx.clear();
            this.jy.clear();
        }
    }
}
