package com.baidu.searchbox.downloads;

import android.content.Context;
import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.ioc.IDownloadApp;
/* loaded from: classes3.dex */
public class DSUtils {
    public static final String TAG = "DSUtils";
    public static boolean hasStartAutoBack;
    public static volatile int mCurrentThreadNum;

    public static void stopServices(Context context) {
        if (context == null) {
        }
    }

    public static void startDownloadServices(Context context) {
        if (context == null) {
            return;
        }
        UiThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.downloads.DSUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!DSUtils.hasStartAutoBack) {
                        boolean unused = DSUtils.hasStartAutoBack = true;
                        IDownloadApp.Impl.get().startAutoBackup();
                        IDownloadApp.Impl.get().checkUnfinishedTask();
                    }
                    DownloadService.getInstance().start();
                } catch (IllegalStateException e) {
                    if (AppConfig.isDebug()) {
                        Log.e(DSUtils.TAG, e.getMessage());
                    }
                } catch (Exception e2) {
                    if (AppConfig.isDebug()) {
                        Log.e(DSUtils.TAG, e2.getMessage());
                    }
                }
            }
        });
    }
}
