package com.baidu.searchbox.http;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.searchbox.http.RequestHandler;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.DeleteRequest;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.HeadRequest;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.PatchRequest;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.searchbox.http.request.PostFileRequest;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.http.request.PostMultiPartFormRequest;
import com.baidu.searchbox.http.request.PostStringRequest;
import com.baidu.searchbox.http.request.PutBodyRequest;
import com.baidu.searchbox.http.request.PutFormRequest;
import com.baidu.searchbox.http.statistics.NetworkStat;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes2.dex */
public abstract class AbstractHttpManager {
    public static final String TAG = "HttpManager";
    public static String sClientIP;
    public static List<Class<? extends Interceptor>> sExternalInterceptorClass;
    public static List<Class<? extends Interceptor>> sExternalNetworkInterceptorClass;
    public static ProductUserAgentHandler sProductUserAgent;
    public static ProxySelector sProxySelector;
    public Context context;
    public Handler deliver;
    public ConnectionPool ipv4OnlyConnectionPool;
    public NetworkStat<Request> networkStat;
    public OkHttpClient okHttpClient;
    public RequestHandler requestHandler;
    public IHttpDns sHttpDns;

    public AbstractHttpManager(Context context) {
        if (HttpRuntime.getHttpContext() != null) {
            HttpRuntime.getHttpContext().init();
            this.sHttpDns = HttpRuntime.getHttpContext().getNewHttpDns();
        }
        this.context = context.getApplicationContext();
        this.deliver = new Handler(Looper.getMainLooper());
        this.requestHandler = new RequestHandler.Default();
        this.okHttpClient = initClient();
    }

    public static void addExternalInterceptorClass(Class<? extends Interceptor> cls) {
        if (sExternalInterceptorClass == null) {
            synchronized (AbstractHttpManager.class) {
                if (sExternalInterceptorClass == null) {
                    sExternalInterceptorClass = new ArrayList();
                }
            }
        }
        if (cls == null || sExternalInterceptorClass.contains(cls)) {
            return;
        }
        sExternalInterceptorClass.add(cls);
    }

    public static void addExternalNetworkInterceptorClass(Class<? extends Interceptor> cls) {
        if (sExternalNetworkInterceptorClass == null) {
            synchronized (AbstractHttpManager.class) {
                if (sExternalNetworkInterceptorClass == null) {
                    sExternalNetworkInterceptorClass = new ArrayList();
                }
            }
        }
        if (cls != null) {
            if (sExternalNetworkInterceptorClass.isEmpty() || !sExternalNetworkInterceptorClass.contains(cls)) {
                sExternalNetworkInterceptorClass.add(cls);
            }
        }
    }

    private void addFreeCardProxySelector(OkHttpClient.Builder builder) {
        ProxySelector proxySelector = sProxySelector;
        if (proxySelector != null) {
            builder.proxySelector(proxySelector);
        }
    }

