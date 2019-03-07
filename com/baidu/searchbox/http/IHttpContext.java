package com.baidu.searchbox.http;

import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkInfoRecord;
import okhttp3.Interceptor;
/* loaded from: classes2.dex */
public interface IHttpContext {
    IHttpDns getNewCloneHttpDns(HttpRequest httpRequest);

    IHttpDns getNewHttpDns();

    Interceptor getNewNetworkInterceptor();

    void init();

    void prefetchDnsResult(String str);

    void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord);

    /* loaded from: classes2.dex */
    public static class DefaultHttpContextImpl implements IHttpContext {
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
        public Interceptor getNewNetworkInterceptor() {
            return null;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void prefetchDnsResult(String str) {
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord) {
        }
    }
}
