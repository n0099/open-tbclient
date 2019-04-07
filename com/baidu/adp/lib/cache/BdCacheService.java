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
    private static volatile BdCacheService AR;
    private p AT;
    private final String AU;
    private HashMap<String, l<String>> AV;
    private HashMap<String, l<byte[]>> AW;
    private boolean AX;
    private com.baidu.adp.base.a.b At;
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
        return this.AX;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.AV = new HashMap<>();
        this.AW = new HashMap<>();
        this.AU = str;
        if (BdBaseApplication.getInst() != null) {
            this.AX = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService iy() {
        if (AR == null) {
            synchronized (BdCacheService.class) {
                if (AR == null) {
                    AR = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return AR;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h aH;
        int il = cVar.il();
        p iz = iz();
        aH = iz.aH(str);
        if (aH == null) {
            aH = new h();
            aH.AG = str;
            aH.AM = il;
            aH.AK = str2;
            aH.maxSize = i;
            aH.AN = System.currentTimeMillis();
            aH.Au = cVar.as(str);
            iz.a(aH);
        } else if (!str2.equalsIgnoreCase(aH.AK)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + aH.AK);
        } else {
            aH.maxSize = i;
            aH.AN = System.currentTimeMillis();
            if (il != aH.AM) {
                cVar.b(str, aH.Au, il, aH.AM);
            }
            iz.a(aH);
        }
        return aH.Au;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e iw;
        r qVar;
        boolean z;
        lVar = this.AV.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                iw = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                iw = f.e(i, true);
            } else {
                iw = f.iw();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(ip());
                z = false;
            } else {
                qVar = new q(ip(), "cache_kv_tshare");
                z = true;
            }
            qVar.a(iw, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, iw, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<String> a(String str, k<String> kVar) {
        n nVar;
        n nVar2;
        l<String> lVar = this.AV.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<String> iB = ((l.c) lVar).iB();
                    nVar2 = lVar;
                    if (iB != kVar) {
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
            nVar.iD();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public synchronized l<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<byte[]> lVar;
        e iw;
        b aVar;
        boolean z;
        lVar = this.AW.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                iw = f.e(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                iw = f.e(i, true);
            } else {
                iw = f.iw();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ip());
                z = false;
            } else {
                aVar = new a(ip(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(iw, a(aVar, str, "blob", i));
            lVar = b(str, new j(aVar, iw, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        n nVar;
        n nVar2;
        l<byte[]> lVar = this.AW.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> iB = ((l.c) lVar).iB();
                    nVar2 = lVar;
                    if (iB != kVar) {
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
            this.AW.put(str, nVar);
            nVar.iD();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String iA = cVar.iA();
                cVar.iC();
                this.AV.remove(iA);
            }
        }
    }

    public p iz() {
        if (this.AT == null) {
            this.AT = new p(getContext(), ip());
        }
        return this.AT;
    }

    public com.baidu.adp.base.a.b ip() {
        if (this.At == null) {
            this.At = new com.baidu.adp.base.a.b(new i(getContext(), this.AU));
        }
        return this.At;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.AU)) {
            this.AV.clear();
            this.AW.clear();
        }
    }
}
