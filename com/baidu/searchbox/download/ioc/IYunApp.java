package com.baidu.searchbox.download.ioc;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public interface IYunApp {
    public static final IYunApp EMPTY = new IYunApp() { // from class: com.baidu.searchbox.download.ioc.IYunApp.1
        @Override // com.baidu.searchbox.download.ioc.IYunApp
        public String encodeUrl(String str) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IYunApp
        public String getHashedString(String str) {
            return null;
        }

        @Override // com.baidu.searchbox.download.ioc.IYunApp
        public void loadUrl(Context context, String str, boolean z, boolean z2) {
        }

        @Override // com.baidu.searchbox.download.ioc.IYunApp
        public void openNetDiskBySwan(String str) {
        }

        @Override // com.baidu.searchbox.download.ioc.IYunApp
        public void openNetDiskHomePage(String str) {
        }
    };
    public static final String LOG_TAG = "IYunApp";

    String encodeUrl(String str);

    String getHashedString(String str);

    void loadUrl(Context context, String str, boolean z, boolean z2);

    void openNetDiskBySwan(String str);

    void openNetDiskHomePage(String str);

    /* loaded from: classes3.dex */
    public static final class Impl {
        public static IYunApp sIYunApp = DownloadRuntime.getYunApp();

        @NonNull
        public static IYunApp get() {
            if (sIYunApp == null) {
                Log.w(IYunApp.LOG_TAG, "Fetch IYunApp implementation failed, IYunApp.EMPTY applied");
                sIYunApp = IYunApp.EMPTY;
            }
            return sIYunApp;
        }
    }
}
