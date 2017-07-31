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
    private static volatile BdCacheService vl;
    private Context context;
    private com.baidu.adp.base.a.b uO;
    private p vm;
    private final String vn;
    private HashMap<String, l<String>> vo;
    private HashMap<String, l<byte[]>> vp;
    private boolean vq;

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
        return this.vq;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.vo = new HashMap<>();
        this.vp = new HashMap<>();
        this.vn = str;
        if (BdBaseApplication.getInst() != null) {
            this.vq = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService eQ() {
        if (vl == null) {
            synchronized (BdCacheService.class) {
                if (vl == null) {
                    vl = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return vl;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h ae;
        int eE = cVar.eE();
        p eR = eR();
        ae = eR.ae(str);
        if (ae == null) {
            ae = new h();
            ae.vb = str;
            ae.vg = eE;
            ae.vf = str2;
            ae.maxSize = i;
            ae.vh = System.currentTimeMillis();
            ae.uP = cVar.P(str);
            eR.a(ae);
        } else if (!str2.equalsIgnoreCase(ae.vf)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + ae.vf);
        } else {
            ae.maxSize = i;
            ae.vh = System.currentTimeMillis();
            if (eE != ae.vg) {
                cVar.b(str, ae.uP, eE, ae.vg);
            }
            eR.a(ae);
        }
        return ae.uP;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e eO;
        r qVar;
        boolean z;
        lVar = this.vo.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                eO = f.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                eO = f.c(i, true);
            } else {
                eO = f.eO();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(eH());
                z = false;
            } else {
                qVar = new q(eH(), "cache_kv_tshare");
                z = true;
            }
            qVar.a(eO, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, eO, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<String> a(String str, k<String> kVar) {
        n nVar;
        n nVar2;
        l<String> lVar = this.vo.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.d;
                nVar2 = lVar;
                if (z) {
                    k<String> eT = ((l.d) lVar).eT();
                    nVar2 = lVar;
                    if (eT != kVar) {
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
            this.vo.put(str, nVar);
            nVar.eV();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public synchronized l<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<byte[]> lVar;
        e eO;
        b aVar;
        boolean z;
        lVar = this.vp.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                eO = f.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                eO = f.c(i, true);
            } else {
                eO = f.eO();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(eH());
                z = false;
            } else {
                aVar = new a(eH(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(eO, a(aVar, str, "blob", i));
            lVar = b(str, new j(aVar, eO, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        n nVar;
        n nVar2;
        l<byte[]> lVar = this.vp.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.d;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> eT = ((l.d) lVar).eT();
                    nVar2 = lVar;
                    if (eT != kVar) {
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
            this.vp.put(str, nVar);
            nVar.eV();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.d) {
            l.d dVar = (l.d) lVar;
            synchronized (dVar) {
                String eS = dVar.eS();
                dVar.eU();
                this.vo.remove(eS);
            }
        }
    }

    public p eR() {
        if (this.vm == null) {
            this.vm = new p(getContext(), eH());
        }
        return this.vm;
    }

    public com.baidu.adp.base.a.b eH() {
        if (this.uO == null) {
            this.uO = new com.baidu.adp.base.a.b(new i(getContext(), this.vn));
        }
        return this.uO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.vn)) {
            this.vo.clear();
            this.vp.clear();
        }
    }
}
