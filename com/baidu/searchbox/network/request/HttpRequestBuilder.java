package com.baidu.searchbox.network.request;

import android.text.TextUtils;
import com.baidu.searchbox.network.AbstractHttpManager;
import com.baidu.searchbox.network.cookie.CookieManager;
import com.baidu.searchbox.network.core.Headers;
import com.baidu.searchbox.network.core.HttpUrl;
import com.baidu.searchbox.network.core.internal.Util;
import com.baidu.searchbox.network.interceptor.LogInterceptor;
import com.baidu.searchbox.network.request.HttpRequestBuilder;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public abstract class HttpRequestBuilder<T extends HttpRequestBuilder> {
    protected int connectionTimeout;
    protected CookieManager cookieManager;
    protected JSONObject extraUserLog;
    protected boolean followRedirects;
    protected Headers.Builder headersBuilder;
    protected AbstractHttpManager httpManager;
    protected HttpUrl httpUrl;
    protected boolean isReqNetStatEnable;
    protected boolean isWifiOnly;
    protected LogInterceptor.Level logLevel;
    protected String logTag;
    protected IAsyncRequestParamsHandler paramsHandler;
    protected int readTimeout;
    protected int requestFrom;
    protected Object tag;

    public abstract HttpRequest build();

    public HttpRequestBuilder(AbstractHttpManager abstractHttpManager) {
        this.followRedirects = true;
        this.logTag = null;
        this.logLevel = null;
        this.isWifiOnly = false;
        this.requestFrom = 0;
        this.httpManager = abstractHttpManager;
        this.headersBuilder = new Headers.Builder();
        if (abstractHttpManager != null) {
            this.connectionTimeout = abstractHttpManager.getRequestClient().connectTimeoutMillis();
            this.readTimeout = abstractHttpManager.getRequestClient().readTimeoutMillis();
        }
    }

    public HttpRequestBuilder(HttpRequest httpRequest, AbstractHttpManager abstractHttpManager) {
        this.followRedirects = true;
        this.logTag = null;
        this.logLevel = null;
        this.isWifiOnly = false;
        this.requestFrom = 0;
        if (abstractHttpManager != null) {
            this.httpManager = abstractHttpManager;
        } else {
            this.httpManager = httpRequest.httpManager;
        }
        this.httpUrl = httpRequest.httpUrl;
        this.tag = httpRequest.tag;
        if (httpRequest.headers != null) {
            this.headersBuilder = httpRequest.headers.newBuilder();
        } else {
            this.headersBuilder = new Headers.Builder();
        }
        this.connectionTimeout = httpRequest.connectionTimeout;
        this.readTimeout = httpRequest.readTimeout;
        this.isWifiOnly = httpRequest.isWifiOnly;
        this.logLevel = httpRequest.logLevel;
        this.logTag = httpRequest.logTag;
        this.cookieManager = httpRequest.cookieManager;
        this.paramsHandler = httpRequest.paramsHandler;
        this.isReqNetStatEnable = httpRequest.isReqNetStatEnable;
        this.requestFrom = httpRequest.requestFrom;
        this.extraUserLog = httpRequest.extraUserLog;
    }

    public RequestCall makeRequestCall() {
        return build().makeRequestCall();
    }

    public T connectionTimeout(int i) {
        this.connectionTimeout = Util.checkDuration("timeout", i, TimeUnit.MILLISECONDS);
        return this;
    }

    public T readTimeout(int i) {
        this.readTimeout = Util.checkDuration("timeout", i, TimeUnit.MILLISECONDS);
        return this;
    }

    public T url(String str) {
        this.httpUrl = HttpUrl.parse(str);
        return this;
    }

    public T setRequestParamsHandler(IAsyncRequestParamsHandler iAsyncRequestParamsHandler) {
        this.paramsHandler = iAsyncRequestParamsHandler;
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

    public T addUrlParam(String str, String str2) {
        HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
        newBuilder.addQueryParameter(str, str2);
        this.httpUrl = newBuilder.build();
        return this;
    }

    public T setUrlParam(String str, String str2) {
        HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
        newBuilder.setQueryParameter(str, str2);
        this.httpUrl = newBuilder.build();
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

    public T followRedirects(boolean z) {
        this.followRedirects = z;
        return this;
    }

    public T tag(Object obj) {
        this.tag = obj;
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

    public T addHeaders(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.headersBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    public T addHeader(String str, String str2) {
        this.headersBuilder.add(str, str2);
        return this;
    }

    public T setHeader(String str, String str2) {
        this.headersBuilder.set(str, str2);
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

    public T userAgent(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.headersBuilder.set("User-Agent", str);
        }
        return this;
    }

    public T log(String str, LogInterceptor.Level level) {
        this.logTag = str;
        this.logLevel = level;
        return this;
    }

    public T cookieManager(CookieManager cookieManager) {
        this.cookieManager = cookieManager;
        return this;
    }

    public T wifiOnly(boolean z) {
        this.isWifiOnly = z;
        return this;
    }

    public T enableStat(boolean z) {
        this.isReqNetStatEnable = z;
        return this;
    }

    public T requestFrom(int i) {
        this.requestFrom = i;
        return this;
    }

    public T extraUserLog(JSONObject jSONObject) {
        this.extraUserLog = jSONObject;
        return this;
    }
}
