package com.baidu.searchbox.http;

import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.model.MultipleConnectParams;
import com.baidu.searchbox.http.model.PreConnectParams;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkInfoRecord;
import com.baidu.searchbox.http.statistics.NetworkStat;
import java.util.List;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface IHttpContext {
    public static final IHttpContext EMPTY = new IHttpContext() { // from class: com.baidu.searchbox.http.IHttpContext.1
        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean forceHttpDnsIPv4OnlyInDualStack(HttpRequest httpRequest) {
            return false;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public List<HttpUrl> getBrAllowlist() {
            return null;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public IClientIPProvider getClientIPProvider() {
            return null;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public EventListener getEventListener() {
            return null;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public int getFallbackConnectDelayMs() {
            return 0;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public MultipleConnectParams getMultipleConnectParams() {
            return null;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public IHttpDns getNewCloneHttpDns(HttpRequest httpRequest) {
            return null;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public IHttpDns getNewHttpDns() {
            return null;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public NetworkStat<Request> getNewNetworkStat() {
            return null;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public PreConnectParams getPreConnectParams() {
            return null;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public String getSimOperator() {
            return null;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void init() {
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean isBrAllowlistEnabled() {
            return false;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean isNeedAuthenticateHeader4Tunnel(String str) {
            return false;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean isOldHttpUseTurbonet(String str, int i) {
            return false;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean isRttLogEnabled() {
            return false;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean ok4URLConnectionEnabled() {
            return false;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean okHttpPreConnectEnabled() {
            return false;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void prefetchDnsResult(String str) {
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord) {
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void uploadIllegalUrlBy850(JSONObject jSONObject) {
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public CookieManager getCookieManager(boolean z, boolean z2) {
            return CookieManager.WEBKIT_COOKIES;
        }
    };

    boolean forceHttpDnsIPv4OnlyInDualStack(HttpRequest httpRequest);

    List<HttpUrl> getBrAllowlist();

    IClientIPProvider getClientIPProvider();

    CookieManager getCookieManager(boolean z, boolean z2);

    EventListener getEventListener();

    int getFallbackConnectDelayMs();

    MultipleConnectParams getMultipleConnectParams();

    IHttpDns getNewCloneHttpDns(HttpRequest httpRequest);

    IHttpDns getNewHttpDns();

    NetworkStat<Request> getNewNetworkStat();

    PreConnectParams getPreConnectParams();

    String getSimOperator();

    void init();

    boolean isBrAllowlistEnabled();

    boolean isNeedAuthenticateHeader4Tunnel(String str);

    boolean isOldHttpUseTurbonet(String str, int i);

    boolean isRttLogEnabled();

    boolean ok4URLConnectionEnabled();

    boolean okHttpPreConnectEnabled();

    void prefetchDnsResult(String str);

    void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord);

    void uploadIllegalUrlBy850(JSONObject jSONObject);
}
