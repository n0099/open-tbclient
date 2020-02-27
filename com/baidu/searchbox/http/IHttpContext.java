package com.baidu.searchbox.http;

import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkInfoRecord;
import com.baidu.searchbox.http.statistics.NetworkStat;
import okhttp3.Interceptor;
import okhttp3.Request;
/* loaded from: classes13.dex */
public interface IHttpContext {
    boolean forceHttpDnsIPv4OnlyInDualStack(HttpRequest httpRequest);

    CookieManager getCookieManager(boolean z, boolean z2);

    IHttpDns getNewCloneHttpDns(HttpRequest httpRequest);

    IHttpDns getNewHttpDns();

    Interceptor getNewNetworkInterceptor();

    NetworkStat<Request> getNewNetworkStat();

    void init();

    void prefetchDnsResult(String str);

    void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord);
}
