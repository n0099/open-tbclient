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
    private static volatile BdCacheService xS;
    private Context context;
    private p xT;
    private final String xU;
    private HashMap<String, l<String>> xV;
    private HashMap<String, l<byte[]>> xW;
    private boolean xX;
    private com.baidu.adp.base.a.b xv;

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
        return this.xX;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.xV = new HashMap<>();
        this.xW = new HashMap<>();
        this.xU = str;
        if (BdBaseApplication.getInst() != null) {
            this.xX = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService he() {
        if (xS == null) {
            synchronized (BdCacheService.class) {
                if (xS == null) {
                    xS = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return xS;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h ap;
        int gS = cVar.gS();
        p hf = hf();
        ap = hf.ap(str);
        if (ap == null) {
            ap = new h();
            ap.xI = str;
            ap.xN = gS;
            ap.xM = str2;
            ap.maxSize = i;
            ap.xO = System.currentTimeMillis();
            ap.xw = cVar.aa(str);
            hf.a(ap);
        } else if (!str2.equalsIgnoreCase(ap.xM)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + ap.xM);
        } else {
            ap.maxSize = i;
            ap.xO = System.currentTimeMillis();
            if (gS != ap.xN) {
                cVar.b(str, ap.xw, gS, ap.xN);
            }
            hf.a(ap);
        }
        return ap.xw;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e hc;
        r qVar;
        boolean z;
        lVar = this.xV.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                hc = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                hc = f.e(i, true);
            } else {
                hc = f.hc();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(gV());
                z = false;
            } else {
                qVar = new q(gV(), "cache_kv_tshare");
                z = true;
            }
            qVar.a(hc, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, hc, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<String> a(String str, k<String> kVar) {
        n nVar;
        n nVar2;
        l<String> lVar = this.xV.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<String> hh = ((l.c) lVar).hh();
                    nVar2 = lVar;
                    if (hh != kVar) {
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
            this.xV.put(str, nVar);
            nVar.hj();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public synchronized l<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<byte[]> lVar;
        e hc;
        b aVar;
        boolean z;
        lVar = this.xW.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                hc = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                hc = f.e(i, true);
            } else {
                hc = f.hc();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(gV());
                z = false;
            } else {
                aVar = new a(gV(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(hc, a(aVar, str, "blob", i));
            lVar = b(str, new j(aVar, hc, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        n nVar;
        n nVar2;
        l<byte[]> lVar = this.xW.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> hh = ((l.c) lVar).hh();
                    nVar2 = lVar;
                    if (hh != kVar) {
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
            this.xW.put(str, nVar);
            nVar.hj();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String hg = cVar.hg();
                cVar.hi();
                this.xV.remove(hg);
            }
        }
    }

    public p hf() {
        if (this.xT == null) {
            this.xT = new p(getContext(), gV());
        }
        return this.xT;
    }

    public com.baidu.adp.base.a.b gV() {
        if (this.xv == null) {
            this.xv = new com.baidu.adp.base.a.b(new i(getContext(), this.xU));
        }
        return this.xv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.xU)) {
            this.xV.clear();
            this.xW.clear();
        }
    }
}
