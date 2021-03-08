package com.baidu.live.adp.lib.lbs;

import com.baidu.live.adp.lib.lbs.BdLocationMananger;
/* loaded from: classes10.dex */
public interface ILocationProvider {
    void destroy();

    void init(BdLocationMananger.ProviderCallBack providerCallBack);

    void startLocation(boolean z);

    void stopLocation();
}
