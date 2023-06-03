package com.baidu.searchbox.download.ioc;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.config.AppConfig;
@Autowired
/* loaded from: classes3.dex */
public class DownloadRuntime {
    public static final boolean GLOBAL_DEBUG = AppConfig.isDebug();
    public static final String TAG = "DownloadRuntime";

    @Inject(force = false)
    public static IDownloadApp getDownloadApp() {
        return IDownloadApp.EMPTY;
    }

    @Inject(force = false)
    public static IDownloadDownloadCenter getDownloadDownloadCenter() {
        return IDownloadDownloadCenter.EMPTY;
    }

    @Inject(force = false)
    public static IDownloadSetting getDownloadSetting() {
        return IDownloadSetting.EMPTY;
    }

    @Inject(force = false)
    public static IYunApp getYunApp() {
        return IYunApp.EMPTY;
    }

    @Inject(force = false)
    public static IYunLightBrowser getYunLightbrowser() {
        return IYunLightBrowser.EMPTY;
    }
}
