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
    private static volatile BdCacheService tp;
    private Context context;
    private com.baidu.adp.base.a.b sP;
    private v tq;
    private final String tr;
    private HashMap<String, o<String>> ts;
    private HashMap<String, o<byte[]>> tt;
    private boolean tu;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (tv) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (tw) with 'values()' method */
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
        return this.tu;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.ts = new HashMap<>();
        this.tt = new HashMap<>();
        this.tr = str;
        if (BdBaseApplication.getInst() != null) {
            this.tu = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService go() {
        if (tp == null) {
            synchronized (BdCacheService.class) {
                if (tp == null) {
                    tp = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return tp;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        i ae;
        int ga = cVar.ga();
        v gp = gp();
        ae = gp.ae(str);
        if (ae == null) {
            ae = new i();
            ae.td = str;
            ae.ti = ga;
            ae.th = str2;
            ae.maxSize = i;
            ae.tj = System.currentTimeMillis();
            ae.sQ = cVar.P(str);
            gp.a(ae);
        } else if (!str2.equalsIgnoreCase(ae.th)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + ae.th);
        } else {
            ae.maxSize = i;
            ae.tj = System.currentTimeMillis();
            if (ga != ae.ti) {
                cVar.a(str, ae.sQ, ga, ae.ti);
            }
            gp.a(ae);
        }
        return ae.sQ;
    }

    public synchronized o<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<String> oVar;
        f gm;
        x wVar;
        boolean z;
        oVar = this.ts.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                gm = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                gm = g.a(i, true);
            } else {
                gm = g.gm();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                wVar = new x(ge());
                z = false;
            } else {
                wVar = new w(ge(), "cache_kv_tshare");
                z = true;
            }
            wVar.a(gm, a(wVar, str, "text", i));
            oVar = a(str, new k(wVar, gm, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<String> a(String str, n<String> nVar) {
        t tVar;
        t tVar2;
        o<String> oVar = this.ts.get(str);
        tVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.c;
                tVar2 = oVar;
                if (z) {
                    n<String> gr = ((o.c) oVar).gr();
                    tVar2 = oVar;
                    if (gr != nVar) {
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
            this.ts.put(str, tVar);
            tVar.gt();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public synchronized o<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<byte[]> oVar;
        f gm;
        b aVar;
        boolean z;
        oVar = this.tt.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                gm = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                gm = g.a(i, true);
            } else {
                gm = g.gm();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ge());
                z = false;
            } else {
                aVar = new a(ge(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(gm, a(aVar, str, "blob", i));
            oVar = b(str, new k(aVar, gm, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<byte[]> b(String str, n<byte[]> nVar) {
        t tVar;
        t tVar2;
        o<byte[]> oVar = this.tt.get(str);
        tVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.c;
                tVar2 = oVar;
                if (z) {
                    n<byte[]> gr = ((o.c) oVar).gr();
                    tVar2 = oVar;
                    if (gr != nVar) {
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
            this.tt.put(str, tVar);
            tVar.gt();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public void a(o<?> oVar) {
        if (oVar instanceof o.c) {
            o.c cVar = (o.c) oVar;
            synchronized (cVar) {
                String gq = cVar.gq();
                cVar.gs();
                this.ts.remove(gq);
            }
        }
    }

    public v gp() {
        if (this.tq == null) {
            this.tq = new v(getContext(), ge());
        }
        return this.tq;
    }

    public com.baidu.adp.base.a.b ge() {
        if (this.sP == null) {
            this.sP = new com.baidu.adp.base.a.b(new j(getContext(), this.tr));
        }
        return this.sP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.tr)) {
            this.ts.clear();
            this.tt.clear();
        }
    }
}
