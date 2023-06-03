package com.baidu.searchbox.downloads.filter;

import android.content.Context;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBC;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class DownloadFilterManager {
    public static boolean DEBUG = AppConfig.isDebug();
    public static String TAG = DownloadFilterManager.class.getSimpleName();
    public static String DOWNLOAD_FILTER_STAT_KEY = "381";

    public static boolean apkDownloadFilter(Context context, DownloadDataInfo downloadDataInfo, DownloadFilter downloadFilter) {
        String str;
        if (downloadDataInfo == null) {
            return true;
        }
        if (downloadFilter == null) {
            return false;
        }
        boolean filter = downloadFilter.filter(downloadDataInfo);
        HashMap hashMap = new HashMap();
        hashMap.put("from", "basic");
        hashMap.put("type", "load");
        hashMap.put("pageurl", downloadDataInfo.pageUrl);
        hashMap.put("fileurl", downloadDataInfo.url);
        hashMap.put("appname", downloadDataInfo.filename);
        if (filter) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("filter", str);
        UBC.onEvent(DOWNLOAD_FILTER_STAT_KEY, hashMap);
        return filter;
    }
}
