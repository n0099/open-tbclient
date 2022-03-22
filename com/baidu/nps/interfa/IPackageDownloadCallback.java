package com.baidu.nps.interfa;
/* loaded from: classes4.dex */
public interface IPackageDownloadCallback {
    void onPackageDownloadFail(String str, int i, String str2);

    void onPackageDownloadSuccess(String str, String str2);

    void onProgress(long j, long j2);
}
