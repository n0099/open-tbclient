package com.baidu.searchbox.http;

import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkInfoRecord;
import com.baidu.searchbox.http.statistics.NetworkStat;
import okhttp3.EventListener;
import okhttp3.Request;
/* loaded from: classes6.dex */
public interface IHttpContext {
    public static final IHttpContext EMPTY = new IHttpContext() { // from class: com.baidu.searchbox.http.IHttpContext.1
        @Override // com.baidu.searchbox.http.IHttpContext
        public void init() {
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public IHttpDns getNewHttpDns() {
            return null;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public IHttpDns getNewCloneHttpDns(HttpRequest httpRequest) {
            return null;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void prefetchDnsResult(String str) {
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public NetworkStat<Request> getNewNetworkStat() {
            return null;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord) {
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public CookieManager getCookieManager(boolean z, boolean z2) {
            return CookieManager.WEBKIT_COOKIES;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean forceHttpDnsIPv4OnlyInDualStack(HttpRequest httpRequest) {
            return false;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public int getFallbackConnectDelayMs() {
            return 0;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public EventListener getEventListener() {
            return null;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public IClientIPProvider getClientIPProvider() {
            return null;
        }
    };

    boolean forceHttpDnsIPv4OnlyInDualStack(HttpRequest httpRequest);

    IClientIPProvider getClientIPProvider();

    CookieManager getCookieManager(boolean z, boolean z2);

    EventListener getEventListener();

    int getFallbackConnectDelayMs();

    IHttpDns getNewCloneHttpDns(HttpRequest httpRequest);

    IHttpDns getNewHttpDns();

    NetworkStat<Request> getNewNetworkStat();

    void init();

    void prefetchDnsResult(String str);

    void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord);
}
