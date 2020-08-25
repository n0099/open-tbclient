package com.baidu.searchbox.http.request;

import android.os.Handler;
import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.Cancelable;
import com.baidu.searchbox.http.RequestHandler;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.interceptor.LogInterceptor;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStat;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.Proxy;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public abstract class HttpRequest<T extends HttpRequestBuilder> {
    public static final String EXT_HEADER_TRACE_ID = "X-Bd-Traceid";
    public static final int REQUESTFROM_FEED = 1;
    public static final int REQUESTFROM_FRESCO = 2;
    public static final int REQUESTFROM_NONE = 0;
    public static final int REQUESTFROM_UBC = 3;
    protected String bdTraceId;
    protected OkHttpClient client;
    protected int connectionTimeout;
    protected CookieManager cookieManager;
    protected Handler deliver;
    protected boolean enableRetry;
    protected JSONObject extraUserLog;
    protected boolean followRedirects;
    protected boolean followSslRedirects;
    protected Headers headers;
    protected AbstractHttpManager httpManager;
    protected HttpUrl httpUrl;
    public boolean isConnReused;
    protected boolean isReqNetStatEnable;
    protected boolean isWifiOnly;
    protected LogInterceptor.Level logLevel;
    protected String logTag;
    protected NetworkStat<Request> networkStat;
    protected Request okRequest;
    protected Request.Builder okRequestBuilder;
    protected Object originTag;
    protected IAsyncRequestParamsHandler paramsHandler;
    protected Proxy proxy;
    protected int readTimeout;
    protected int requestFrom;
    protected RequestHandler requestHandler;
    protected NetworkStatRecord requestNetStat;
    protected Object tag;
    protected int writeTimeout;

    protected abstract Request buildOkRequest(RequestBody requestBody);

    protected abstract RequestBody buildOkRequestBody();

    protected abstract void initExtraHttpRequest(T t);

    public abstract T newBuilder();

    public abstract T newBuilder(AbstractHttpManager abstractHttpManager);

    public HttpRequest(T t) {
        this.connectionTimeout = 0;
        this.readTimeout = 0;
        this.writeTimeout = 0;
        this.enableRetry = true;
        this.paramsHandler = null;
        this.requestNetStat = null;
        this.requestFrom = 0;
        this.httpManager = t.httpManager;
        this.client = this.httpManager.getOkHttpClient();
        this.requestHandler = this.httpManager.getRequestHandler();
        this.networkStat = this.httpManager.getNetworkStat();
        this.deliver = this.httpManager.getDeliver();
        this.httpUrl = t.httpUrl;
        this.tag = t.tag;
        this.connectionTimeout = t.connectionTimeout;
        this.readTimeout = t.readTimeout;
        this.writeTimeout = t.writeTimeout;
        this.enableRetry = t.enableRetry;
        this.logTag = t.logTag;
        this.logLevel = t.logLevel;
        this.isWifiOnly = t.isWifiOnly;
        this.cookieManager = t.cookieManager;
        this.paramsHandler = t.paramsHandler;
        this.isReqNetStatEnable = t.isReqNetStatEnable;
        this.requestFrom = t.requestFrom;
        this.extraUserLog = t.extraUserLog;
        this.proxy = t.proxy;
        this.followRedirects = t.followRedirects;
        this.followSslRedirects = t.followSslRedirects;
        if (this.httpUrl == null) {
            throw new IllegalArgumentException(" url not set, please check");
        }
        this.bdTraceId = generateBdTraceId();
        t.headersBuilder.add(EXT_HEADER_TRACE_ID, this.bdTraceId);
        this.headers = t.headersBuilder.build();
        if (this.isReqNetStatEnable) {
            this.requestNetStat = new NetworkStatRecord();
            this.requestNetStat.url = this.httpUrl.toString();
        }
        initOkRequest(t);
    }

    private String generateBdTraceId() {
        return UUID.randomUUID().toString().toLowerCase().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public long getContentLength() {
        try {
            return this.okRequest.body().contentLength();
        } catch (IOException e) {
            return 0L;
        }
    }

    public String getBdTraceId() {
        return this.bdTraceId;
    }

    public Request getOkRequest() {
        return this.okRequest;
    }

    public Object tag() {
        return this.originTag;
    }

    public NetworkStat<Request> getNetworkStat() {
        return this.networkStat;
    }

    public NetworkStatRecord getRequestNetStat() {
        return this.requestNetStat;
    }

    public int getRequestFrom() {
        return this.requestFrom;
    }

    public JSONObject getExtraUserLog() {
        return this.extraUserLog;
    }

    private void initOkRequest(T t) {
        this.okRequestBuilder = new Request.Builder();
        this.okRequestBuilder.url(this.httpUrl);
        this.originTag = this.tag;
        if (this.tag != null) {
            this.okRequestBuilder.tag(this.tag);
        }
        if (this.networkStat != null || this.isReqNetStatEnable) {
            this.okRequestBuilder.tag(this);
        }
        if (this.headers != null && this.headers.size() > 0) {
            this.okRequestBuilder.headers(this.headers);
        }
        initExtraHttpRequest(t);
        this.okRequest = buildOkRequest(buildOkRequestBody());
    }

    public RequestCall makeRequestCall() {
        return new RequestCall(this);
    }

    public Response executeSync() throws IOException {
        return new RequestCall(this).executeSync();
    }

    public <T> Cancelable executeAsync(ResponseCallback<T> responseCallback) {
        return new RequestCall(this).executeAsync(responseCallback);
    }

    public <T> Cancelable executeAsyncOnUIBack(ResponseCallback<T> responseCallback) {
        return new RequestCall(this).executeAsyncOnUIBack(responseCallback);
    }

    public <T> Cancelable executeAsyncWithHandler(Handler handler, ResponseCallback<T> responseCallback) {
        return new RequestCall(this).executeAsyncWithHandler(handler, responseCallback);
    }

    public StatResponse executeStat() throws IOException {
        return new RequestCall(this).executeStat();
    }

    public <T> Cancelable executeStat(StatResponseCallback<T> statResponseCallback) {
        return new RequestCall(this).executeStat(statResponseCallback);
    }

    public <T> Cancelable executeStatUIBack(StatResponseCallback<T> statResponseCallback) {
        return new RequestCall(this).executeStatUIBack(statResponseCallback);
    }

    public <T> Cancelable executeStatWithHandler(Handler handler, StatResponseCallback<T> statResponseCallback) {
        return new RequestCall(this).executeStatWithHandler(handler, statResponseCallback);
    }
}
