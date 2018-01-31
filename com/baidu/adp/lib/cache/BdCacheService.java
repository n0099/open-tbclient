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
    private static volatile BdCacheService ahv;
    private com.baidu.adp.base.a.b agY;
    private boolean ahA;
    private p ahw;
    private final String ahx;
    private HashMap<String, l<String>> ahy;
    private HashMap<String, l<byte[]>> ahz;
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
        return this.ahA;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.ahy = new HashMap<>();
        this.ahz = new HashMap<>();
        this.ahx = str;
        if (BdBaseApplication.getInst() != null) {
            this.ahA = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService mj() {
        if (ahv == null) {
            synchronized (BdCacheService.class) {
                if (ahv == null) {
                    ahv = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return ahv;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h ag;
        int lX = cVar.lX();
        p mk = mk();
        ag = mk.ag(str);
        if (ag == null) {
            ag = new h();
            ag.ahl = str;
            ag.ahq = lX;
            ag.ahp = str2;
            ag.maxSize = i;
            ag.ahr = System.currentTimeMillis();
            ag.agZ = cVar.R(str);
            mk.a(ag);
        } else if (!str2.equalsIgnoreCase(ag.ahp)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + ag.ahp);
        } else {
            ag.maxSize = i;
            ag.ahr = System.currentTimeMillis();
            if (lX != ag.ahq) {
                cVar.b(str, ag.agZ, lX, ag.ahq);
            }
            mk.a(ag);
        }
        return ag.agZ;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e mh;
        r qVar;
        boolean z;
        lVar = this.ahy.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                mh = f.m(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                mh = f.m(i, true);
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
        l<String> lVar = this.ahy.get(str);
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
            this.ahy.put(str, nVar);
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
        lVar = this.ahz.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                mh = f.m(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                mh = f.m(i, true);
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
        l<byte[]> lVar = this.ahz.get(str);
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
            this.ahz.put(str, nVar);
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
                this.ahy.remove(ml);
            }
        }
    }

    public p mk() {
        if (this.ahw == null) {
            this.ahw = new p(getContext(), ma());
        }
        return this.ahw;
    }

    public com.baidu.adp.base.a.b ma() {
        if (this.agY == null) {
            this.agY = new com.baidu.adp.base.a.b(new i(getContext(), this.ahx));
        }
        return this.agY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.ahx)) {
            this.ahy.clear();
            this.ahz.clear();
        }
    }
}
