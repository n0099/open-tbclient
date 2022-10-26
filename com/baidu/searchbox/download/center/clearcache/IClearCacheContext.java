package com.baidu.searchbox.download.center.clearcache;

import android.content.Context;
import com.baidu.searchbox.download.center.clearcache.DiskManager;
import java.util.List;
/* loaded from: classes2.dex */
public interface IClearCacheContext {
    void addClearCache(List list);

    void cleanCacheMonitorUBC(String str);

    void clearHistoryFile();

    List getAppFileList();

    BaseClearCache getDownloadClearCache();

    List getUserAssetFileList();

    void notifyDiskLevelChanged(DiskManager.NotifyLevel notifyLevel, DiskManager.DiskLevel diskLevel, DiskManager.DiskLevel diskLevel2);

    void notifyPersonalClearCacheTipsChange();

    void registerBackForegroundEvent();

    void registerDiskUsageLevelChangedObserver();

    void startDownloadActivity(Context context);
}
