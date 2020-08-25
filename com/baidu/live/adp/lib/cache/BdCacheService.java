package com.baidu.live.adp.lib.cache;

import android.content.Context;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.live.adp.base.db.DatabaseManager;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.cache.BdKVCache;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class BdCacheService extends CustomMessageListener {
    public static final String CACHE_TABLE_PREFIX = "cache_kv_";
    public static final String SHARED_BLOB_TABLE = "cache_kv_bshare";
    private static final String SHARED_DATABASE_NAME = "baidu_adp.db";
    public static final String SHARED_TEXT_TABLE = "cache_kv_tshare";
    private static volatile BdCacheService _instance;
    private HashMap<String, BdKVCache<byte[]>> blobCaches;
    private Context context;
    private final String databaseFile;
    private DatabaseManager dbService;
    private boolean debugMode;
    private BdNameSpaceDBManager nameSpaceManager;
    private HashMap<String, BdKVCache<String>> textCaches;

    /* loaded from: classes7.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT
    }

    /* loaded from: classes7.dex */
    public enum CacheStorage {
        SQLite_CACHE_PER_TABLE,
        SQLite_CACHE_All_IN_ONE_TABLE
    }

    public boolean isDebugMode() {
        return this.debugMode;
    }

    public void setDebugMode(boolean z) {
        this.debugMode = z;
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

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static void clearInstance() {
        _instance = null;
    }

    public static BdCacheService sharedInstance() {
        if (_instance == null) {
            synchronized (BdCacheService.class) {
                if (_instance == null) {
                    _instance = new BdCacheService(SHARED_DATABASE_NAME);
                }
            }
        }
        return _instance;
    }

    public static BdCacheService newInstance(String str) {
        return new BdCacheService(str);
    }

    public synchronized String initAndGetTableName(BdCacheBaseDBManager<?> bdCacheBaseDBManager, String str, String str2, int i) {
        BdCacheNSItem bdCacheNSItem;
        int cacheVersion = bdCacheBaseDBManager.getCacheVersion();
        BdNameSpaceDBManager nameSpaceManager = getNameSpaceManager();
        bdCacheNSItem = nameSpaceManager.get(str);
        if (bdCacheNSItem == null) {
            bdCacheNSItem = new BdCacheNSItem();
            bdCacheNSItem.nameSpace = str;
            bdCacheNSItem.cacheVersion = cacheVersion;
            bdCacheNSItem.cacheType = str2;
            bdCacheNSItem.maxSize = i;
            bdCacheNSItem.lastActiveTime = System.currentTimeMillis();
            bdCacheNSItem.tableName = bdCacheBaseDBManager.onNewNameSpaceCreated(str);
            nameSpaceManager.addOrUpdate(bdCacheNSItem);
        } else if (!str2.equalsIgnoreCase(bdCacheNSItem.cacheType)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + bdCacheNSItem.cacheType);
        } else {
            bdCacheNSItem.maxSize = i;
            bdCacheNSItem.lastActiveTime = System.currentTimeMillis();
            if (cacheVersion != bdCacheNSItem.cacheVersion) {
                bdCacheBaseDBManager.onNameSpaceUpgraded(str, bdCacheNSItem.tableName, cacheVersion, bdCacheNSItem.cacheVersion);
            }
            nameSpaceManager.addOrUpdate(bdCacheNSItem);
        }
        return bdCacheNSItem.tableName;
    }

    public synchronized BdKVCache<String> getAndStartTextCache(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        BdKVCache<String> bdKVCache;
        BdCacheEvictPolicy newNoEvictCachePolicy;
        BdTextCachePerTableDBManager bdTextCacheAllInOneTableDBManager;
        boolean z;
        bdKVCache = this.textCaches.get(str);
        if (bdKVCache == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                newNoEvictCachePolicy = BdCacheEvictPolicyFactory.newLRUCachePolicy(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                newNoEvictCachePolicy = BdCacheEvictPolicyFactory.newLRUCachePolicy(i, true);
            } else {
                newNoEvictCachePolicy = BdCacheEvictPolicyFactory.newNoEvictCachePolicy();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                bdTextCacheAllInOneTableDBManager = new BdTextCachePerTableDBManager(getDatabaseManager());
                z = false;
            } else {
                bdTextCacheAllInOneTableDBManager = new BdTextCacheAllInOneTableDBManager(getDatabaseManager(), SHARED_TEXT_TABLE);
                z = true;
            }
            bdTextCacheAllInOneTableDBManager.startup(newNoEvictCachePolicy, initAndGetTableName(bdTextCacheAllInOneTableDBManager, str, "text", i));
            bdKVCache = getAndStartTextCache(str, new BdCacheSQLiteStorage(bdTextCacheAllInOneTableDBManager, newNoEvictCachePolicy, z));
        }
        return bdKVCache;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.live.adp.lib.cache.BdKVCacheImpl] */
    public synchronized BdKVCache<String> getAndStartTextCache(String str, BdCacheStorage<String> bdCacheStorage) {
        BdKVCacheSafeImpl bdKVCacheSafeImpl;
        BdKVCacheSafeImpl bdKVCacheSafeImpl2;
        BdKVCache<String> bdKVCache = this.textCaches.get(str);
        bdKVCacheSafeImpl2 = bdKVCache;
        if (bdKVCache != null) {
            if (bdCacheStorage != null) {
                boolean z = bdKVCache instanceof BdKVCache.MXSupportedCache;
                bdKVCacheSafeImpl2 = bdKVCache;
                if (z) {
                    BdCacheStorage<String> cacheStorage = ((BdKVCache.MXSupportedCache) bdKVCache).getCacheStorage();
                    bdKVCacheSafeImpl2 = bdKVCache;
                    if (cacheStorage != bdCacheStorage) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + bdCacheStorage + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                bdKVCacheSafeImpl = new BdKVCacheImpl(str, bdCacheStorage);
            } else {
                bdKVCacheSafeImpl = new BdKVCacheSafeImpl(str, bdCacheStorage);
            }
            this.textCaches.put(str, bdKVCacheSafeImpl);
            bdKVCacheSafeImpl.onCacheCreated();
            bdKVCacheSafeImpl2 = bdKVCacheSafeImpl;
        }
        return bdKVCacheSafeImpl2;
    }

    public void returnAndCloseTextCache(BdKVCache<String> bdKVCache) {
        if (bdKVCache instanceof BdKVCache.MXSupportedCache) {
            BdKVCache.MXSupportedCache mXSupportedCache = (BdKVCache.MXSupportedCache) bdKVCache;
            synchronized (mXSupportedCache) {
                String nameSpace = mXSupportedCache.getNameSpace();
                mXSupportedCache.flushAndClose();
                this.textCaches.remove(nameSpace);
            }
        }
    }

    public synchronized BdKVCache<byte[]> getAndStartBlobCache(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        BdKVCache<byte[]> bdKVCache;
        BdCacheEvictPolicy newNoEvictCachePolicy;
        BdBlobCachePerTableDBManager bdBlobCacheAllInOneTableDBManager;
        boolean z;
        bdKVCache = this.blobCaches.get(str);
        if (bdKVCache == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                newNoEvictCachePolicy = BdCacheEvictPolicyFactory.newLRUCachePolicy(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                newNoEvictCachePolicy = BdCacheEvictPolicyFactory.newLRUCachePolicy(i, true);
            } else {
                newNoEvictCachePolicy = BdCacheEvictPolicyFactory.newNoEvictCachePolicy();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                bdBlobCacheAllInOneTableDBManager = new BdBlobCachePerTableDBManager(getDatabaseManager());
                z = false;
            } else {
                bdBlobCacheAllInOneTableDBManager = new BdBlobCacheAllInOneTableDBManager(getDatabaseManager(), SHARED_BLOB_TABLE);
                z = true;
            }
            bdBlobCacheAllInOneTableDBManager.startup(newNoEvictCachePolicy, initAndGetTableName(bdBlobCacheAllInOneTableDBManager, str, BdCacheNSItem.CACHE_TYPE_BLOB, i));
            bdKVCache = getAndStartBlobCache(str, new BdCacheSQLiteStorage(bdBlobCacheAllInOneTableDBManager, newNoEvictCachePolicy, z));
        }
        return bdKVCache;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.live.adp.lib.cache.BdKVCacheImpl] */
    public synchronized BdKVCache<byte[]> getAndStartBlobCache(String str, BdCacheStorage<byte[]> bdCacheStorage) {
        BdKVCacheSafeImpl bdKVCacheSafeImpl;
        BdKVCacheSafeImpl bdKVCacheSafeImpl2;
        BdKVCache<byte[]> bdKVCache = this.blobCaches.get(str);
        bdKVCacheSafeImpl2 = bdKVCache;
        if (bdKVCache != null) {
            if (bdCacheStorage != null) {
                boolean z = bdKVCache instanceof BdKVCache.MXSupportedCache;
                bdKVCacheSafeImpl2 = bdKVCache;
                if (z) {
                    BdCacheStorage<byte[]> cacheStorage = ((BdKVCache.MXSupportedCache) bdKVCache).getCacheStorage();
                    bdKVCacheSafeImpl2 = bdKVCache;
                    if (cacheStorage != bdCacheStorage) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + bdCacheStorage + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                bdKVCacheSafeImpl = new BdKVCacheImpl(str, bdCacheStorage);
            } else {
                bdKVCacheSafeImpl = new BdKVCacheSafeImpl(str, bdCacheStorage);
            }
            this.blobCaches.put(str, bdKVCacheSafeImpl);
            bdKVCacheSafeImpl.onCacheCreated();
            bdKVCacheSafeImpl2 = bdKVCacheSafeImpl;
        }
        return bdKVCacheSafeImpl2;
    }

    public void returnAndCloseBlobCache(BdKVCache<byte[]> bdKVCache) {
        if (bdKVCache instanceof BdKVCache.MXSupportedCache) {
            BdKVCache.MXSupportedCache mXSupportedCache = (BdKVCache.MXSupportedCache) bdKVCache;
            synchronized (mXSupportedCache) {
                String nameSpace = mXSupportedCache.getNameSpace();
                mXSupportedCache.flushAndClose();
                this.blobCaches.remove(nameSpace);
            }
        }
    }

    public void returnAndClearCache(BdKVCache<?> bdKVCache) {
        if (bdKVCache instanceof BdKVCache.MXSupportedCache) {
            BdKVCache.MXSupportedCache mXSupportedCache = (BdKVCache.MXSupportedCache) bdKVCache;
            synchronized (mXSupportedCache) {
                String nameSpace = mXSupportedCache.getNameSpace();
                mXSupportedCache.clearAndClose();
                this.textCaches.remove(nameSpace);
            }
        }
    }

    public void shutdown() {
        while (!this.textCaches.isEmpty()) {
            returnAndCloseTextCache(this.textCaches.get(this.textCaches.keySet().iterator().next()));
        }
        if (this.dbService != null) {
            this.dbService.closeDatabase();
        }
    }

    public BdNameSpaceDBManager getNameSpaceManager() {
        if (this.nameSpaceManager == null) {
            this.nameSpaceManager = new BdNameSpaceDBManager(getContext(), getDatabaseManager());
        }
        return this.nameSpaceManager;
    }

    public DatabaseManager getDatabaseManager() {
        if (this.dbService == null) {
            this.dbService = new DatabaseManager(new BdCacheSQLiteHelper(getContext(), this.databaseFile));
        }
        return this.dbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.databaseFile)) {
            this.textCaches.clear();
            this.blobCaches.clear();
        }
    }
}
