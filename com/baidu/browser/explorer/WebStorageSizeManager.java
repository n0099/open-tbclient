package com.baidu.browser.explorer;

import android.content.Context;
import android.os.StatFs;
import com.baidu.browser.webkit.BdWebStorage;
import java.io.File;
/* loaded from: classes.dex */
public class WebStorageSizeManager {
    public static final long APPCACHE_MAXSIZE_PADDING = 524288;
    public static final long ORIGIN_DEFAULT_QUOTA = 3145728;
    public static final long QUOTA_INCREASE_STEP = 1048576;
    private long mAppCacheMaxSize;
    private final Context mContext;
    private DiskInfo mDiskInfo;
    private final long mGlobalLimit = getGlobalLimit();

    /* loaded from: classes.dex */
    public interface AppCacheInfo {
        long getAppCacheSizeBytes();
    }

    /* loaded from: classes.dex */
    public interface DiskInfo {
        long getFreeSpaceSizeBytes();

        long getTotalSizeBytes();
    }

    /* loaded from: classes.dex */
    public class StatFsDiskInfo implements DiskInfo {
        private StatFs mFs;

        public StatFsDiskInfo(String str) {
            this.mFs = new StatFs(str);
        }

        @Override // com.baidu.browser.explorer.WebStorageSizeManager.DiskInfo
        public long getFreeSpaceSizeBytes() {
            return this.mFs.getAvailableBlocks() * this.mFs.getBlockSize();
        }

        @Override // com.baidu.browser.explorer.WebStorageSizeManager.DiskInfo
        public long getTotalSizeBytes() {
            return this.mFs.getBlockCount() * this.mFs.getBlockSize();
        }
    }

    /* loaded from: classes.dex */
    public class WebKitAppCacheInfo implements AppCacheInfo {
        private static final String APPCACHE_FILE = "ApplicationCache.db";
        private String mAppCachePath;

        public WebKitAppCacheInfo(String str) {
            this.mAppCachePath = str;
        }

        @Override // com.baidu.browser.explorer.WebStorageSizeManager.AppCacheInfo
        public long getAppCacheSizeBytes() {
            return new File(String.valueOf(this.mAppCachePath) + File.separator + APPCACHE_FILE).length();
        }
    }

    public WebStorageSizeManager(Context context, DiskInfo diskInfo, AppCacheInfo appCacheInfo) {
        this.mContext = context;
        this.mDiskInfo = diskInfo;
        this.mAppCacheMaxSize = Math.max(this.mGlobalLimit / 4, appCacheInfo.getAppCacheSizeBytes());
    }

    public long getAppCacheMaxSize() {
        return this.mAppCacheMaxSize;
    }

    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, BdWebStorage.BdQuotaUpdater bdQuotaUpdater) {
        long j4 = (this.mGlobalLimit - j3) - this.mAppCacheMaxSize;
        if (j4 <= 0) {
            if (j3 > 0) {
                scheduleOutOfSpaceNotification();
            }
            bdQuotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j4 < j2) {
                j2 = 0;
            }
        } else {
            j2 = j + Math.min((long) QUOTA_INCREASE_STEP, j4);
        }
        bdQuotaUpdater.updateQuota(j2);
    }

    public void onReachedMaxAppCacheSize(long j, long j2, BdWebStorage.BdQuotaUpdater bdQuotaUpdater) {
        if ((this.mGlobalLimit - j2) - this.mAppCacheMaxSize < j + APPCACHE_MAXSIZE_PADDING) {
            if (j2 > 0) {
                scheduleOutOfSpaceNotification();
            }
            bdQuotaUpdater.updateQuota(0L);
            return;
        }
        this.mAppCacheMaxSize += j + APPCACHE_MAXSIZE_PADDING;
        bdQuotaUpdater.updateQuota(this.mAppCacheMaxSize);
    }

    private long getGlobalLimit() {
        return calculateGlobalLimit(this.mDiskInfo.getTotalSizeBytes(), this.mDiskInfo.getFreeSpaceSizeBytes());
    }

    static long calculateGlobalLimit(long j, long j2) {
        if (j <= 0 || j2 <= 0 || j2 > j) {
            return 0L;
        }
        long min = (long) Math.min(Math.floor(j / (2 << ((int) Math.floor(Math.log10(j / QUOTA_INCREASE_STEP))))), Math.floor(j2 / 2));
        if (min >= QUOTA_INCREASE_STEP) {
            return ((min % QUOTA_INCREASE_STEP == 0 ? 0 : 1) + (min / QUOTA_INCREASE_STEP)) * QUOTA_INCREASE_STEP;
        }
        return 0L;
    }

    private void scheduleOutOfSpaceNotification() {
        if (this.mContext == null) {
        }
    }
}
