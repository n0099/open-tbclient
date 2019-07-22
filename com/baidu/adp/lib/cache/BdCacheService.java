package com.baidu.adp.lib.cache;

import android.content.Context;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService extends CustomMessageListener {
    private static volatile BdCacheService yG;
    private Context context;
    private p yH;
    private final String yI;
    private HashMap<String, l<String>> yJ;
    private HashMap<String, l<byte[]>> yK;
    private boolean yL;
    private com.baidu.adp.base.a.b yj;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT
    }

    /* loaded from: classes.dex */
    public enum CacheStorage {
        SQLite_CACHE_PER_TABLE,
        SQLite_CACHE_All_IN_ONE_TABLE
    }

    public boolean isDebugMode() {
        return this.yL;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.yJ = new HashMap<>();
        this.yK = new HashMap<>();
        this.yI = str;
        if (BdBaseApplication.getInst() != null) {
            this.yL = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService hA() {
        if (yG == null) {
            synchronized (BdCacheService.class) {
                if (yG == null) {
                    yG = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return yG;
    }

    public static BdCacheService ap(String str) {
        return new BdCacheService(str);
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h as;
        int hn = cVar.hn();
        p hB = hB();
        as = hB.as(str);
        if (as == null) {
            as = new h();
            as.yw = str;
            as.yB = hn;
            as.yA = str2;
            as.maxSize = i;
            as.yC = System.currentTimeMillis();
            as.yk = cVar.ac(str);
            hB.a(as);
        } else if (!str2.equalsIgnoreCase(as.yA)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + as.yA);
        } else {
            as.maxSize = i;
            as.yC = System.currentTimeMillis();
            if (hn != as.yB) {
                cVar.b(str, as.yk, hn, as.yB);
            }
            hB.a(as);
        }
        return as.yk;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e hy;
        r qVar;
        boolean z;
        lVar = this.yJ.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                hy = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                hy = f.e(i, true);
            } else {
                hy = f.hy();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(hq());
                z = false;
            } else {
                qVar = new q(hq(), "cache_kv_tshare");
                z = true;
            }
            qVar.a(hy, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, hy, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<String> a(String str, k<String> kVar) {
        n nVar;
        n nVar2;
        l<String> lVar = this.yJ.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<String> hD = ((l.c) lVar).hD();
                    nVar2 = lVar;
                    if (hD != kVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + kVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                nVar = new m(str, kVar);
            } else {
                nVar = new n(str, kVar);
            }
            this.yJ.put(str, nVar);
            nVar.hF();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public synchronized l<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<byte[]> lVar;
        e hy;
        b aVar;
        boolean z;
        lVar = this.yK.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                hy = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                hy = f.e(i, true);
            } else {
                hy = f.hy();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(hq());
                z = false;
            } else {
                aVar = new a(hq(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(hy, a(aVar, str, "blob", i));
            lVar = b(str, new j(aVar, hy, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        n nVar;
        n nVar2;
        l<byte[]> lVar = this.yK.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> hD = ((l.c) lVar).hD();
                    nVar2 = lVar;
                    if (hD != kVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + kVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                nVar = new m(str, kVar);
            } else {
                nVar = new n(str, kVar);
            }
            this.yK.put(str, nVar);
            nVar.hF();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String hC = cVar.hC();
                cVar.hE();
                this.yJ.remove(hC);
            }
        }
    }

    public p hB() {
        if (this.yH == null) {
            this.yH = new p(getContext(), hq());
        }
        return this.yH;
    }

    public com.baidu.adp.base.a.b hq() {
        if (this.yj == null) {
            this.yj = new com.baidu.adp.base.a.b(new i(getContext(), this.yI));
        }
        return this.yj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.yI)) {
            this.yJ.clear();
            this.yK.clear();
        }
    }
}
