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
    private static volatile BdCacheService aht;
    private com.baidu.adp.base.a.b agW;
    private p ahu;
    private final String ahv;
    private HashMap<String, l<String>> ahw;
    private HashMap<String, l<byte[]>> ahx;
    private boolean ahy;
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
        return this.ahy;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.ahw = new HashMap<>();
        this.ahx = new HashMap<>();
        this.ahv = str;
        if (BdBaseApplication.getInst() != null) {
            this.ahy = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService mj() {
        if (aht == null) {
            synchronized (BdCacheService.class) {
                if (aht == null) {
                    aht = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return aht;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h ag;
        int lX = cVar.lX();
        p mk = mk();
        ag = mk.ag(str);
        if (ag == null) {
            ag = new h();
            ag.ahj = str;
            ag.aho = lX;
            ag.ahn = str2;
            ag.maxSize = i;
            ag.ahp = System.currentTimeMillis();
            ag.agX = cVar.R(str);
            mk.a(ag);
        } else if (!str2.equalsIgnoreCase(ag.ahn)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + ag.ahn);
        } else {
            ag.maxSize = i;
            ag.ahp = System.currentTimeMillis();
            if (lX != ag.aho) {
                cVar.b(str, ag.agX, lX, ag.aho);
            }
            mk.a(ag);
        }
        return ag.agX;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e mh;
        r qVar;
        boolean z;
        lVar = this.ahw.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                mh = f.p(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                mh = f.p(i, true);
            } else {
                mh = f.mh();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(ma());
                z = false;
            } else {
                qVar = new q(ma(), "cache_kv_tshare");
                z = true;
            }
            qVar.a(mh, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, mh, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<String> a(String str, k<String> kVar) {
        n nVar;
        n nVar2;
        l<String> lVar = this.ahw.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<String> mm = ((l.c) lVar).mm();
                    nVar2 = lVar;
                    if (mm != kVar) {
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
            nVar.mo();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public synchronized l<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<byte[]> lVar;
        e mh;
        b aVar;
        boolean z;
        lVar = this.ahx.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                mh = f.p(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                mh = f.p(i, true);
            } else {
                mh = f.mh();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ma());
                z = false;
            } else {
                aVar = new a(ma(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(mh, a(aVar, str, "blob", i));
            lVar = b(str, new j(aVar, mh, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        n nVar;
        n nVar2;
        l<byte[]> lVar = this.ahx.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> mm = ((l.c) lVar).mm();
                    nVar2 = lVar;
                    if (mm != kVar) {
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
            this.ahx.put(str, nVar);
            nVar.mo();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String ml = cVar.ml();
                cVar.mn();
                this.ahw.remove(ml);
            }
        }
    }

    public p mk() {
        if (this.ahu == null) {
            this.ahu = new p(getContext(), ma());
        }
        return this.ahu;
    }

    public com.baidu.adp.base.a.b ma() {
        if (this.agW == null) {
            this.agW = new com.baidu.adp.base.a.b(new i(getContext(), this.ahv));
        }
        return this.agW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.ahv)) {
            this.ahw.clear();
            this.ahx.clear();
        }
    }
}
