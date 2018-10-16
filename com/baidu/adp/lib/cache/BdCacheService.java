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
    private static volatile BdCacheService AQ;
    private p AR;
    private final String AT;
    private HashMap<String, l<String>> AU;
    private HashMap<String, l<byte[]>> AV;
    private boolean AW;
    private com.baidu.adp.base.a.b As;
    private Context context;

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
        return this.AW;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.AU = new HashMap<>();
        this.AV = new HashMap<>();
        this.AT = str;
        if (BdBaseApplication.getInst() != null) {
            this.AW = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService iz() {
        if (AQ == null) {
            synchronized (BdCacheService.class) {
                if (AQ == null) {
                    AQ = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return AQ;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h aH;
        int im = cVar.im();
        p iA = iA();
        aH = iA.aH(str);
        if (aH == null) {
            aH = new h();
            aH.AF = str;
            aH.AK = im;
            aH.AJ = str2;
            aH.maxSize = i;
            aH.AM = System.currentTimeMillis();
            aH.At = cVar.as(str);
            iA.a(aH);
        } else if (!str2.equalsIgnoreCase(aH.AJ)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + aH.AJ);
        } else {
            aH.maxSize = i;
            aH.AM = System.currentTimeMillis();
            if (im != aH.AK) {
                cVar.b(str, aH.At, im, aH.AK);
            }
            iA.a(aH);
        }
        return aH.At;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e ix;
        r qVar;
        boolean z;
        lVar = this.AU.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                ix = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                ix = f.e(i, true);
            } else {
                ix = f.ix();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(iq());
                z = false;
            } else {
                qVar = new q(iq(), "cache_kv_tshare");
                z = true;
            }
            qVar.a(ix, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, ix, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<String> a(String str, k<String> kVar) {
        n nVar;
        n nVar2;
        l<String> lVar = this.AU.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<String> iC = ((l.c) lVar).iC();
                    nVar2 = lVar;
                    if (iC != kVar) {
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
            this.AU.put(str, nVar);
            nVar.iE();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public synchronized l<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<byte[]> lVar;
        e ix;
        b aVar;
        boolean z;
        lVar = this.AV.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                ix = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                ix = f.e(i, true);
            } else {
                ix = f.ix();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(iq());
                z = false;
            } else {
                aVar = new a(iq(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(ix, a(aVar, str, "blob", i));
            lVar = b(str, new j(aVar, ix, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        n nVar;
        n nVar2;
        l<byte[]> lVar = this.AV.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> iC = ((l.c) lVar).iC();
                    nVar2 = lVar;
                    if (iC != kVar) {
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
            this.AV.put(str, nVar);
            nVar.iE();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String iB = cVar.iB();
                cVar.iD();
                this.AU.remove(iB);
            }
        }
    }

    public p iA() {
        if (this.AR == null) {
            this.AR = new p(getContext(), iq());
        }
        return this.AR;
    }

    public com.baidu.adp.base.a.b iq() {
        if (this.As == null) {
            this.As = new com.baidu.adp.base.a.b(new i(getContext(), this.AT));
        }
        return this.As;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.AT)) {
            this.AU.clear();
            this.AV.clear();
        }
    }
}
