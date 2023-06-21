package com.baidu.searchbox.downloads;

import android.content.Intent;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.ioc.IDownloadDownloadCenter;
import com.baidu.searchbox.download.unified.DownloadParams;
import com.baidu.tieba.x20;
/* loaded from: classes3.dex */
public class DownloadMessageSender {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "DownloadMessageSender";

    public static void logDownloadFail(String str, String str2, int i, String str3, String str4, int i2, boolean z, String str5) {
        if (DEBUG) {
            Log.e(TAG, "logDownloadStart 手百下载失败 fileName=" + str + "\\n mimeType=" + str2 + "\\n status=" + i + "\\n url=" + str3 + "\\n referer=" + str4 + "\\n redirectCount=" + i2 + "\\n countRetry=" + z + "\\nextraInfo=" + str5);
        }
        x20.m(str, str2, i, str3, str4, i2, z, str5);
    }

    public static void logDownloadStart(String str, String str2, String str3) {
        if (DEBUG) {
            Log.e(TAG, "logDownloadStart 开始下载的fileName=" + str);
        }
        x20.v(str, str2, str3);
    }

    public static void sendBeginMessage(String str, DownloadParams downloadParams) {
        try {
            Intent intent = new Intent(DownloadConstants.ACTION_DOWNLOAD_BEGIN);
            intent.setPackage(AppRuntime.getApplication().getPackageName());
            intent.putExtra(DownloadConstants.DOWNLOAD_PARAMS, downloadParams);
            intent.putExtra(DownloadConstants.DOWNLOAD_SOURCE, str);
            AppRuntime.getApplication().sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }

    public static void sendBeginMsg(int i) {
        Intent intent = new Intent(DownloadConstants.ACTION_DOWNLOAD_BEGIN);
        intent.setPackage(AppRuntime.getApplication().getPackageName());
        intent.putExtra("type", i);
        AppRuntime.getApplication().sendBroadcast(intent);
        if (i == 3) {
            IDownloadDownloadCenter.Impl.get().invokeCommonAppDownload();
        }
        if (DEBUG) {
            Log.e(TAG, "开始下载的广播 type=" + i);
        }
    }
}
