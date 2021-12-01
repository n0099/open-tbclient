package com.baidu.nps.interfa;
/* loaded from: classes8.dex */
public interface IPackageDownloadCallback {
    void onPackageDownloadFail(String str, int i2, String str2);

    void onPackageDownloadSuccess(String str, String str2);

    void onProgress(long j2, long j3);
}
