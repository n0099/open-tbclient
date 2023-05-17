package com.baidu.searchbox.download.center.clearcache;
/* loaded from: classes3.dex */
public abstract class BaseClearCache {
    public long mCacheSize = 0;
    public boolean mSelected = isDefaultSelected();

    /* loaded from: classes3.dex */
    public interface CacheClearCallback {
        void onClearCacheResult(boolean z);
    }

    /* loaded from: classes3.dex */
    public interface CacheSizeCallback {
        void onCacheSizeResult(long j);
    }

    public abstract void calculateCacheSize(CacheSizeCallback cacheSizeCallback);

    public abstract void clearCache(CacheClearCallback cacheClearCallback);

    public abstract String getCacheDesc();

    public abstract String getCacheName();

    public abstract String getUBCExtKey();

    public abstract boolean isCalculateCacheSize();

    public abstract boolean isDefaultSelected();

    public boolean isShow() {
        return true;
    }

    public long getCacheSize() {
        return this.mCacheSize;
    }

    public boolean isSelected() {
        return this.mSelected;
    }

    public void setCacheSize(long j) {
        this.mCacheSize = j;
    }

    public void setSelected(boolean z) {
        this.mSelected = z;
    }
}
