package com.baidu.live.tbadk.apk;
/* loaded from: classes4.dex */
public interface ApkStatusCallback {
    void onApkDownloadFailed(ApkData apkData, int i, String str);

    void onApkDownloadProgress(long j, long j2);

    void onApkDownloadStart(ApkData apkData);

    void onApkDownloadSucceed(ApkData apkData);

    void onApkStartInstall(ApkData apkData);

    void onJoinDownloadQueue();
}
