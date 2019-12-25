package com.baidu.live.adp.lib.lbs;

import com.baidu.live.adp.lib.lbs.BdLocationMananger;
/* loaded from: classes2.dex */
public interface ILocationProvider {
    void destroy();

    void init(BdLocationMananger.ProviderCallBack providerCallBack);

    void startLocation(boolean z);

    void stopLocation();
}
