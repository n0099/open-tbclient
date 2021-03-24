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
import com.baidu.searchbox.http.util.HttpUtils;
import java.io.IOException;
import java.net.Proxy;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class HttpRequest<T extends HttpRequestBuilder> {
    public static final String EXT_HEADER_TRACE_ID = "X-Bd-Traceid";
    public static final int REQUESTFROM_FEED = 1;
    public static final int REQUESTFROM_FRESCO = 2;
    public static final int REQUESTFROM_NONE = 0;
    public static final int REQUESTFROM_UBC = 3;
    public String bdTraceId;
    public OkHttpClient client;
    public int connectionTimeout;
    public CookieManager cookieManager;
    public Handler deliver;
    public boolean enableRetry;
    public JSONObject extraUserLog;
    public boolean followRedirects;
    public boolean followSslRedirects;
    public Headers headers;
    public AbstractHttpManager httpManager;
    public HttpUrl httpUrl;
    public boolean isConnReused;
    public boolean isReqNetStatEnable;
    public boolean isWifiOnly;
    public LogInterceptor.Level logLevel;
    public String logTag;
    public NetworkStat<Request> networkStat;
    public Request okRequest;
    public Request.Builder okRequestBuilder;
    public Object originTag;
    public IAsyncRequestParamsHandler paramsHandler;
    public Proxy proxy;
    public int readTimeout;
    public int requestFrom;
    public RequestHandler requestHandler;
    public NetworkStatRecord requestNetStat;
    public int requestSubFrom;
    public Object tag;
    public int writeTimeout;

    public HttpRequest(T t) {
        this.connectionTimeout = 0;
        this.readTimeout = 0;
        this.writeTimeout = 0;
        this.enableRetry = true;
        this.paramsHandler = null;
        this.requestNetStat = null;
        this.requestFrom = 0;
        this.requestSubFrom = 0;
        AbstractHttpManager abstractHttpManager = t.httpManager;
        this.httpManager = abstractHttpManager;
        this.client = abstractHttpManager.getOkHttpClient();
        this.requestHandler = this.httpManager.getRequestHandler();
        this.networkStat = this.httpManager.getNetworkStat();
        this.deliver = this.httpManager.getDeliver();
        HttpUrl httpUrl = t.httpUrl;
        this.httpUrl = httpUrl;
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
        this.requestSubFrom = t.requestSubFrom;
        this.extraUserLog = t.extraUserLog;
        this.proxy = t.proxy;
        this.followRedirects = t.followRedirects;
        this.followSslRedirects = t.followSslRedirects;
        if (httpUrl != null) {
            String generateBdTraceId = HttpUtils.generateBdTraceId();
            this.bdTraceId = generateBdTraceId;
            t.headersBuilder.add(EXT_HEADER_TRACE_ID, generateBdTraceId);
            this.headers = t.headersBuilder.build();
            if (this.isReqNetStatEnable) {
                NetworkStatRecord networkStatRecord = new NetworkStatRecord();
                this.requestNetStat = networkStatRecord;
                networkStatRecord.url = this.httpUrl.toString();
                NetworkStatRecord networkStatRecord2 = this.requestNetStat;
                networkStatRecord2.from = t.requestFrom;
                networkStatRecord2.subFrom = t.requestSubFrom;
            }
            initOkRequest(t);
            return;
        }
        throw new IllegalArgumentException(" url not set, please check");
    }

    private void initOkRequest(T t) {
        Request.Builder builder = new Request.Builder();
        this.okRequestBuilder = builder;
        builder.url(this.httpUrl);
        Object obj = this.tag;
        this.originTag = obj;
        if (obj != null) {
            this.okRequestBuilder.tag(obj);
        }
        if (this.networkStat != null || this.isReqNetStatEnable) {
            this.okRequestBuilder.tag(this);
        }
        Headers headers = this.headers;
        if (headers != null && headers.size() > 0) {
            this.okRequestBuilder.headers(this.headers);
        }
        initExtraHttpRequest(t);
        this.okRequest = buildOkRequest(buildOkRequestBody());
    }

    public abstract Request buildOkRequest(RequestBody requestBody);

    public abstract RequestBody buildOkRequestBody();

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

    public <T> Cancelable executeStatUIBack(StatResponseCallback<T> statResponseCallback) {
        return new RequestCall(this).executeStatUIBack(statResponseCallback);
    }

    public <T> Cancelable executeStatWithHandler(Handler handler, StatResponseCallback<T> statResponseCallback) {
        return new RequestCall(this).executeStatWithHandler(handler, statResponseCallback);
    }

    public Response executeSync() throws IOException {
        return new RequestCall(this).executeSync();
    }

    public String getBdTraceId() {
        return this.bdTraceId;
    }

    public long getContentLength() {
        try {
            return this.okRequest.body().contentLength();
        } catch (IOException unused) {
            return 0L;
        }
    }

    public JSONObject getExtraUserLog() {
        return this.extraUserLog;
    }

    public NetworkStat<Request> getNetworkStat() {
        return this.networkStat;
    }

    public Request getOkRequest() {
        return this.okRequest;
    }

    public int getRequestFrom() {
        return this.requestFrom;
    }

    public NetworkStatRecord getRequestNetStat() {
        return this.requestNetStat;
    }

    public int getRequestSubFrom() {
        return this.requestSubFrom;
    }

    public abstract void initExtraHttpRequest(T t);

    public RequestCall makeRequestCall() {
        return new RequestCall(this);
    }

    public abstract T newBuilder();

    public abstract T newBuilder(AbstractHttpManager abstractHttpManager);

    public Object tag() {
        return this.originTag;
    }

    public <T> Cancelable executeStat(StatResponseCallback<T> statResponseCallback) {
        return new RequestCall(this).executeStat(statResponseCallback);
    }
}
