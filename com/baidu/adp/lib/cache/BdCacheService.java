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
    private static volatile BdCacheService yB;
    private Context context;
    private p yC;
    private final String yD;
    private HashMap<String, l<String>> yE;
    private HashMap<String, l<byte[]>> yF;
    private boolean yG;
    private com.baidu.adp.base.a.b ye;

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
        return this.yG;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.yE = new HashMap<>();
        this.yF = new HashMap<>();
        this.yD = str;
        if (BdBaseApplication.getInst() != null) {
            this.yG = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService hq() {
        if (yB == null) {
            synchronized (BdCacheService.class) {
                if (yB == null) {
                    yB = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return yB;
    }

    public static BdCacheService ao(String str) {
        return new BdCacheService(str);
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h ar;
        int he = cVar.he();
        p hr = hr();
        ar = hr.ar(str);
        if (ar == null) {
            ar = new h();
            ar.yr = str;
            ar.yw = he;
            ar.yv = str2;
            ar.maxSize = i;
            ar.yx = System.currentTimeMillis();
            ar.yf = cVar.ab(str);
            hr.a(ar);
        } else if (!str2.equalsIgnoreCase(ar.yv)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + ar.yv);
        } else {
            ar.maxSize = i;
            ar.yx = System.currentTimeMillis();
            if (he != ar.yw) {
                cVar.b(str, ar.yf, he, ar.yw);
            }
            hr.a(ar);
        }
        return ar.yf;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e ho;
        r qVar;
        boolean z;
        lVar = this.yE.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                ho = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                ho = f.e(i, true);
            } else {
                ho = f.ho();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(hh());
                z = false;
            } else {
                qVar = new q(hh(), "cache_kv_tshare");
                z = true;
            }
            qVar.a(ho, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, ho, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<String> a(String str, k<String> kVar) {
        n nVar;
        n nVar2;
        l<String> lVar = this.yE.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<String> ht = ((l.c) lVar).ht();
                    nVar2 = lVar;
                    if (ht != kVar) {
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
            this.yE.put(str, nVar);
            nVar.hv();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public synchronized l<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<byte[]> lVar;
        e ho;
        b aVar;
        boolean z;
        lVar = this.yF.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                ho = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                ho = f.e(i, true);
            } else {
                ho = f.ho();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(hh());
                z = false;
            } else {
                aVar = new a(hh(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(ho, a(aVar, str, "blob", i));
            lVar = b(str, new j(aVar, ho, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        n nVar;
        n nVar2;
        l<byte[]> lVar = this.yF.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> ht = ((l.c) lVar).ht();
                    nVar2 = lVar;
                    if (ht != kVar) {
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
            this.yF.put(str, nVar);
            nVar.hv();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String hs = cVar.hs();
                cVar.hu();
                this.yE.remove(hs);
            }
        }
    }

    public p hr() {
        if (this.yC == null) {
            this.yC = new p(getContext(), hh());
        }
        return this.yC;
    }

    public com.baidu.adp.base.a.b hh() {
        if (this.ye == null) {
            this.ye = new com.baidu.adp.base.a.b(new i(getContext(), this.yD));
        }
        return this.ye;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.yD)) {
            this.yE.clear();
            this.yF.clear();
        }
    }
}
