package com.baidu.searchbox.http.request;

import android.text.TextUtils;
import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.interceptor.LogInterceptor;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.net.Proxy;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class HttpRequestBuilder<T extends HttpRequestBuilder> {
    public int connectionTimeout;
    public CookieManager cookieManager;
    public boolean enableRetry;
    public JSONObject extraUserLog;
    public boolean followRedirects;
    public boolean followSslRedirects;
    public Headers.Builder headersBuilder;
    public AbstractHttpManager httpManager;
    public HttpUrl httpUrl;
    public boolean isReqNetStatEnable;
    public boolean isWifiOnly;
    public LogInterceptor.Level logLevel;
    public String logTag;
    public IAsyncRequestParamsHandler paramsHandler;
    public Proxy proxy;
    public int readTimeout;
    public int requestFrom;
    public int requestSubFrom;
    public Object tag;
    public int writeTimeout;

    public HttpRequestBuilder(AbstractHttpManager abstractHttpManager) {
        this.enableRetry = true;
        this.logTag = null;
        this.logLevel = null;
        this.isWifiOnly = false;
        this.requestFrom = 0;
        this.requestSubFrom = 0;
        this.followSslRedirects = true;
        this.followRedirects = true;
        this.httpManager = abstractHttpManager;
        this.headersBuilder = new Headers.Builder();
    }

    public T addHeader(String str, String str2) {
        this.headersBuilder.add(str, str2);
        return this;
    }

    public T addHeaders(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.headersBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    public T addUrlParam(String str, String str2) {
        HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
        newBuilder.addQueryParameter(str, str2);
        this.httpUrl = newBuilder.build();
        return this;
    }

    public T addUrlParams(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                newBuilder.addQueryParameter(entry.getKey(), entry.getValue());
            }
            this.httpUrl = newBuilder.build();
        }
        return this;
    }

    public T autoRetry(boolean z) {
        this.enableRetry = z;
        return this;
    }

    public abstract HttpRequest build();

    public T connectionTimeout(int i) {
        this.connectionTimeout = i;
        return this;
    }

    public T cookieManager(CookieManager cookieManager) {
        this.cookieManager = cookieManager;
        return this;
    }

    public T enableStat(boolean z) {
        this.isReqNetStatEnable = z;
        return this;
    }

    public T extraUserLog(JSONObject jSONObject) {
        this.extraUserLog = jSONObject;
        return this;
    }

    public T followRedirects(boolean z) {
        this.followRedirects = z;
        return this;
    }

    public T followSslRedirects(boolean z) {
        this.followSslRedirects = z;
        return this;
    }

    public T headers(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.headersBuilder.set(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    public T log(String str, LogInterceptor.Level level) {
        this.logTag = str;
        this.logLevel = level;
        return this;
    }

    public RequestCall makeRequestCall() {
        return build().makeRequestCall();
    }

    public T proxy(Proxy proxy) {
        this.proxy = proxy;
        return this;
    }

    public T readTimeout(int i) {
        this.readTimeout = i;
        return this;
    }

    public T removeHeader(String str) {
        this.headersBuilder.removeAll(str);
        return this;
    }

    public T removeHeaders(List<String> list) {
        if (list != null && list.size() > 0) {
            for (String str : list) {
                this.headersBuilder.removeAll(str);
            }
        }
        return this;
    }

    public T removeUrlParam(String str) {
        HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
        newBuilder.removeAllQueryParameters(str);
        this.httpUrl = newBuilder.build();
        return this;
    }

    public T removeUrlParams(List<String> list) {
        if (list != null && list.size() > 0) {
            HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
            for (String str : list) {
                newBuilder.removeAllQueryParameters(str);
            }
            this.httpUrl = newBuilder.build();
        }
        return this;
    }

    public T requestFrom(int i) {
        this.requestFrom = i;
        return this;
    }

    public T requestSubFrom(int i) {
        this.requestSubFrom = i;
        return this;
    }

    public T setHeader(String str, String str2) {
        this.headersBuilder.set(str, str2);
        return this;
    }

    public T setRequestParamsHandler(IAsyncRequestParamsHandler iAsyncRequestParamsHandler) {
        this.paramsHandler = iAsyncRequestParamsHandler;
        return this;
    }

    public T setUrlParam(String str, String str2) {
        HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
        newBuilder.setQueryParameter(str, str2);
        this.httpUrl = newBuilder.build();
        return this;
    }

    public T setUrlParams(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                newBuilder.setQueryParameter(entry.getKey(), entry.getValue());
            }
            this.httpUrl = newBuilder.build();
        }
        return this;
    }

    public T tag(Object obj) {
        this.tag = obj;
        return this;
    }

    public T url(String str) {
        this.httpUrl = HttpUrl.parse(str);
        return this;
    }

    public T userAgent(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.headersBuilder.set("User-Agent", str);
        }
        return this;
    }

    public T wifiOnly(boolean z) {
        this.isWifiOnly = z;
        return this;
    }

    public T writeTimeout(int i) {
        this.writeTimeout = i;
        return this;
    }

    public HttpRequestBuilder(HttpRequest httpRequest, AbstractHttpManager abstractHttpManager) {
        this.enableRetry = true;
        this.logTag = null;
        this.logLevel = null;
        this.isWifiOnly = false;
        this.requestFrom = 0;
        this.requestSubFrom = 0;
        this.followSslRedirects = true;
        this.followRedirects = true;
        if (abstractHttpManager != null) {
            this.httpManager = abstractHttpManager;
        } else {
            this.httpManager = httpRequest.httpManager;
        }
        this.httpUrl = httpRequest.httpUrl;
        this.tag = httpRequest.tag;
        Headers headers = httpRequest.headers;
        if (headers != null) {
            this.headersBuilder = headers.newBuilder();
        } else {
            this.headersBuilder = new Headers.Builder();
        }
        this.connectionTimeout = httpRequest.connectionTimeout;
        this.readTimeout = httpRequest.readTimeout;
        this.writeTimeout = httpRequest.writeTimeout;
        this.enableRetry = httpRequest.enableRetry;
        this.isWifiOnly = httpRequest.isWifiOnly;
        this.logLevel = httpRequest.logLevel;
        this.logTag = httpRequest.logTag;
        this.cookieManager = httpRequest.cookieManager;
        this.paramsHandler = httpRequest.paramsHandler;
        this.isReqNetStatEnable = httpRequest.isReqNetStatEnable;
        this.requestFrom = httpRequest.requestFrom;
        this.requestSubFrom = httpRequest.requestSubFrom;
        this.extraUserLog = httpRequest.extraUserLog;
        this.proxy = httpRequest.proxy;
        this.followRedirects = httpRequest.followRedirects;
        this.followSslRedirects = httpRequest.followSslRedirects;
    }
}
