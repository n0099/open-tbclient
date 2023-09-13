package com.baidu.cyberplayer.sdk.videodownload;

import com.baidu.cyberplayer.sdk.CyberPlayerCoreInvoker;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.remote.PrefetchOptions;
import com.baidu.cyberplayer.sdk.remote.RemoteDownloaderProxy;
/* loaded from: classes3.dex */
public class DownloaderProviderFactor {
    public static final String TAG = "DownloadProviderFactory";
    public static DownloaderProviderFactor sFactory;

    public static synchronized DownloaderProviderFactor getInstance() {
        DownloaderProviderFactor downloaderProviderFactor;
        synchronized (DownloaderProviderFactor.class) {
            if (sFactory == null) {
                sFactory = new DownloaderProviderFactor();
            }
            downloaderProviderFactor = sFactory;
        }
        return downloaderProviderFactor;
    }

    public DownloaderProvider create(int i, String str, PrefetchOptions prefetchOptions, boolean z) {
        if (z && !CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_REMOTE_FORBIDDEN, false)) {
            return RemoteDownloaderProxy.create(i, str, prefetchOptions);
        }
        return CyberPlayerCoreInvoker.createCyberDownloader(i, str, prefetchOptions);
    }
}