    private void addStaticInterceptor(OkHttpClient.Builder builder) {
        List<Class<? extends Interceptor>> list = sExternalNetworkInterceptorClass;
        if (list != null) {
            try {
                for (Class<? extends Interceptor> cls : list) {
                    builder.addNetworkInterceptor(cls.getConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        List<Class<? extends Interceptor>> list2 = sExternalInterceptorClass;
        if (list2 != null) {
            try {
                for (Class<? extends Interceptor> cls2 : list2) {
                    builder.addInterceptor(cls2.getConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void cancleTagByCall(Call call, Object obj) {
        if (obj.equals(call.request().tag())) {
            call.cancel();
        } else if ((call.request().tag() instanceof HttpRequest) && obj.equals(((HttpRequest) call.request().tag()).tag())) {
            call.cancel();
        }
    }

    public static String getClientIP() {
        return sClientIP;
    }

    public static ProductUserAgentHandler getProductUserAgent() {
        return sProductUserAgent;
    }

    public static void setGlobalProxySelector(ProxySelector proxySelector) {
        if (proxySelector != null) {
            sProxySelector = proxySelector;
        }
    }

    public static void setProductUserAgent(ProductUserAgentHandler productUserAgentHandler) {
        sProductUserAgent = productUserAgentHandler;
    }

    public static void updateClientIP(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sClientIP = str;
    }

    public void cancelAll() {
        getOkHttpClient().dispatcher().cancelAll();
    }

    public void cancelTag(Object obj) {
        if (obj != null) {
            for (Call call : getOkHttpClient().dispatcher().queuedCalls()) {
                cancleTagByCall(call, obj);
            }
            for (Call call2 : getOkHttpClient().dispatcher().runningCalls()) {
                cancleTagByCall(call2, obj);
            }
        }
    }

    public DeleteRequest.DeleteRequestBuilder deleteRequest() {
        return new DeleteRequest.DeleteRequestBuilder(this);
    }

    public CookieManager getCookieManager(boolean z, boolean z2) {
        return HttpRuntime.getHttpContext().getCookieManager(z, z2);
    }

    public Handler getDeliver() {
        return this.deliver;
    }

    public IHttpDns getHttpDns() {
        return this.sHttpDns;
    }

    public boolean getHttpDnsEnable() {
        IHttpDns iHttpDns = this.sHttpDns;
        if (iHttpDns != null) {
            return iHttpDns.getHttpDnsEnable();
        }
        return false;
    }

    public ConnectionPool getIPv4OnlyConnectionPool() {
        if (this.ipv4OnlyConnectionPool == null) {
            synchronized (AbstractHttpManager.class) {
                if (this.ipv4OnlyConnectionPool == null) {
                    this.ipv4OnlyConnectionPool = new ConnectionPool(10, 5L, TimeUnit.MINUTES);
                }
            }
        }
        return this.ipv4OnlyConnectionPool;
    }

    public String getNetworkInfo() {
        return ConnectManager.getNetworkInfo(this.context);
    }

    public NetworkStat<Request> getNetworkStat() {
        return this.networkStat;
    }

    public OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }

    public GetRequest.GetRequestBuilder getRequest() {
        return new GetRequest.GetRequestBuilder(this);
    }

    public RequestHandler getRequestHandler() {
        return this.requestHandler;
    }

    public HeadRequest.HeadRequestBuilder headerRequest() {
        return new HeadRequest.HeadRequestBuilder(this);
    }

    public OkHttpClient initClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            builder.connectTimeout(StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, TimeUnit.MILLISECONDS).readTimeout(StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, TimeUnit.MILLISECONDS).writeTimeout(StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(10, 5L, TimeUnit.MINUTES));
            if (this.sHttpDns != null && (this.sHttpDns instanceof Dns)) {
                builder.dns((Dns) this.sHttpDns);
            }
            addStaticInterceptor(builder);
            addFreeCardProxySelector(builder);
            if (HttpRuntime.getHttpContext() != null && HttpRuntime.getHttpContext().getFallbackConnectDelayMs() > 0) {
                builder.fallbackConnectDelayMs(HttpRuntime.getHttpContext().getFallbackConnectDelayMs());
            }
            if (HttpRuntime.getHttpContext() != null && HttpRuntime.getHttpContext().getEventListener() != null) {
                builder.eventListener(HttpRuntime.getHttpContext().getEventListener());
            }
        } catch (IllegalArgumentException e2) {
            Log.e("HttpManager", " set timeout illegal exception, we will use the 10_000 mills default", e2);
        }
        return builder.build();
    }

    public boolean isNetWorkConnected() {
        return ConnectManager.isNetworkConnected(this.context);
    }

    public boolean isWifi() {
        return ConnectManager.isWifi(this.context);
    }

    public PatchRequest.PatchRequestBuilder patchRequest() {
        return new PatchRequest.PatchRequestBuilder(this);
    }

    public PostByteRequest.PostByteRequestBuilder postByteRequest() {
        return new PostByteRequest.PostByteRequestBuilder(this);
    }

    public PostFileRequest.PostFileRequestBuilder postFileRequest() {
        return new PostFileRequest.PostFileRequestBuilder(this);
    }

    public PostFormRequest.PostFormRequestBuilder postFormRequest() {
        return new PostFormRequest.PostFormRequestBuilder(this);
    }

    public PostMultiPartFormRequest.PostMultiPartFormRequestBuilder postMultiPartRequest() {
        return new PostMultiPartFormRequest.PostMultiPartFormRequestBuilder(this);
    }

    public PostBodyRequest.PostBodyRequestBuilder postRequest() {
        return new PostBodyRequest.PostBodyRequestBuilder(this);
    }

    public PostStringRequest.PostStringRequestBuilder postStringRequest() {
        return new PostStringRequest.PostStringRequestBuilder(this);
    }

    public PutFormRequest.PutFormRequestBuilder putFormRequest() {
        return new PutFormRequest.PutFormRequestBuilder(this);
    }

    public PutBodyRequest.PutBodyRequestBuilder putRequest() {
        return new PutBodyRequest.PutBodyRequestBuilder(this);
    }

    public void setHttpDnsEnable(boolean z) {
        IHttpDns iHttpDns = this.sHttpDns;
        if (iHttpDns != null) {
            iHttpDns.setHttpDnsEnable(z);
        }
    }

    public void setNetworkStat(NetworkStat<Request> networkStat) {
        this.networkStat = networkStat;
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public void setRequestHandler(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }
}
