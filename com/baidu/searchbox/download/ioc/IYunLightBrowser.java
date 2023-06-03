package com.baidu.searchbox.download.ioc;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public interface IYunLightBrowser {
    public static final IYunLightBrowser EMPTY = new IYunLightBrowser() { // from class: com.baidu.searchbox.download.ioc.IYunLightBrowser.1
        @Override // com.baidu.searchbox.download.ioc.IYunLightBrowser
        public void startLightBrowserActivity(Context context, String str, boolean z) {
        }
    };
    public static final String LOG_TAG = "IYunLightBrowser";

    void startLightBrowserActivity(Context context, String str, boolean z);

    /* loaded from: classes3.dex */
    public static final class Impl {
        public static IYunLightBrowser sIYunLightBrowser = DownloadRuntime.getYunLightbrowser();

        @NonNull
        public static IYunLightBrowser get() {
            if (sIYunLightBrowser == null) {
                Log.w(IYunLightBrowser.LOG_TAG, "Fetch IYunLightBrowser implementation failed, IYunLightBrowser.EMPTY applied");
                sIYunLightBrowser = IYunLightBrowser.EMPTY;
            }
            return sIYunLightBrowser;
        }
    }
}
