package com.baidu.searchbox.network;

import com.baidu.searchbox.network.cookie.CookieManager;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.connect.IHttpDelegator;
import com.baidu.searchbox.network.request.HttpRequest;
import com.baidu.searchbox.network.statistics.NetworkInfoRecord;
import com.baidu.searchbox.network.statistics.NetworkStat;
/* loaded from: classes15.dex */
public interface IHttpContext {
    public static final IHttpContext EMPTY = new IHttpContext() { // from class: com.baidu.searchbox.network.IHttpContext.1
        @Override // com.baidu.searchbox.network.IHttpContext
        public void init(AbstractHttpManager abstractHttpManager) {
        }

        @Override // com.baidu.searchbox.network.IHttpContext
        public IHttpDns getNewHttpDns() {
            return null;
        }

        @Override // com.baidu.searchbox.network.IHttpContext
        public IHttpDns getNewCloneStatHttpDns(HttpRequest httpRequest) {
            return null;
        }

        @Override // com.baidu.searchbox.network.IHttpContext
        public void prefetchDnsResult(String str) {
        }

        @Override // com.baidu.searchbox.network.IHttpContext
        public void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord) {
        }

        @Override // com.baidu.searchbox.network.IHttpContext
        public NetworkStat<Request> getNewNetworkStat() {
            return null;
        }

        @Override // com.baidu.searchbox.network.IHttpContext
        public IHttpDelegator getCronetHttpDelegator() {
            return null;
        }

        @Override // com.baidu.searchbox.network.IHttpContext
        public CookieManager getCookieManager(boolean z, boolean z2) {
            return CookieManager.WEBKIT_COOKIES;
        }

        @Override // com.baidu.searchbox.network.IHttpContext
        public boolean isPreconnectEnable() {
            return false;
        }

        @Override // com.baidu.searchbox.network.IHttpContext
        public boolean isNQEEnable() {
            return false;
        }
    };

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
