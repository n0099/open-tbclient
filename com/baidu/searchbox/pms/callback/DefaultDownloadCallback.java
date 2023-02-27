package com.baidu.searchbox.pms.callback;

import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class DefaultDownloadCallback implements DownloadCallback {
    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onBulkDownloaded(List<PackageInfo> list, List<PackageInfo> list2, List<PackageInfo> list3) {
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadCancel(PackageInfo packageInfo) {
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadError(PackageInfo packageInfo, ErrorInfo errorInfo) {
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadPause(PackageInfo packageInfo) {
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadProgress(PackageInfo packageInfo, long j, long j2) {
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadResume(PackageInfo packageInfo, long j, long j2) {
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadStart(PackageInfo packageInfo) {
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
    }
}
