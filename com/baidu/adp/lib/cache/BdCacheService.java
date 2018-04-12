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
    private static volatile BdCacheService rI;
    private Context context;
    private p rJ;
    private final String rK;
    private HashMap<String, l<String>> rL;
    private HashMap<String, l<byte[]>> rM;
    private boolean rN;
    private com.baidu.adp.base.a.b rk;

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
        return this.rN;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.rL = new HashMap<>();
        this.rM = new HashMap<>();
        this.rK = str;
        if (BdBaseApplication.getInst() != null) {
            this.rN = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService en() {
        if (rI == null) {
            synchronized (BdCacheService.class) {
                if (rI == null) {
                    rI = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return rI;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h ad;
        int eb = cVar.eb();
        p eo = eo();
        ad = eo.ad(str);
        if (ad == null) {
            ad = new h();
            ad.ry = str;
            ad.rD = eb;
            ad.rC = str2;
            ad.maxSize = i;
            ad.rE = System.currentTimeMillis();
            ad.rl = cVar.O(str);
            eo.a(ad);
        } else if (!str2.equalsIgnoreCase(ad.rC)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + ad.rC);
        } else {
            ad.maxSize = i;
            ad.rE = System.currentTimeMillis();
            if (eb != ad.rD) {
                cVar.b(str, ad.rl, eb, ad.rD);
            }
            eo.a(ad);
        }
        return ad.rl;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e el;
        r qVar;
        boolean z;
        lVar = this.rL.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                el = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                el = f.e(i, true);
            } else {
                el = f.el();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(ee());
                z = false;
            } else {
                qVar = new q(ee(), "cache_kv_tshare");
                z = true;
            }
            qVar.a(el, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, el, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<String> a(String str, k<String> kVar) {
        n nVar;
        n nVar2;
        l<String> lVar = this.rL.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<String> eq = ((l.c) lVar).eq();
                    nVar2 = lVar;
                    if (eq != kVar) {
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
            this.rL.put(str, nVar);
            nVar.es();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public synchronized l<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<byte[]> lVar;
        e el;
        b aVar;
        boolean z;
        lVar = this.rM.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                el = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                el = f.e(i, true);
            } else {
                el = f.el();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ee());
                z = false;
            } else {
                aVar = new a(ee(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(el, a(aVar, str, "blob", i));
            lVar = b(str, new j(aVar, el, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        n nVar;
        n nVar2;
        l<byte[]> lVar = this.rM.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> eq = ((l.c) lVar).eq();
                    nVar2 = lVar;
                    if (eq != kVar) {
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
            this.rM.put(str, nVar);
            nVar.es();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String ep = cVar.ep();
                cVar.er();
                this.rL.remove(ep);
            }
        }
    }

    public p eo() {
        if (this.rJ == null) {
            this.rJ = new p(getContext(), ee());
        }
        return this.rJ;
    }

    public com.baidu.adp.base.a.b ee() {
        if (this.rk == null) {
            this.rk = new com.baidu.adp.base.a.b(new i(getContext(), this.rK));
        }
        return this.rk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.rK)) {
            this.rL.clear();
            this.rM.clear();
        }
    }
}
