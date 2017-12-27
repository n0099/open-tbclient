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
    private static volatile BdCacheService ahs;
    private com.baidu.adp.base.a.b agV;
    private p aht;
    private final String ahu;
    private HashMap<String, l<String>> ahv;
    private HashMap<String, l<byte[]>> ahw;
    private boolean ahx;
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
        return this.ahx;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.ahv = new HashMap<>();
        this.ahw = new HashMap<>();
        this.ahu = str;
        if (BdBaseApplication.getInst() != null) {
            this.ahx = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService mi() {
        if (ahs == null) {
            synchronized (BdCacheService.class) {
                if (ahs == null) {
                    ahs = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return ahs;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h ag;
        int lW = cVar.lW();
        p mj = mj();
        ag = mj.ag(str);
        if (ag == null) {
            ag = new h();
            ag.ahi = str;
            ag.ahn = lW;
            ag.ahm = str2;
            ag.maxSize = i;
            ag.aho = System.currentTimeMillis();
            ag.agW = cVar.R(str);
            mj.a(ag);
        } else if (!str2.equalsIgnoreCase(ag.ahm)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + ag.ahm);
        } else {
            ag.maxSize = i;
            ag.aho = System.currentTimeMillis();
            if (lW != ag.ahn) {
                cVar.b(str, ag.agW, lW, ag.ahn);
            }
            mj.a(ag);
        }
        return ag.agW;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e mg;
        r qVar;
        boolean z;
        lVar = this.ahv.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                mg = f.m(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                mg = f.m(i, true);
            } else {
                mg = f.mg();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(lZ());
                z = false;
            } else {
                qVar = new q(lZ(), "cache_kv_tshare");
                z = true;
            }
            qVar.a(mg, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, mg, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<String> a(String str, k<String> kVar) {
        n nVar;
        n nVar2;
        l<String> lVar = this.ahv.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<String> ml = ((l.c) lVar).ml();
                    nVar2 = lVar;
                    if (ml != kVar) {
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
            this.ahv.put(str, nVar);
            nVar.mn();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public synchronized l<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<byte[]> lVar;
        e mg;
        b aVar;
        boolean z;
        lVar = this.ahw.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                mg = f.m(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                mg = f.m(i, true);
            } else {
                mg = f.mg();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(lZ());
                z = false;
            } else {
                aVar = new a(lZ(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(mg, a(aVar, str, "blob", i));
            lVar = b(str, new j(aVar, mg, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        n nVar;
        n nVar2;
        l<byte[]> lVar = this.ahw.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> ml = ((l.c) lVar).ml();
                    nVar2 = lVar;
                    if (ml != kVar) {
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
            this.ahw.put(str, nVar);
            nVar.mn();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String mk = cVar.mk();
                cVar.mm();
                this.ahv.remove(mk);
            }
        }
    }

    public p mj() {
        if (this.aht == null) {
            this.aht = new p(getContext(), lZ());
        }
        return this.aht;
    }

    public com.baidu.adp.base.a.b lZ() {
        if (this.agV == null) {
            this.agV = new com.baidu.adp.base.a.b(new i(getContext(), this.ahu));
        }
        return this.agV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.ahu)) {
            this.ahv.clear();
            this.ahw.clear();
        }
    }
}
