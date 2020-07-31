package com.baidu.searchbox.network.request;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.searchbox.network.AbstractHttpManager;
import com.baidu.searchbox.network.Cancelable;
import com.baidu.searchbox.network.RequestHandler;
import com.baidu.searchbox.network.callback.NetworkStatResponseCallback;
import com.baidu.searchbox.network.callback.ResponseCallback;
import com.baidu.searchbox.network.cookie.CookieManager;
import com.baidu.searchbox.network.core.Headers;
import com.baidu.searchbox.network.core.HttpUrl;
import com.baidu.searchbox.network.core.Interceptor;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.RequestBody;
import com.baidu.searchbox.network.core.RequestClient;
import com.baidu.searchbox.network.core.Response;
import com.baidu.searchbox.network.core.internal.Util;
import com.baidu.searchbox.network.interceptor.LogInterceptor;
import com.baidu.searchbox.network.interceptor.ParamInterceptor;
import com.baidu.searchbox.network.request.HttpRequestBuilder;
import com.baidu.searchbox.network.statistics.NetworkStat;
import com.baidu.searchbox.network.statistics.NetworkStatRecord;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class HttpRequest<T extends HttpRequestBuilder> {
    public static final int REQUESTFROM_FEED = 1;
    public static final int REQUESTFROM_FRESCO = 2;
    public static final int REQUESTFROM_NONE = 0;
    protected RequestClient client;
    protected int connectionTimeout;
    protected CookieManager cookieManager;
    protected Handler deliver;
    protected JSONObject extraUserLog;
    protected boolean followRedirects;
    protected Headers headers;
    protected AbstractHttpManager httpManager;
    public HttpUrl httpUrl;
    public boolean isConnReused;
    protected boolean isReqNetStatEnable;
    protected boolean isWifiOnly;
    protected LogInterceptor.Level logLevel;
    protected String logTag;
    protected NetworkStat<Request> networkStat;
    protected Request.Builder okRequestBuilder;
    protected Object originTag;
    protected IAsyncRequestParamsHandler paramsHandler;
    protected int readTimeout;
    protected Request request;
    protected int requestFrom;
    protected RequestHandler requestHandler;
    protected NetworkStatRecord requestNetStat;
    protected Object tag;

    protected abstract Request buildOkRequest(RequestBody requestBody);

    protected abstract RequestBody buildOkRequestBody();

    protected abstract void initExtraHttpRequest(T t);

    public abstract T newBuilder();

    public abstract T newBuilder(AbstractHttpManager abstractHttpManager);

    public HttpRequest(T t) {
        this.connectionTimeout = 0;
        this.readTimeout = 0;
        this.paramsHandler = null;
        this.requestNetStat = null;
        this.requestFrom = 0;
        this.httpManager = t.httpManager;
        this.client = this.httpManager.getRequestClient();
        this.requestHandler = this.httpManager.getRequestHandler();
        this.networkStat = this.httpManager.getNetworkStat();
        this.deliver = this.httpManager.getDeliver();
        this.httpUrl = t.httpUrl;
        this.tag = t.tag;
        this.headers = t.headersBuilder.build();
        this.connectionTimeout = t.connectionTimeout;
        this.readTimeout = t.readTimeout;
        this.logTag = t.logTag;
        this.logLevel = t.logLevel;
        this.isWifiOnly = t.isWifiOnly;
        this.cookieManager = t.cookieManager;
        this.paramsHandler = t.paramsHandler;
        this.isReqNetStatEnable = t.isReqNetStatEnable;
        this.requestFrom = t.requestFrom;
        this.extraUserLog = t.extraUserLog;
        this.followRedirects = t.followRedirects;
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
            return this.request.body().contentLength();
        } catch (IOException e) {
            return 0L;
        }
    }

    public Request getRequest() {
        return this.request;
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

    public CookieManager getCookieManager() {
        return this.cookieManager;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public Headers getHeaders() {
        return this.headers;
    }

    public int getRequestFrom() {
        return this.requestFrom;
    }

    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    public JSONObject getExtraUserLog() {
        return this.extraUserLog;
    }

    private void initOkRequest(T t) {
        this.okRequestBuilder = new Request.Builder();
        this.okRequestBuilder.url(this.httpUrl);
        this.okRequestBuilder.httpRequest(this);
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
        this.request = buildOkRequest(buildOkRequestBody());
    }

    public List<Interceptor> getExtraInterceptors() {
        ArrayList arrayList = new ArrayList();
        if (this.paramsHandler != null) {
            arrayList.add(new ParamInterceptor(this.paramsHandler));
        }
        return Util.immutableList(arrayList);
    }

    public List<Interceptor> getExtraNetworkInterceptors() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.logTag)) {
            arrayList.add(new LogInterceptor(this.logTag, this.logLevel));
        }
        return Util.immutableList(arrayList);
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

    public <T> Cancelable executeStat(NetworkStatResponseCallback<T> networkStatResponseCallback) {
        return new RequestCall(this).executeStat(networkStatResponseCallback);
    }

    public <T> Cancelable executeStatUIBack(NetworkStatResponseCallback<T> networkStatResponseCallback) {
        return new RequestCall(this).executeStatUIBack(networkStatResponseCallback);
    }

    public <T> Cancelable executeStatWithHandler(Handler handler, NetworkStatResponseCallback<T> networkStatResponseCallback) {
        return new RequestCall(this).executeStatWithHandler(handler, networkStatResponseCallback);
    }
}
