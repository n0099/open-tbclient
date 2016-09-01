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
    private static volatile BdCacheService mo;
    private Context context;
    private com.baidu.adp.base.a.b lQ;
    private w mp;
    private final String mq;
    private HashMap<String, o<String>> mr;
    private HashMap<String, o<byte[]>> ms;
    private boolean mt;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (mu) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (mw) with 'values()' method */
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
        return this.mt;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.mr = new HashMap<>();
        this.ms = new HashMap<>();
        this.mq = str;
        if (BdBaseApplication.getInst() != null) {
            this.mt = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService dB() {
        if (mo == null) {
            synchronized (BdCacheService.class) {
                if (mo == null) {
                    mo = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return mo;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        i V;
        int dp = cVar.dp();
        w dC = dC();
        V = dC.V(str);
        if (V == null) {
            V = new i();
            V.md = str;
            V.mj = dp;
            V.mi = str2;
            V.maxSize = i;
            V.mk = System.currentTimeMillis();
            V.lR = cVar.G(str);
            dC.a(V);
        } else if (!str2.equalsIgnoreCase(V.mi)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + V.mi);
        } else {
            V.maxSize = i;
            V.mk = System.currentTimeMillis();
            if (dp != V.mj) {
                cVar.b(str, V.lR, dp, V.mj);
            }
            dC.a(V);
        }
        return V.lR;
    }

    public synchronized o<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<String> oVar;
        f dz;
        y xVar;
        boolean z;
        oVar = this.mr.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                dz = g.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                dz = g.c(i, true);
            } else {
                dz = g.dz();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                xVar = new y(ds());
                z = false;
            } else {
                xVar = new x(ds(), "cache_kv_tshare");
                z = true;
            }
            xVar.a(dz, a(xVar, str, "text", i));
            oVar = a(str, new k(xVar, dz, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<String> a(String str, n<String> nVar) {
        u uVar;
        u uVar2;
        o<String> oVar = this.mr.get(str);
        uVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.d;
                uVar2 = oVar;
                if (z) {
                    n<String> dE = ((o.d) oVar).dE();
                    uVar2 = oVar;
                    if (dE != nVar) {
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
            this.mr.put(str, uVar);
            uVar.dG();
            uVar2 = uVar;
        }
        return uVar2;
    }

    public synchronized o<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<byte[]> oVar;
        f dz;
        b aVar;
        boolean z;
        oVar = this.ms.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                dz = g.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                dz = g.c(i, true);
            } else {
                dz = g.dz();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ds());
                z = false;
            } else {
                aVar = new a(ds(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(dz, a(aVar, str, "blob", i));
            oVar = b(str, new k(aVar, dz, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<byte[]> b(String str, n<byte[]> nVar) {
        u uVar;
        u uVar2;
        o<byte[]> oVar = this.ms.get(str);
        uVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.d;
                uVar2 = oVar;
                if (z) {
                    n<byte[]> dE = ((o.d) oVar).dE();
                    uVar2 = oVar;
                    if (dE != nVar) {
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
            this.ms.put(str, uVar);
            uVar.dG();
            uVar2 = uVar;
        }
        return uVar2;
    }

    public void a(o<?> oVar) {
        if (oVar instanceof o.d) {
            o.d dVar = (o.d) oVar;
            synchronized (dVar) {
                String dD = dVar.dD();
                dVar.dF();
                this.mr.remove(dD);
            }
        }
    }

    public w dC() {
        if (this.mp == null) {
            this.mp = new w(getContext(), ds());
        }
        return this.mp;
    }

    public com.baidu.adp.base.a.b ds() {
        if (this.lQ == null) {
            this.lQ = new com.baidu.adp.base.a.b(new j(getContext(), this.mq));
        }
        return this.lQ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.mq)) {
            this.mr.clear();
            this.ms.clear();
        }
    }
}
