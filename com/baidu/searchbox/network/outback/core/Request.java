package com.baidu.searchbox.network.outback.core;

import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.network.outback.Cancelable;
import com.baidu.searchbox.network.outback.ConnectManager;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.searchbox.network.outback.OutbackComponent;
import com.baidu.searchbox.network.outback.callback.ResponseCallback;
import com.baidu.searchbox.network.outback.cookie.CookieManager;
import com.baidu.searchbox.network.outback.core.Headers;
import com.baidu.searchbox.network.outback.core.HttpUrl;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.searchbox.network.outback.request.RequestCall;
import com.baidu.searchbox.network.outback.statistics.DoRecordManager;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.searchbox.network.outback.statistics.RequestCallException;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Request {
    public static final int REQUESTFROM_FEED = 1;
    public static final int REQUESTFROM_FRESCO = 2;
    public static final int REQUESTFROM_NONE = 0;
    public static final int REQUESTFROM_UBC = 3;
    public String bdTraceId;
    @Nullable
    public final RequestBody body;
    public Map<String, CallFactory> callFactoryMap;
    public int connectionTimeout;
    public CookieManager cookieManager;
    public JSONObject extraUserLog;
    public boolean followRedirects;
    public boolean followSslRedirects;
    public final Headers headers;
    public boolean isWifiOnly;
    public String logTag;
    public final String method;
    public Object originTag;
    public int readTimeout;
    public final NetworkStatRecord record;
    public int requestFrom;
    public int requestSubFrom;
    public final Map<Class<?>, Object> tags;
    public final UrlWrapper url;
    public int writeTimeout;

    /* loaded from: classes2.dex */
    public static class Builder<R extends Builder> {
        public String bdTraceId;
        @Nullable
        public RequestBody body;
        public Map<String, CallFactory> callFactoryMap;
        public int connectionTimeout;
        public CookieManager cookieManager;
        public boolean enableBrotli;
        public JSONObject extraUserLog;
        public boolean followRedirects;
        public boolean followSslRedirects;
        public Headers.Builder headers;
        public boolean isWifiOnly;
        public String logTag;
        public String method;
        public int readTimeout;
        public NetworkStatRecord record;
        public int requestFrom;
        public int requestSubFrom;
        public Map<Class<?>, Object> tags;
        @Nullable
        public UrlWrapper url;
        public int writeTimeout;

        public Builder(Request request) {
            Map<Class<?>, Object> linkedHashMap;
            this.connectionTimeout = -1;
            this.readTimeout = -1;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.logTag = null;
            this.isWifiOnly = false;
            this.requestFrom = 0;
            this.requestSubFrom = 0;
            this.tags = Collections.emptyMap();
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            if (request.tags.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(request.tags);
            }
            this.tags = linkedHashMap;
            this.headers = request.headers.newBuilder();
            this.connectionTimeout = request.connectionTimeout;
            this.readTimeout = request.readTimeout;
            this.writeTimeout = request.writeTimeout;
            this.followRedirects = request.followRedirects;
            this.logTag = request.logTag;
            this.isWifiOnly = request.isWifiOnly;
            this.cookieManager = request.cookieManager;
            this.requestFrom = request.requestFrom;
            this.requestSubFrom = request.requestSubFrom;
            this.extraUserLog = request.extraUserLog;
            this.callFactoryMap = request.callFactoryMap;
            this.record = request.getNetworkStatRecord();
            this.bdTraceId = request.getBdTraceId();
        }

        public Builder(Map<String, CallFactory> map) {
            this.connectionTimeout = -1;
            this.readTimeout = -1;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.logTag = null;
            this.isWifiOnly = false;
            this.requestFrom = 0;
            this.requestSubFrom = 0;
            this.tags = Collections.emptyMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
            if (map != null) {
                this.callFactoryMap = map;
                return;
            }
            throw new IllegalArgumentException("callFactory is not set");
        }

        public R addUrlParams(Map<String, String> map) {
            UrlWrapper urlWrapper;
            if (map != null && map.size() > 0 && (urlWrapper = this.url) != null) {
                HttpUrl.Builder newBuilder = urlWrapper.getHttpUrl().newBuilder();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    newBuilder.addQueryParameter(entry.getKey(), entry.getValue());
                }
                this.url.setHttpUrl(newBuilder.build());
            }
            return this;
        }

        public R setUrlParams(Map<String, String> map) {
            UrlWrapper urlWrapper;
            if (map != null && map.size() > 0 && (urlWrapper = this.url) != null) {
                HttpUrl.Builder newBuilder = urlWrapper.getHttpUrl().newBuilder();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    newBuilder.setQueryParameter(entry.getKey(), entry.getValue());
                }
                this.url.setHttpUrl(newBuilder.build());
            }
            return this;
        }

        public R addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public R addUrlParam(String str, String str2) {
            UrlWrapper urlWrapper = this.url;
            if (urlWrapper != null) {
                HttpUrl.Builder newBuilder = urlWrapper.getHttpUrl().newBuilder();
                newBuilder.addQueryParameter(str, str2);
                this.url.setHttpUrl(newBuilder.build());
            }
            return this;
        }

        public R header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public R setHeader(String str, String str2) {
            return header(str, str2);
        }

        public R setUrlParam(String str, String str2) {
            UrlWrapper urlWrapper = this.url;
            if (urlWrapper != null) {
                HttpUrl.Builder newBuilder = urlWrapper.getHttpUrl().newBuilder();
                newBuilder.setQueryParameter(str, str2);
                this.url.setHttpUrl(newBuilder.build());
            }
            return this;
        }

        public <T> R tag(Class<? super T> cls, @Nullable T t) {
            if (cls != null) {
                if (t == null) {
                    this.tags.remove(cls);
                } else {
                    if (this.tags.isEmpty()) {
                        this.tags = new LinkedHashMap();
                    }
                    this.tags.put(cls, cls.cast(t));
                }
                return this;
            }
            throw new NullPointerException("type == null");
        }

        public R addHeaders(Map<String, String> map) {
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    this.headers.add(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public R connectionTimeout(int i) {
            this.connectionTimeout = Util.checkDuration("timeout", i, TimeUnit.MILLISECONDS);
            return this;
        }

        public R cookieManager(CookieManager cookieManager) {
            this.cookieManager = cookieManager;
            return this;
        }

        public R delete(@Nullable RequestBody requestBody) {
            return method(HttpDelete.METHOD_NAME, requestBody);
        }

        public R extraUserLog(JSONObject jSONObject) {
            this.extraUserLog = jSONObject;
            return this;
        }

        public R followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public R followSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        public R headers(Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public R patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public R post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public R put(RequestBody requestBody) {
            return method(HttpPut.METHOD_NAME, requestBody);
        }

        public R readTimeout(int i) {
            this.readTimeout = Util.checkDuration("timeout", i, TimeUnit.MILLISECONDS);
            return this;
        }

        public R removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public R removeHeaders(List<String> list) {
            if (list != null && list.size() > 0) {
                for (String str : list) {
                    this.headers.removeAll(str);
                }
            }
            return this;
        }

        public R removeUrlParam(String str) {
            UrlWrapper urlWrapper = this.url;
            if (urlWrapper != null) {
                HttpUrl.Builder newBuilder = urlWrapper.getHttpUrl().newBuilder();
                newBuilder.removeAllQueryParameters(str);
                this.url.setHttpUrl(newBuilder.build());
            }
            return this;
        }

        public R removeUrlParams(List<String> list) {
            UrlWrapper urlWrapper;
            if (list != null && list.size() > 0 && (urlWrapper = this.url) != null) {
                HttpUrl.Builder newBuilder = urlWrapper.getHttpUrl().newBuilder();
                for (String str : list) {
                    newBuilder.removeAllQueryParameters(str);
                }
                this.url.setHttpUrl(newBuilder.build());
            }
            return this;
        }

        public R requestFrom(int i) {
            this.requestFrom = i;
            return this;
        }

        public R requestSubFrom(int i) {
            this.requestSubFrom = i;
            return this;
        }

        public R tag(@Nullable Object obj) {
            return tag(Object.class, obj);
        }

        public R url(HttpUrl httpUrl) {
            if (httpUrl != null) {
                this.url = new UrlWrapper(httpUrl);
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public R userAgent(String str) {
            if (!Util.isTextEmpty(str)) {
                this.headers.set("User-Agent", str);
            }
            return this;
        }

        public R wifiOnly(boolean z) {
            this.isWifiOnly = z;
            return this;
        }

        public R writeTimeout(int i) {
            this.writeTimeout = i;
            return this;
        }

        public Request build() {
            return new Request(this);
        }

        public R delete() {
            return delete(Util.EMPTY_REQUEST);
        }

        public R enableBrotli() {
            this.enableBrotli = true;
            return this;
        }

        public R get() {
            return method("GET", null);
        }

        public R head() {
            return method("HEAD", null);
        }

        public R headers(Map<String, String> map) {
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    this.headers.set(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public R url(UrlWrapper urlWrapper) {
            if (urlWrapper != null) {
                this.url = urlWrapper;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public R method(String str, @Nullable RequestBody requestBody) {
            if (str != null) {
                if (str.length() != 0) {
                    if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    } else if (requestBody == null && HttpMethod.requiresRequestBody(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    } else {
                        this.method = str;
                        this.body = requestBody;
                        return this;
                    }
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public R url(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
                }
                UrlWrapper urlWrapper = this.url;
                if (urlWrapper == null) {
                    try {
                        try {
                            this.url = new UrlWrapper(str);
                        } catch (IllegalArgumentException unused) {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unexpected url: " + str);
                            this.record.exception = illegalArgumentException;
                            throw illegalArgumentException;
                        }
                    } finally {
                        DoRecordManager.getInstance().doRecord(this.record, DoRecordManager.FAILED_MSG);
                    }
                } else {
                    urlWrapper.setUrl(str);
                }
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public R url(URL url) {
            if (url != null) {
                UrlWrapper urlWrapper = this.url;
                if (urlWrapper == null) {
                    this.url = new UrlWrapper(url.toString());
                } else {
                    urlWrapper.setHttpUrl(null);
                    this.url.setUrl(url.toString());
                }
                return url(this.url);
            }
            throw new NullPointerException("url == null");
        }
    }

    public Request(Builder builder) {
        this.connectionTimeout = 0;
        this.readTimeout = 0;
        this.writeTimeout = 0;
        this.requestFrom = 0;
        this.requestSubFrom = 0;
        this.url = builder.url;
        this.method = builder.method;
        this.body = builder.body;
        this.connectionTimeout = builder.connectionTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.followRedirects = builder.followRedirects;
        this.followSslRedirects = builder.followSslRedirects;
        this.requestFrom = builder.requestFrom;
        this.requestSubFrom = builder.requestSubFrom;
        this.extraUserLog = builder.extraUserLog;
        this.cookieManager = builder.cookieManager;
        this.isWifiOnly = builder.isWifiOnly;
        this.tags = Util.immutableMap(builder.tags);
        if (Util.isTextEmpty(builder.bdTraceId)) {
            this.bdTraceId = generateBdTraceId();
        } else {
            this.bdTraceId = builder.bdTraceId;
        }
        builder.headers.add("X-BD-TraceId", this.bdTraceId);
        if (builder.enableBrotli) {
            builder.header("bdapp-support-brotli", "1");
        }
        this.headers = builder.headers.build();
        NetworkStatRecord networkStatRecord = builder.record;
        if (networkStatRecord != null) {
            this.record = networkStatRecord;
        } else {
            this.record = new NetworkStatRecord();
        }
        NetworkStatRecord networkStatRecord2 = this.record;
        networkStatRecord2.bdTraceId = this.bdTraceId;
        networkStatRecord2.url = this.url.toString();
        NetworkStatRecord networkStatRecord3 = this.record;
        networkStatRecord3.extraUserInfo = this.extraUserLog;
        networkStatRecord3.from = this.requestFrom;
        networkStatRecord3.subFrom = this.requestSubFrom;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.record.netType = ConnectManager.getNetworkInfo(OutbackComponent.getInstance().getContext());
            this.record.isVPNConnect = ConnectManager.isVPNConnected(OutbackComponent.getInstance().getContext());
            this.record.getNetworkInfoTs = System.currentTimeMillis() - currentTimeMillis;
        } catch (Exception unused) {
        }
        this.callFactoryMap = builder.callFactoryMap;
    }

    private String generateBdTraceId() {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }

    @Nullable
    public RequestBody body() {
        return this.body;
    }

    public Response executeStat() throws RequestCallException {
        return new RequestCall(this).executeStat();
    }

    public Response executeSync() throws RequestCallException {
        return new RequestCall(this).executeSync();
    }

    public String getBdTraceId() {
        return this.bdTraceId;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public CookieManager getCookieManager() {
        return this.cookieManager;
    }

    public JSONObject getExtraUserLog() {
        return this.extraUserLog;
    }

    public Headers getHeaders() {
        return this.headers;
    }

    public NetworkStatRecord getNetworkStatRecord() {
        return this.record;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public int getRequestFrom() {
        return this.requestFrom;
    }

    public int getRequestSubFrom() {
        return this.requestSubFrom;
    }

    public Map<Class<?>, Object> getTags() {
        return this.tags;
    }

    public int getWriteTimeout() {
        return this.writeTimeout;
    }

    public Headers headers() {
        return this.headers;
    }

    public HttpUrl httpUrl() {
        return this.url.getHttpUrl();
    }

    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    public boolean isFollowSslRedirects() {
        return this.followSslRedirects;
    }

    public boolean isHttps() {
        return this.url.isHttps();
    }

    public RequestCall makeRequestCall() {
        return new RequestCall(this);
    }

    public String method() {
        return this.method;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Nullable
    public Object tag() {
        return tag(Object.class);
    }

    public String toString() {
        return "Request{method=" + this.method + ", url=" + this.url + ", tags=" + this.tags + '}';
    }

    public UrlWrapper url() {
        return this.url;
    }

    public <T> Cancelable executeAsync(ResponseCallback<T> responseCallback) {
        return new RequestCall(this).executeAsync(responseCallback);
    }

    public <T> Cancelable executeAsyncOnUIBack(ResponseCallback<T> responseCallback) {
        return new RequestCall(this).executeAsyncOnUIBack(responseCallback);
    }

    public <T> Cancelable executeStat(ResponseCallback<T> responseCallback) {
        return new RequestCall(this).executeStat(responseCallback);
    }

    public <T> Cancelable executeStatUIBack(ResponseCallback<T> responseCallback) {
        return new RequestCall(this).executeStatUIBack(responseCallback);
    }

    @Nullable
    public String header(String str) {
        return this.headers.get(str);
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }

    public void onException4NetworkStatRecord(Exception exc) {
        NetworkStatRecord networkStatRecord = this.record;
        networkStatRecord.exception = exc;
        networkStatRecord.failTs = System.currentTimeMillis();
        if (TextUtils.isEmpty(this.record.clientIP)) {
            this.record.clientIP = ConnectManager.getClientIP();
        }
    }

    public void onFinishReadContent4NetworkStatRecord(long j) {
        this.record.readOverTs = System.currentTimeMillis();
        this.record.realResponseLength = j;
    }

    @Nullable
    public <T> T tag(Class<? extends T> cls) {
        return cls.cast(this.tags.get(cls));
    }

    public <T> Cancelable executeAsyncWithHandler(Handler handler, ResponseCallback<T> responseCallback) {
        return new RequestCall(this).executeAsyncWithHandler(handler, responseCallback);
    }

    public <T> Cancelable executeStatWithHandler(Handler handler, ResponseCallback<T> responseCallback) {
        return new RequestCall(this).executeStatWithHandler(handler, responseCallback);
    }

    public void onConnect4NetworkStatRecord(long j, String str) {
        NetworkStatRecord networkStatRecord = this.record;
        networkStatRecord.connTs = j;
        networkStatRecord.protocol = str;
    }

    public void onReceiveHeader4NetworkStatRecord(long j, Headers headers) {
        this.record.receiveHeaderTs = j;
        String str = headers.get("X-Bfe-Svbbrers");
        if (!Util.isTextEmpty(str)) {
            this.record.clientIP = str;
            return;
        }
        this.record.clientIP = ConnectManager.getClientIP();
    }

    public Call newCall() {
        Map<String, CallFactory> map = this.callFactoryMap;
        if (map != null) {
            Call call = null;
            boolean z = true;
            if (map.containsKey("CUSTOM")) {
                CallFactory callFactory = this.callFactoryMap.get("CUSTOM");
                if (this.callFactoryMap.size() == 1) {
                    z = false;
                }
                call = callFactory.newCall(this, z);
            } else if (this.callFactoryMap.containsKey(EngineName.DEFAULT_ENGINE)) {
                CallFactory callFactory2 = this.callFactoryMap.get(EngineName.DEFAULT_ENGINE);
                if (this.callFactoryMap.size() == 1) {
                    z = false;
                }
                call = callFactory2.newCall(this, z);
            }
            if (call == null) {
                if (this.callFactoryMap.containsKey(EngineName.BACK_UP_ENGINE)) {
                    return this.callFactoryMap.get(EngineName.BACK_UP_ENGINE).newCall(this, false);
                }
                if (this.callFactoryMap.containsKey(EngineName.DEFAULT_ENGINE)) {
                    return this.callFactoryMap.get(EngineName.DEFAULT_ENGINE).newCall(this, false);
                }
                return call;
            }
            return call;
        }
        throw new IllegalArgumentException("callFactory is not set");
    }

    public void onDnsParse4NetworkStatRecord(long j, long j2, JSONObject jSONObject) {
        NetworkStatRecord networkStatRecord = this.record;
        networkStatRecord.dnsStartTs = j;
        networkStatRecord.dnsEndTs = j2;
        if (jSONObject != null) {
            networkStatRecord.dnsDetail = jSONObject;
        }
    }
}
