package com.baidu.searchbox.pms.download;

import com.baidu.searchbox.pms.bean.PackageInfo;
/* loaded from: classes2.dex */
public interface InnerCallback {
    void onCancel(PackageInfo packageInfo);

    void onError(PackageInfo packageInfo, int i, String str);

    void onPause(PackageInfo packageInfo);

    void onProgress(PackageInfo packageInfo, long j, long j2);

    void onResume(PackageInfo packageInfo);

    void onRetry(PackageInfo packageInfo);

    void onStart(PackageInfo packageInfo);

    void onSuccess(PackageInfo packageInfo);
}
