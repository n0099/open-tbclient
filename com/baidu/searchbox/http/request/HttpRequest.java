package com.baidu.searchbox.http.request;

import android.os.Handler;
import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.Cancelable;
import com.baidu.searchbox.http.HttpRuntime;
import com.baidu.searchbox.http.IHttpContext;
import com.baidu.searchbox.http.RequestHandler;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.interceptor.LogInterceptor;
import com.baidu.searchbox.http.model.MultipleConnectParams;
import com.baidu.searchbox.http.multipath.IMultiPath;
import com.baidu.searchbox.http.multipath.MultiPathRuntime;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStat;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.http.util.HttpUtils;
import java.io.IOException;
import java.net.Proxy;
import okhttp3.Dns;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class HttpRequest<T extends HttpRequestBuilder> {
    public static final String EXT_HEADER_MULTIPLE_CONNECT_DELAY_TIME_MS = "Multiple-Connect-Delay-Time";
    public static final String EXT_HEADER_MULTIPLE_CONNECT_NUM = "Multiple-Connect-Num";
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
    public Dns dns;
    public String enableBindMobilePolicy;
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
    public int pingInterval;
    public Proxy proxy;
    public int readTimeout;
    public int requestFrom;
    public RequestHandler requestHandler;
    public NetworkStatRecord requestNetStat;
    public int requestSubFrom;
    public Object tag;
    public int writeTimeout;
    public boolean isMultipleConnectEnabled = false;
    public volatile boolean isFinished = false;
    public boolean isOldHttpUseTurbonet = false;

    public abstract Request buildOkRequest(RequestBody requestBody);

    public abstract RequestBody buildOkRequestBody();

    public abstract void initExtraHttpRequest(T t);

    public abstract T newBuilder();

    public abstract T newBuilder(AbstractHttpManager abstractHttpManager);

    public HttpRequest(T t) {
        String str;
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
            setOldHttpUseCronet();
            String generateBdTraceId = HttpUtils.generateBdTraceId();
            this.bdTraceId = generateBdTraceId;
            t.headersBuilder.add(EXT_HEADER_TRACE_ID, generateBdTraceId);
            addMultiConnectHeader(t.headersBuilder);
            if (t.enableBrotli) {
                t.headersBuilder.add("bdapp-support-brotli", "1");
            }
            IMultiPath iMultiPath = MultiPathRuntime.sMultiPath;
            if (iMultiPath != null && iMultiPath.getBindMobileFromList() != null && iMultiPath.getBindMobileFromList().contains(Integer.valueOf(this.requestFrom))) {
                String str2 = t.enableBindMobilePolicy;
                if (str2 != null) {
                    t.enableBindMobile(str2);
                } else {
                    t.enableBindMobile("1");
                }
            }
            if (t.enableBindMobile && (str = t.enableBindMobilePolicy) != null) {
                t.headersBuilder.add("X-Bind-Mobile", str);
                this.enableBindMobilePolicy = t.enableBindMobilePolicy;
            }
            this.headers = t.headersBuilder.build();
            if (this.isReqNetStatEnable) {
                NetworkStatRecord networkStatRecord = new NetworkStatRecord();
                this.requestNetStat = networkStatRecord;
                networkStatRecord.url = this.httpUrl.toString();
                NetworkStatRecord networkStatRecord2 = this.requestNetStat;
                networkStatRecord2.from = t.requestFrom;
                networkStatRecord2.subFrom = t.requestSubFrom;
            }
            this.dns = t.dns;
            this.pingInterval = t.pingInterval;
            initOkRequest(t);
            return;
        }
        throw new IllegalArgumentException(" url not set, please check");
    }

    private void addMultiConnectHeader(Headers.Builder builder) {
        IHttpContext httpContext;
        if (builder == null || (httpContext = HttpRuntime.getHttpContext()) == null) {
            return;
        }
        MultipleConnectParams multipleConnectParams = httpContext.getMultipleConnectParams();
        if (multipleConnectParams != null && multipleConnectParams.isMultiConnectEnabledGlobal() && multipleConnectParams.isMultiConnectABSwitch() && multipleConnectParams.getMultiConnectFromList() != null && multipleConnectParams.getMultiConnectFromList().size() > 0 && multipleConnectParams.getMultiConnectFromList().contains(Integer.valueOf(getRequestFrom()))) {
            int maxMultiConnectNum = multipleConnectParams.getMaxMultiConnectNum();
            int multiConnectDelayInMsWifi = multipleConnectParams.getMultiConnectDelayInMsWifi();
            int multiConnectDelayInMsMobile = multipleConnectParams.getMultiConnectDelayInMsMobile();
            if (maxMultiConnectNum > 0 && multiConnectDelayInMsMobile > 0 && multiConnectDelayInMsWifi > 0) {
                builder.add(EXT_HEADER_MULTIPLE_CONNECT_NUM, String.valueOf(maxMultiConnectNum));
                if (this.httpManager.isWifi()) {
                    builder.add(EXT_HEADER_MULTIPLE_CONNECT_DELAY_TIME_MS, String.valueOf(multiConnectDelayInMsWifi));
                } else {
                    builder.add(EXT_HEADER_MULTIPLE_CONNECT_DELAY_TIME_MS, String.valueOf(multiConnectDelayInMsMobile));
                }
                this.isMultipleConnectEnabled = true;
                return;
            }
            this.isMultipleConnectEnabled = false;
            return;
        }
        this.isMultipleConnectEnabled = false;
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

    private void setOldHttpUseCronet() {
        IHttpContext httpContext = HttpRuntime.getHttpContext();
        if (httpContext == null) {
            return;
        }
        this.isOldHttpUseTurbonet = httpContext.isOldHttpUseTurbonet(this.httpUrl.host(), this.requestFrom);
    }

    public StatResponse executeStat() throws IOException {
        return new RequestCall(this).executeStat();
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

    public Dns getDns() {
        return this.dns;
    }

    public String getEnableBindMobilePolicy() {
        return this.enableBindMobilePolicy;
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

    public int getPingInterval() {
        return this.pingInterval;
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

    public boolean isFinished() {
        return this.isFinished;
    }

    public boolean isMultiConnectEnabled() {
        return this.isMultipleConnectEnabled;
    }

    public boolean isOldHttpUseTurbonet() {
        return this.isOldHttpUseTurbonet;
    }

    public RequestCall makeRequestCall() {
        return new RequestCall(this);
    }

    public Object tag() {
        return this.originTag;
    }

    public <T> Cancelable executeAsync(ResponseCallback<T> responseCallback) {
        return new RequestCall(this).executeAsync(responseCallback);
    }

    public <T> Cancelable executeAsyncOnUIBack(ResponseCallback<T> responseCallback) {
        return new RequestCall(this).executeAsyncOnUIBack(responseCallback);
    }

    public <T> Cancelable executeStat(StatResponseCallback<T> statResponseCallback) {
        return new RequestCall(this).executeStat(statResponseCallback);
    }

    public <T> Cancelable executeStatUIBack(StatResponseCallback<T> statResponseCallback) {
        return new RequestCall(this).executeStatUIBack(statResponseCallback);
    }

    public <T> Cancelable executeAsyncWithHandler(Handler handler, ResponseCallback<T> responseCallback) {
        return new RequestCall(this).executeAsyncWithHandler(handler, responseCallback);
    }

    public <T> Cancelable executeStatWithHandler(Handler handler, StatResponseCallback<T> statResponseCallback) {
        return new RequestCall(this).executeStatWithHandler(handler, statResponseCallback);
    }
}
