package com.baidu.searchbox.network;

import com.baidu.searchbox.network.cookie.CookieManager;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.connect.IHttpDelegator;
import com.baidu.searchbox.network.request.HttpRequest;
import com.baidu.searchbox.network.statistics.NetworkInfoRecord;
import com.baidu.searchbox.network.statistics.NetworkStat;
/* loaded from: classes12.dex */
public interface IHttpContext {
    CookieManager getCookieManager(boolean z, boolean z2);

    IHttpDelegator getCronetHttpDelegator();

    IHttpDns getNewCloneStatHttpDns(HttpRequest httpRequest);

    IHttpDns getNewHttpDns();

    NetworkStat<Request> getNewNetworkStat();

    void init(AbstractHttpManager abstractHttpManager);

    boolean isNQEEnable();

    boolean isPreconnectEnable();

    void prefetchDnsResult(String str);

    void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord);
}
