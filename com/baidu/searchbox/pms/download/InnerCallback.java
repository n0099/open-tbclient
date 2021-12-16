package com.baidu.searchbox.pms.download;

import com.baidu.searchbox.pms.bean.PackageInfo;
/* loaded from: classes10.dex */
public interface InnerCallback {
    void onCancel(PackageInfo packageInfo);

    void onError(PackageInfo packageInfo, int i2, String str);

    void onPause(PackageInfo packageInfo);

    void onProgress(PackageInfo packageInfo, long j2, long j3);

    void onResume(PackageInfo packageInfo);

    void onRetry(PackageInfo packageInfo);

    void onStart(PackageInfo packageInfo);

    void onSuccess(PackageInfo packageInfo);
}
