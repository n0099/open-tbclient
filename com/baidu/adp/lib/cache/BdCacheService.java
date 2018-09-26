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
    private static volatile BdCacheService Ag;
    private p Ah;
    private final String Ai;
    private HashMap<String, l<String>> Aj;
    private HashMap<String, l<byte[]>> Ak;
    private boolean Al;
    private Context context;
    private com.baidu.adp.base.a.b zI;

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
        return this.Al;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.Aj = new HashMap<>();
        this.Ak = new HashMap<>();
        this.Ai = str;
        if (BdBaseApplication.getInst() != null) {
            this.Al = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService ij() {
        if (Ag == null) {
            synchronized (BdCacheService.class) {
                if (Ag == null) {
                    Ag = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return Ag;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h aH;
        int hX = cVar.hX();
        p ik = ik();
        aH = ik.aH(str);
        if (aH == null) {
            aH = new h();
            aH.zV = str;
            aH.Aa = hX;
            aH.zZ = str2;
            aH.maxSize = i;
            aH.Ab = System.currentTimeMillis();
            aH.zJ = cVar.as(str);
            ik.a(aH);
        } else if (!str2.equalsIgnoreCase(aH.zZ)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + aH.zZ);
        } else {
            aH.maxSize = i;
            aH.Ab = System.currentTimeMillis();
            if (hX != aH.Aa) {
                cVar.b(str, aH.zJ, hX, aH.Aa);
            }
            ik.a(aH);
        }
        return aH.zJ;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e ih;
        r qVar;
        boolean z;
        lVar = this.Aj.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                ih = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                ih = f.e(i, true);
            } else {
                ih = f.ih();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(ia());
                z = false;
            } else {
                qVar = new q(ia(), "cache_kv_tshare");
                z = true;
            }
            qVar.a(ih, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, ih, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<String> a(String str, k<String> kVar) {
        n nVar;
        n nVar2;
        l<String> lVar = this.Aj.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<String> im = ((l.c) lVar).im();
                    nVar2 = lVar;
                    if (im != kVar) {
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
            this.Aj.put(str, nVar);
            nVar.io();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public synchronized l<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<byte[]> lVar;
        e ih;
        b aVar;
        boolean z;
        lVar = this.Ak.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                ih = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                ih = f.e(i, true);
            } else {
                ih = f.ih();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ia());
                z = false;
            } else {
                aVar = new a(ia(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(ih, a(aVar, str, "blob", i));
            lVar = b(str, new j(aVar, ih, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        n nVar;
        n nVar2;
        l<byte[]> lVar = this.Ak.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> im = ((l.c) lVar).im();
                    nVar2 = lVar;
                    if (im != kVar) {
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
            this.Ak.put(str, nVar);
            nVar.io();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String il = cVar.il();
                cVar.in();
                this.Aj.remove(il);
            }
        }
    }

    public p ik() {
        if (this.Ah == null) {
            this.Ah = new p(getContext(), ia());
        }
        return this.Ah;
    }

    public com.baidu.adp.base.a.b ia() {
        if (this.zI == null) {
            this.zI = new com.baidu.adp.base.a.b(new i(getContext(), this.Ai));
        }
        return this.zI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.Ai)) {
            this.Aj.clear();
            this.Ak.clear();
        }
    }
}
