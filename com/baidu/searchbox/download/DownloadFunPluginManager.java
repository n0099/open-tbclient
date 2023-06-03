package com.baidu.searchbox.download;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.downloadcenter.service.IDownloadCenterFun;
import com.baidu.searchbox.plugins.annotation.PluginAccessable;
/* loaded from: classes3.dex */
public class DownloadFunPluginManager implements NoProGuard {
    public static final String APPSEARCH_DOWNLOAD_MERGE_KEY = "appsearch_download_merge";

    @PluginAccessable(methodName = "launchDownloadCenterActivity", paramClasses = {Context.class, boolean.class, String.class})
    public static boolean launchDownloadCenterActivity(Context context, boolean z, String str) {
        IDownloadCenterFun iDownloadCenterFun = (IDownloadCenterFun) ServiceManager.getService(IDownloadCenterFun.SERVICE_REFERENCE);
        if (iDownloadCenterFun == null) {
            return false;
        }
        return iDownloadCenterFun.startDownloadCenterActivity(context, z, str);
    }

    @PluginAccessable(methodName = "startDownload", paramClasses = {String.class, ContentValues.class, IDownloadListener.class})
    public static Uri startDownload(String str, ContentValues contentValues, IDownloadListener iDownloadListener) {
        return FileDownloader.startDownload(str, contentValues, iDownloadListener);
    }
}
