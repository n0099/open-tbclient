package com.baidu.live.adp.lib.cache;

import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.cache.BdCacheEvictPolicy;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.adp.lib.safe.ThreadService;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
/* loaded from: classes2.dex */
public class BdKVCacheImpl<T> implements BdKVCache.MXSupportedCache<T> {
    protected final String nameSpace;
    protected final BdCacheStorage<T> storage;
    private boolean strictMode = false;

    public BdKVCacheImpl(String str, BdCacheStorage<T> bdCacheStorage) {
        this.nameSpace = str;
        this.storage = bdCacheStorage;
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && BdUtilHelper.isMainThread()) {
            if (this.strictMode) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.storage.get(this.nameSpace, str);
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public BdKVCache.CacheElement<T> getForDetail(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && BdUtilHelper.isMainThread()) {
            if (this.strictMode) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.storage.getForDetail(this.nameSpace, str);
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void set(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= BdKVCache.MILLS_10Years ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && BdUtilHelper.isMainThread()) {
            if (this.strictMode) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.storage.set(this.nameSpace, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void setForever(String str, T t) {
        set(str, t, BdKVCache.MILLS_10Years);
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && BdUtilHelper.isMainThread()) {
            if (this.strictMode) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.storage.remove(this.nameSpace, str);
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void asyncGet(final String str, final BdKVCache.BdCacheGetCallback<T> bdCacheGetCallback) {
        ThreadService.sharedInstance().submitTask(new Runnable() { // from class: com.baidu.live.adp.lib.cache.BdKVCacheImpl.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.live.adp.lib.cache.BdKVCache$BdCacheGetCallback */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                bdCacheGetCallback.onItemGet(str, BdKVCacheImpl.this.get(str));
            }
        });
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void asyncGetForDetail(final String str, final BdKVCache.BdCacheGetDetailCallback<T> bdCacheGetDetailCallback) {
        ThreadService.sharedInstance().submitTask(new Runnable() { // from class: com.baidu.live.adp.lib.cache.BdKVCacheImpl.2
            @Override // java.lang.Runnable
            public void run() {
                bdCacheGetDetailCallback.onItemGet(str, BdKVCacheImpl.this.getForDetail(str));
            }
        });
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void asyncSet(final String str, final T t, final long j) {
        ThreadService.sharedInstance().submitTask(new Runnable() { // from class: com.baidu.live.adp.lib.cache.BdKVCacheImpl.3
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.live.adp.lib.cache.BdKVCacheImpl */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                BdKVCacheImpl.this.set(str, t, j);
            }
        });
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void asyncSetForever(String str, T t) {
        asyncSet(str, t, BdKVCache.MILLS_10Years);
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void asyncRemove(final String str) {
        ThreadService.sharedInstance().submitTask(new Runnable() { // from class: com.baidu.live.adp.lib.cache.BdKVCacheImpl.4
            @Override // java.lang.Runnable
            public void run() {
                BdKVCacheImpl.this.remove(str);
            }
        });
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache.MXSupportedCache
    public String getNameSpace() {
        return this.nameSpace;
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache.MXSupportedCache
    public BdCacheStorage<T> getCacheStorage() {
        return this.storage;
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache.MXSupportedCache
    public void onCacheCreated() {
        this.storage.startup(this.nameSpace);
    }

    protected void releaseCacheData() {
        BdCacheEvictPolicy cachePolicy = getCacheStorage().getCachePolicy();
        if (cachePolicy instanceof BdCacheEvictPolicy.EvictOnInsertSupport) {
            ((BdCacheEvictPolicy.EvictOnInsertSupport) cachePolicy).release();
        }
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache.MXSupportedCache
    public void flushAndClose() {
        this.storage.flushAndClose(this.nameSpace);
        releaseCacheData();
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache.MXSupportedCache
    public void clearAndClose() {
        this.storage.clearAndClose(this.nameSpace);
        releaseCacheData();
    }
}
