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
    private static volatile BdCacheService Jj;
    private com.baidu.adp.base.a.b Jc;
    private p Jk;
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

    public static BdCacheService kf() {
        if (Jj == null) {
            synchronized (BdCacheService.class) {
                if (Jj == null) {
                    Jj = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return Jj;
    }

    public static BdCacheService bs(String str) {
        return new BdCacheService(str);
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        h bu;
        int cacheVersion = cVar.getCacheVersion();
        p kg = kg();
        bu = kg.bu(str);
        if (bu == null) {
            bu = new h();
            bu.nameSpace = str;
            bu.cacheVersion = cacheVersion;
            bu.cacheType = str2;
            bu.maxSize = i;
            bu.lastActiveTime = System.currentTimeMillis();
            bu.tableName = cVar.onNewNameSpaceCreated(str);
            kg.a(bu);
        } else if (!str2.equalsIgnoreCase(bu.cacheType)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + bu.cacheType);
        } else {
            bu.maxSize = i;
            bu.lastActiveTime = System.currentTimeMillis();
            if (cacheVersion != bu.cacheVersion) {
                cVar.onNameSpaceUpgraded(str, bu.tableName, cacheVersion, bu.cacheVersion);
            }
            kg.a(bu);
        }
        return bu.tableName;
    }

    public synchronized l<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        l<String> lVar;
        e kd;
        r qVar;
        boolean z;
        lVar = this.textCaches.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                kd = f.h(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                kd = f.h(i, true);
            } else {
                kd = f.kd();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                qVar = new r(kb());
                z = false;
            } else {
                qVar = new q(kb(), com.baidu.live.adp.lib.cache.BdCacheService.SHARED_TEXT_TABLE);
                z = true;
            }
            qVar.a(kd, a(qVar, str, "text", i));
            lVar = a(str, new j(qVar, kd, z));
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
                    k<String> kh = ((l.c) lVar).kh();
                    nVar2 = lVar;
                    if (kh != kVar) {
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
        e kd;
        b aVar;
        boolean z;
        lVar = this.blobCaches.get(str);
        if (lVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                kd = f.h(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                kd = f.h(i, true);
            } else {
                kd = f.kd();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(kb());
                z = false;
            } else {
                aVar = new a(kb(), com.baidu.live.adp.lib.cache.BdCacheService.SHARED_BLOB_TABLE);
                z = true;
            }
            aVar.a(kd, a(aVar, str, BdCacheNSItem.CACHE_TYPE_BLOB, i));
            lVar = b(str, new j(aVar, kd, z));
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
                    k<byte[]> kh = ((l.c) lVar).kh();
                    nVar2 = lVar;
                    if (kh != kVar) {
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

    public p kg() {
        if (this.Jk == null) {
            this.Jk = new p(getContext(), kb());
        }
        return this.Jk;
    }

    public com.baidu.adp.base.a.b kb() {
        if (this.Jc == null) {
            this.Jc = new com.baidu.adp.base.a.b(new i(getContext(), this.databaseFile));
        }
        return this.Jc;
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
