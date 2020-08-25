package com.baidu.adp.lib.cache;

import android.content.Context;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.lib.cache.BdCacheNSItem;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService extends CustomMessageListener {
    private static volatile BdCacheService Km;
    private com.baidu.adp.base.a.b Kf;
    private p Kn;
    private HashMap<String, l<byte[]>> blobCaches;
    private Context context;
    private final String databaseFile;
    private boolean debugMode;
    private HashMap<String, l<String>> textCaches;

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
        return this.debugMode;
    }

    private BdCacheService(String str) {
        super(MessageConfig.DATABASE_CREATED);
        this.textCaches = new HashMap<>();
        this.blobCaches = new HashMap<>();
        this.databaseFile = str;
        if (BdBaseApplication.getInst() != null) {
            this.debugMode = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService lU() {
        if (Km == null) {
            synchronized (BdCacheService.class) {
                if (Km == null) {
                    Km = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return Km;
    }

    public static BdCacheService by(String str) {
        return new BdCacheService(str);
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h bA;
        int cacheVersion = cVar.getCacheVersion();
        p lV = lV();
        bA = lV.bA(str);
        if (bA == null) {
            bA = new h();
            bA.nameSpace = str;
            bA.cacheVersion = cacheVersion;
            bA.cacheType = str2;
            bA.maxSize = i;
            bA.lastActiveTime = System.currentTimeMillis();
            bA.tableName = cVar.onNewNameSpaceCreated(str);
            lV.a(bA);
        } else if (!str2.equalsIgnoreCase(bA.cacheType)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + bA.cacheType);
        } else {
            bA.maxSize = i;
            bA.lastActiveTime = System.currentTimeMillis();
            if (cacheVersion != bA.cacheVersion) {
                cVar.onNameSpaceUpgraded(str, bA.tableName, cacheVersion, bA.cacheVersion);
            }
            lV.a(bA);
        }
        return bA.tableName;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e lS;
        r qVar;
        boolean z;
        lVar = this.textCaches.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                lS = f.j(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                lS = f.j(i, true);
            } else {
                lS = f.lS();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(lQ());
                z = false;
            } else {
                qVar = new q(lQ(), com.baidu.live.adp.lib.cache.BdCacheService.SHARED_TEXT_TABLE);
                z = true;
            }
            qVar.a(lS, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, lS, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<String> a(String str, k<String> kVar) {
        n nVar;
        n nVar2;
        l<String> lVar = this.textCaches.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<String> lW = ((l.c) lVar).lW();
                    nVar2 = lVar;
                    if (lW != kVar) {
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
            this.textCaches.put(str, nVar);
            nVar.onCacheCreated();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public synchronized l<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<byte[]> lVar;
        e lS;
        b aVar;
        boolean z;
        lVar = this.blobCaches.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                lS = f.j(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                lS = f.j(i, true);
            } else {
                lS = f.lS();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(lQ());
                z = false;
            } else {
                aVar = new a(lQ(), com.baidu.live.adp.lib.cache.BdCacheService.SHARED_BLOB_TABLE);
                z = true;
            }
            aVar.a(lS, a(aVar, str, BdCacheNSItem.CACHE_TYPE_BLOB, i));
            lVar = b(str, new j(aVar, lS, z));
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.m] */
    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        n nVar;
        n nVar2;
        l<byte[]> lVar = this.blobCaches.get(str);
        nVar2 = lVar;
        if (lVar != null) {
            if (kVar != null) {
                boolean z = lVar instanceof l.c;
                nVar2 = lVar;
                if (z) {
                    k<byte[]> lW = ((l.c) lVar).lW();
                    nVar2 = lVar;
                    if (lW != kVar) {
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
            this.blobCaches.put(str, nVar);
            nVar.onCacheCreated();
            nVar2 = nVar;
        }
        return nVar2;
    }

    public void a(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String nameSpace = cVar.getNameSpace();
                cVar.clearAndClose();
                this.textCaches.remove(nameSpace);
            }
        }
    }

    public p lV() {
        if (this.Kn == null) {
            this.Kn = new p(getContext(), lQ());
        }
        return this.Kn;
    }

    public com.baidu.adp.base.a.b lQ() {
        if (this.Kf == null) {
            this.Kf = new com.baidu.adp.base.a.b(new i(getContext(), this.databaseFile));
        }
        return this.Kf;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.databaseFile)) {
            this.textCaches.clear();
            this.blobCaches.clear();
        }
    }
}
