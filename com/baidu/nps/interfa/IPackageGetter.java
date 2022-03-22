package com.baidu.nps.interfa;

import com.baidu.nps.pm.IBundleInfo;
import java.util.List;
/* loaded from: classes4.dex */
public interface IPackageGetter {
    void downloadBundle(IBundleInfo iBundleInfo, String str, int i, IPackageDownloadCallback iPackageDownloadCallback);

    void getBundleInfo(List<IBundleInfo> list, IPackageGetCallback iPackageGetCallback);
}
