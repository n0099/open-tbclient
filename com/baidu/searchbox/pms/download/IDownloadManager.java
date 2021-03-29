package com.baidu.searchbox.pms.download;

import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DownloadCallback;
import java.util.List;
/* loaded from: classes2.dex */
public interface IDownloadManager {
    public static final IDownloadManager EMPTY = new IDownloadManager() { // from class: com.baidu.searchbox.pms.download.IDownloadManager.1
        @Override // com.baidu.searchbox.pms.download.IDownloadManager
        public void cancel(PackageInfo packageInfo) {
        }

        @Override // com.baidu.searchbox.pms.download.IDownloadManager
        public int getStatus(PackageInfo packageInfo) {
            return 0;
        }

        @Override // com.baidu.searchbox.pms.download.IDownloadManager
        public void pause(PackageInfo packageInfo) {
        }

        @Override // com.baidu.searchbox.pms.download.IDownloadManager
        public void resume(PackageInfo packageInfo) {
        }

        @Override // com.baidu.searchbox.pms.download.IDownloadManager
        public void start(List<PackageInfo> list, DownloadOptions downloadOptions, DownloadCallback downloadCallback) {
        }
    };

    void cancel(PackageInfo packageInfo);

    int getStatus(PackageInfo packageInfo);

    void pause(PackageInfo packageInfo);

    void resume(PackageInfo packageInfo);

    void start(List<PackageInfo> list, DownloadOptions downloadOptions, DownloadCallback downloadCallback);
}
