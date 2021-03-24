package com.baidu.searchbox.pms.callback;

import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import java.util.List;
/* loaded from: classes.dex */
public interface DownloadCallback {
    void onBulkDownloaded(List<PackageInfo> list, List<PackageInfo> list2, List<PackageInfo> list3);

    void onDownloadCancel(PackageInfo packageInfo);

    void onDownloadError(PackageInfo packageInfo, ErrorInfo errorInfo);

    void onDownloadPause(PackageInfo packageInfo);

    void onDownloadProgress(PackageInfo packageInfo, long j, long j2);

    void onDownloadResume(PackageInfo packageInfo, long j, long j2);

    void onDownloadStart(PackageInfo packageInfo);

    void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo);
}
