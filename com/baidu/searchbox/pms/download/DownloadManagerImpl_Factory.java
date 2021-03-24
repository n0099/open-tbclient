package com.baidu.searchbox.pms.download;
/* loaded from: classes3.dex */
public class DownloadManagerImpl_Factory {
    public static volatile DownloadManagerImpl instance;

    public static synchronized DownloadManagerImpl get() {
        DownloadManagerImpl downloadManagerImpl;
        synchronized (DownloadManagerImpl_Factory.class) {
            if (instance == null) {
                instance = new DownloadManagerImpl();
            }
            downloadManagerImpl = instance;
        }
        return downloadManagerImpl;
    }
}
