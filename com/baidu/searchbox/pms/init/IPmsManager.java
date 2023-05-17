package com.baidu.searchbox.pms.init;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DownloadCallback;
import com.baidu.searchbox.pms.download.DownloadManager;
import com.baidu.searchbox.pms.download.DownloadOptions;
import com.baidu.searchbox.pms.download.IDownloadManager;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public interface IPmsManager {
    public static final IPmsManager EMPTY = new IPmsManager() { // from class: com.baidu.searchbox.pms.init.IPmsManager.1
        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public void deletePackageInfo(String str, String str2) {
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public void execute(RequestParams requestParams) {
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public Map<String, PackageInfo> getPackageInfo(String str, String str2) {
            return null;
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public boolean isInDegradeList(String str, String str2) {
            return false;
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        public int resetUpdateVersion(String str, List<String> list) {
            return 0;
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        @NonNull
        public IDownloadManager download(@NonNull PackageInfo packageInfo, @Nullable DownloadOptions downloadOptions, @Nullable DownloadCallback downloadCallback) {
            return DownloadManager.getInstance();
        }

        @Override // com.baidu.searchbox.pms.init.IPmsManager
        @NonNull
        public IDownloadManager download(@NonNull List<PackageInfo> list, @Nullable DownloadOptions downloadOptions, @Nullable DownloadCallback downloadCallback) {
            return DownloadManager.getInstance();
        }
    };

    void deletePackageInfo(String str, String str2);

    @NonNull
    IDownloadManager download(@NonNull PackageInfo packageInfo, @Nullable DownloadOptions downloadOptions, @Nullable DownloadCallback downloadCallback);

    @NonNull
    IDownloadManager download(@NonNull List<PackageInfo> list, @Nullable DownloadOptions downloadOptions, @Nullable DownloadCallback downloadCallback);

    void execute(RequestParams requestParams);

    Map<String, PackageInfo> getPackageInfo(String str, String str2);

    boolean isInDegradeList(String str, String str2);

    int resetUpdateVersion(String str, List<String> list);
}
