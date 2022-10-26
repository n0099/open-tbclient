package com.baidu.nps.interfa;

import java.util.List;
/* loaded from: classes2.dex */
public interface IPackageGetCallback {
    void onBundleInfoGetFail(int i, String str);

    void onBundleInfoGetSuccess(List list);
}
