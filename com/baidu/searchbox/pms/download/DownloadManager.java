package com.baidu.searchbox.pms.download;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes3.dex */
public class DownloadManager {
    public static IDownloadManager sDownloadManager;

    @Inject(force = false)
    public static IDownloadManager getInstance() {
        if (sDownloadManager == null) {
            sDownloadManager = IDownloadManager.EMPTY;
        }
        return DownloadManagerImpl_Factory.get();
    }

    public static void setDownloadManager(IDownloadManager iDownloadManager) {
        sDownloadManager = iDownloadManager;
    }
}
