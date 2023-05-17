package com.baidu.searchbox.download.center.clearcache;

import android.text.TextUtils;
import com.baidu.searchbox.download.center.clearcache.BaseClearCache;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheTips;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MainClearCache extends BaseClearCache {
    public static final String CALCULATE_TASK_NAME = "getMainCacheSize";
    public static final String CLEAR_CACHE_FORCE_LIST_KEY = "clear_cache";
    public static final String CLEAR_TASK_NAME = "clearMainCache";
    public static final String EXT_KEY = "main";
    public static final long TIMEOUT = 2;
    public static BaseClearCache sDownloadClearCache;
    public static final List<BaseClearCache> sSubClearCacheList = new ArrayList();
    public List<BaseClearCache> mShowClearCacheList = new ArrayList();

    /* loaded from: classes3.dex */
    public interface MainClearCacheCallback extends BaseClearCache.CacheClearCallback {
        void onItemClearCacheResult(BaseClearCache baseClearCache, long j, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface MainClearSizeCallback extends BaseClearCache.CacheSizeCallback {
        void onItemCacheSizeResult(BaseClearCache baseClearCache, long j);
    }

    @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache
    public String getCacheDesc() {
        return "";
    }

    @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache
    public String getCacheName() {
        return "";
    }

    @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache
    public String getUBCExtKey() {
        return "main";
    }

    @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache
    public boolean isCalculateCacheSize() {
        return true;
    }

    @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache
    public boolean isDefaultSelected() {
        return false;
    }

    static {
        ClearCacheRuntime.getClearCacheContext().addClearCache(sSubClearCacheList);
        sDownloadClearCache = ClearCacheRuntime.getClearCacheContext().getDownloadClearCache();
    }

    public List<BaseClearCache> getCalculateCacheList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(sDownloadClearCache);
        for (BaseClearCache baseClearCache : this.mShowClearCacheList) {
            if (baseClearCache.isCalculateCacheSize()) {
                arrayList.add(baseClearCache);
            }
        }
        return arrayList;
    }

    public long getDownloadSize() {
        return sDownloadClearCache.getCacheSize();
    }

    public long getSelectedCacheSize() {
        long j = 0;
        for (BaseClearCache baseClearCache : sSubClearCacheList) {
            if (baseClearCache.isSelected() && baseClearCache.getCacheSize() >= 1024) {
                j += baseClearCache.getCacheSize();
            }
        }
        return j;
    }

    public List<BaseClearCache> getSelectedClearCacheList() {
        ArrayList arrayList = new ArrayList();
        for (BaseClearCache baseClearCache : this.mShowClearCacheList) {
            if (baseClearCache.isSelected()) {
                arrayList.add(baseClearCache);
            }
        }
        return arrayList;
    }

    public long getSelectedSize() {
        List<BaseClearCache> selectedClearCacheList = getSelectedClearCacheList();
        long j = 0;
        if (selectedClearCacheList != null && selectedClearCacheList.size() > 0) {
            for (BaseClearCache baseClearCache : selectedClearCacheList) {
                j += baseClearCache.getCacheSize();
            }
        }
        return j;
    }

    public List<BaseClearCache> getShowClearCacheList() {
        return this.mShowClearCacheList;
    }

    public List<BaseClearCache> getSubClearCacheList() {
        return sSubClearCacheList;
    }

    public MainClearCache() {
        JSONArray forceList = UserSettingForceListListener.getForceList(CLEAR_CACHE_FORCE_LIST_KEY);
        for (BaseClearCache baseClearCache : sSubClearCacheList) {
            boolean z = false;
            if (forceList != null && forceList.length() > 0) {
                int i = 0;
                while (true) {
                    if (i >= forceList.length()) {
                        break;
                    }
                    JSONObject optJSONObject = forceList.optJSONObject(i);
                    if (optJSONObject != null && TextUtils.equals(optJSONObject.optString(UserSettingForceListListener.FORCE_LIST_ITEM_ID_KEY), baseClearCache.getUBCExtKey())) {
                        if ("1".equals(optJSONObject.optString(UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY))) {
                            this.mShowClearCacheList.add(baseClearCache);
                        }
                        z = true;
                    } else {
                        i++;
                    }
                }
            }
            if (!z && baseClearCache.isShow()) {
                this.mShowClearCacheList.add(baseClearCache);
            }
        }
    }

    @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache
    public void calculateCacheSize(final BaseClearCache.CacheSizeCallback cacheSizeCallback) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.download.center.clearcache.MainClearCache.2
            @Override // java.lang.Runnable
            public void run() {
                List<BaseClearCache> calculateCacheList = MainClearCache.this.getCalculateCacheList();
                final CountDownLatch countDownLatch = new CountDownLatch(calculateCacheList.size());
                for (final BaseClearCache baseClearCache : calculateCacheList) {
                    baseClearCache.calculateCacheSize(new BaseClearCache.CacheSizeCallback() { // from class: com.baidu.searchbox.download.center.clearcache.MainClearCache.2.1
                        @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache.CacheSizeCallback
                        public void onCacheSizeResult(long j) {
                            if (j >= 0) {
                                baseClearCache.setCacheSize(j);
                            }
                            BaseClearCache.CacheSizeCallback cacheSizeCallback2 = cacheSizeCallback;
                            if (cacheSizeCallback2 instanceof MainClearSizeCallback) {
                                BaseClearCache baseClearCache2 = baseClearCache;
                                ((MainClearSizeCallback) cacheSizeCallback2).onItemCacheSizeResult(baseClearCache2, baseClearCache2.getCacheSize());
                            }
                            countDownLatch.countDown();
                        }
                    });
                }
                try {
                    countDownLatch.await(2L, TimeUnit.MINUTES);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long j = 0;
                for (BaseClearCache baseClearCache2 : calculateCacheList) {
                    if (baseClearCache2.getCacheSize() >= 1024) {
                        j += baseClearCache2.getCacheSize();
                    }
                }
                MainClearCache.this.setCacheSize(j);
                try {
                    ClearCacheTips.notifyTips(j);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                BaseClearCache.CacheSizeCallback cacheSizeCallback2 = cacheSizeCallback;
                if (cacheSizeCallback2 != null) {
                    cacheSizeCallback2.onCacheSizeResult(j);
                }
            }
        }, CALCULATE_TASK_NAME, 1);
    }

    @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache
    public void clearCache(final BaseClearCache.CacheClearCallback cacheClearCallback) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.download.center.clearcache.MainClearCache.1
            @Override // java.lang.Runnable
            public void run() {
                List<BaseClearCache> selectedClearCacheList = MainClearCache.this.getSelectedClearCacheList();
                final CountDownLatch countDownLatch = new CountDownLatch(selectedClearCacheList.size());
                for (final BaseClearCache baseClearCache : selectedClearCacheList) {
                    baseClearCache.clearCache(new BaseClearCache.CacheClearCallback() { // from class: com.baidu.searchbox.download.center.clearcache.MainClearCache.1.1
                        @Override // com.baidu.searchbox.download.center.clearcache.BaseClearCache.CacheClearCallback
                        public void onClearCacheResult(boolean z) {
                            long cacheSize = baseClearCache.getCacheSize();
                            if (z) {
                                baseClearCache.setCacheSize(0L);
                            }
                            BaseClearCache.CacheClearCallback cacheClearCallback2 = cacheClearCallback;
                            if (cacheClearCallback2 instanceof MainClearCacheCallback) {
                                ((MainClearCacheCallback) cacheClearCallback2).onItemClearCacheResult(baseClearCache, cacheSize, z);
                            }
                            countDownLatch.countDown();
                        }
                    });
                }
                try {
                    countDownLatch.await(2L, TimeUnit.MINUTES);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long j = 0;
                for (BaseClearCache baseClearCache2 : MainClearCache.this.getCalculateCacheList()) {
                    j += baseClearCache2.getCacheSize();
                }
                MainClearCache.this.setCacheSize(j);
                try {
                    ClearCacheTips.notifyTips(j);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                BaseClearCache.CacheClearCallback cacheClearCallback2 = cacheClearCallback;
                if (cacheClearCallback2 != null) {
                    cacheClearCallback2.onClearCacheResult(true);
                }
            }
        }, CLEAR_TASK_NAME, 1);
    }
}
