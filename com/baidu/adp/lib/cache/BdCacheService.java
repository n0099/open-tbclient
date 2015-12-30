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
    private static volatile BdCacheService tq;
    private Context context;
    private com.baidu.adp.base.a.b sQ;
    private v tr;
    private final String ts;
    private HashMap<String, o<String>> tt;
    private HashMap<String, o<byte[]>> tu;
    private boolean tv;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (tw) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (tx) with 'values()' method */
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
        return this.tv;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.tt = new HashMap<>();
        this.tu = new HashMap<>();
        this.ts = str;
        if (BdBaseApplication.getInst() != null) {
            this.tv = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService gk() {
        if (tq == null) {
            synchronized (BdCacheService.class) {
                if (tq == null) {
                    tq = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return tq;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        i ac;
        int fX = cVar.fX();
        v gl = gl();
        ac = gl.ac(str);
        if (ac == null) {
            ac = new i();
            ac.te = str;
            ac.tj = fX;
            ac.ti = str2;
            ac.maxSize = i;
            ac.tk = System.currentTimeMillis();
            ac.sR = cVar.N(str);
            gl.a(ac);
        } else if (!str2.equalsIgnoreCase(ac.ti)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + ac.ti);
        } else {
            ac.maxSize = i;
            ac.tk = System.currentTimeMillis();
            if (fX != ac.tj) {
                cVar.a(str, ac.sR, fX, ac.tj);
            }
            gl.a(ac);
        }
        return ac.sR;
    }

    public synchronized o<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<String> oVar;
        f gi;
        x wVar;
        boolean z;
        oVar = this.tt.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                gi = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                gi = g.a(i, true);
            } else {
                gi = g.gi();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                wVar = new x(ga());
                z = false;
            } else {
                wVar = new w(ga(), "cache_kv_tshare");
                z = true;
            }
            wVar.a(gi, a(wVar, str, "text", i));
            oVar = a(str, new k(wVar, gi, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<String> a(String str, n<String> nVar) {
        t tVar;
        t tVar2;
        o<String> oVar = this.tt.get(str);
        tVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.c;
                tVar2 = oVar;
                if (z) {
                    n<String> gn = ((o.c) oVar).gn();
                    tVar2 = oVar;
                    if (gn != nVar) {
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
            tVar.gp();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public synchronized o<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<byte[]> oVar;
        f gi;
        b aVar;
        boolean z;
        oVar = this.tu.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                gi = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                gi = g.a(i, true);
            } else {
                gi = g.gi();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ga());
                z = false;
            } else {
                aVar = new a(ga(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(gi, a(aVar, str, "blob", i));
            oVar = b(str, new k(aVar, gi, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<byte[]> b(String str, n<byte[]> nVar) {
        t tVar;
        t tVar2;
        o<byte[]> oVar = this.tu.get(str);
        tVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.c;
                tVar2 = oVar;
                if (z) {
                    n<byte[]> gn = ((o.c) oVar).gn();
                    tVar2 = oVar;
                    if (gn != nVar) {
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
            this.tu.put(str, tVar);
            tVar.gp();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public void a(o<?> oVar) {
        if (oVar instanceof o.c) {
            o.c cVar = (o.c) oVar;
            synchronized (cVar) {
                String gm = cVar.gm();
                cVar.go();
                this.tt.remove(gm);
            }
        }
    }

    public v gl() {
        if (this.tr == null) {
            this.tr = new v(getContext(), ga());
        }
        return this.tr;
    }

    public com.baidu.adp.base.a.b ga() {
        if (this.sQ == null) {
            this.sQ = new com.baidu.adp.base.a.b(new j(getContext(), this.ts));
        }
        return this.sQ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.ts)) {
            this.tt.clear();
            this.tu.clear();
        }
    }
}
