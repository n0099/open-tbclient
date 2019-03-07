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
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes2.dex */
public abstract class HttpRequest<T extends HttpRequestBuilder> {
    protected OkHttpClient client;
    protected int connectionTimeout;
    protected CookieManager cookieManager;
    protected Handler deliver;
    protected boolean enableRetry;
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
    protected int readTimeout;
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
        this.httpManager = t.httpManager;
        this.client = this.httpManager.getOkHttpClient();
        this.requestHandler = this.httpManager.getRequestHandler();
        this.networkStat = this.httpManager.getNetworkStat();
        this.deliver = this.httpManager.getDeliver();
        this.httpUrl = t.httpUrl;
        this.tag = t.tag;
        this.headers = t.headersBuilder.build();
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
        if (this.httpUrl == null) {
            throw new IllegalArgumentException(" url not set, please check");
        }
        if (this.isReqNetStatEnable) {
            this.requestNetStat = new NetworkStatRecord();
            this.requestNetStat.url = this.httpUrl.toString();
        }
        initOkRequest(t);
    }

    public long getContentLength() {
        try {
            return this.okRequest.body().contentLength();
        } catch (IOException e) {
            return 0L;
        }
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
