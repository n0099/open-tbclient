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
    private static volatile BdCacheService xM;
    private Context context;
    private p xN;
    private final String xO;
    private HashMap<String, l<String>> xP;
    private HashMap<String, l<byte[]>> xQ;
    private boolean xR;
    private com.baidu.adp.base.a.b xp;

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
        return this.xR;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.xP = new HashMap<>();
        this.xQ = new HashMap<>();
        this.xO = str;
        if (BdBaseApplication.getInst() != null) {
            this.xR = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService hd() {
        if (xM == null) {
            synchronized (BdCacheService.class) {
                if (xM == null) {
                    xM = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return xM;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h aq;
        int gR = cVar.gR();
        p he = he();
        aq = he.aq(str);
        if (aq == null) {
            aq = new h();
            aq.xC = str;
            aq.xH = gR;
            aq.xG = str2;
            aq.maxSize = i;
            aq.xI = System.currentTimeMillis();
            aq.xq = cVar.ab(str);
            he.a(aq);
        } else if (!str2.equalsIgnoreCase(aq.xG)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + aq.xG);
        } else {
            aq.maxSize = i;
            aq.xI = System.currentTimeMillis();
            if (gR != aq.xH) {
                cVar.b(str, aq.xq, gR, aq.xH);
            }
            he.a(aq);
        }
        return aq.xq;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e hb;
        r qVar;
        boolean z;
        lVar = this.xP.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                hb = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                hb = f.e(i, true);
            } else {
                hb = f.hb();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(gU());
                z = false;
            } else {
                qVar = new q(gU(), "cache_kv_tshare");
                z = true;
            }
            qVar.a(hb, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, hb, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<String> a(String str, k<String> kVar) {
        n nVar;
        n nVar2;
        l<String> lVar = this.xP.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<String> hg = ((l.c) lVar).hg();
                    nVar2 = lVar;
                    if (hg != kVar) {
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
            this.xP.put(str, nVar);
            nVar.hi();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public synchronized l<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<byte[]> lVar;
        e hb;
        b aVar;
        boolean z;
        lVar = this.xQ.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                hb = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                hb = f.e(i, true);
            } else {
                hb = f.hb();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(gU());
                z = false;
            } else {
                aVar = new a(gU(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(hb, a(aVar, str, "blob", i));
            lVar = b(str, new j(aVar, hb, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        n nVar;
        n nVar2;
        l<byte[]> lVar = this.xQ.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> hg = ((l.c) lVar).hg();
                    nVar2 = lVar;
                    if (hg != kVar) {
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
            this.xQ.put(str, nVar);
            nVar.hi();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String hf = cVar.hf();
                cVar.hh();
                this.xP.remove(hf);
            }
        }
    }

    public p he() {
        if (this.xN == null) {
            this.xN = new p(getContext(), gU());
        }
        return this.xN;
    }

    public com.baidu.adp.base.a.b gU() {
        if (this.xp == null) {
            this.xp = new com.baidu.adp.base.a.b(new i(getContext(), this.xO));
        }
        return this.xp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.xO)) {
            this.xP.clear();
            this.xQ.clear();
        }
    }
}
