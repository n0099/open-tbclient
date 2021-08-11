package com.baidu.nps.interfa;

import com.baidu.nps.pm.IBundleInfo;
import java.util.List;
/* loaded from: classes5.dex */
public interface IPackageGetter {
    void downloadBundle(IBundleInfo iBundleInfo, String str, int i2, IPackageDownloadCallback iPackageDownloadCallback);

    void getBundleInfo(List<IBundleInfo> list, IPackageGetCallback iPackageGetCallback);
}
