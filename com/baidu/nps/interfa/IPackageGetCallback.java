package com.baidu.nps.interfa;

import com.baidu.nps.pm.IBundleInfo;
import java.util.List;
/* loaded from: classes3.dex */
public interface IPackageGetCallback {
    void onBundleInfoGetFail(int i, String str);

    void onBundleInfoGetSuccess(List<IBundleInfo> list);
}
