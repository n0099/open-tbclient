package com.baidu.searchbox.http;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes5.dex */
public abstract class AbstractHttpManager {
    private static final String TAG = "HttpManager";
    private static String sClientIP;
    private static List<Class<? extends Interceptor>> sExternalInterceptorClass;
    private static List<Class<? extends Interceptor>> sExternalNetworkInterceptorClass;
    private static ProductUserAgentHandler sProductUserAgent;
    private static ProxySelector sProxySelector;
    protected Context context;
    protected Handler deliver;
    private ConnectionPool ipv4OnlyConnectionPool;
    private NetworkStat<Request> networkStat;
    protected OkHttpClient okHttpClient;
    private RequestHandler requestHandler;
    private IHttpDns sHttpDns;

    /* JADX INFO: Access modifiers changed from: protected */
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

    public IHttpDns getHttpDns() {
        return this.sHttpDns;
    }

    public static void setGlobalProxySelector(ProxySelector proxySelector) {
        if (proxySelector != null) {
            sProxySelector = proxySelector;
        }
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

    public static void addExternalInterceptorClass(Class<? extends Interceptor> cls) {
        if (sExternalInterceptorClass == null) {
            synchronized (AbstractHttpManager.class) {
                if (sExternalInterceptorClass == null) {
                    sExternalInterceptorClass = new ArrayList();
                }
            }
        }
        if (cls != null && !sExternalInterceptorClass.contains(cls)) {
            sExternalInterceptorClass.add(cls);
        }
    }

    public boolean isNetWorkConnected() {
        return ConnectManager.isNetworkConnected(this.context);
    }

    public boolean isWifi() {
        return ConnectManager.isWifi(this.context);
    }

    public String getNetworkInfo() {
        return ConnectManager.getNetworkInfo(this.context);
    }

    public void setHttpDnsEnable(boolean z) {
        if (this.sHttpDns != null) {
            this.sHttpDns.setHttpDnsEnable(z);
        }
    }

    public boolean getHttpDnsEnable() {
        if (this.sHttpDns != null) {
            return this.sHttpDns.getHttpDnsEnable();
        }
        return false;
    }

    public void setNetworkStat(NetworkStat<Request> networkStat) {
        this.networkStat = networkStat;
    }

    public NetworkStat<Request> getNetworkStat() {
        return this.networkStat;
    }

    public GetRequest.GetRequestBuilder getRequest() {
        return new GetRequest.GetRequestBuilder(this);
    }

    public PostFileRequest.PostFileRequestBuilder postFileRequest() {
        return new PostFileRequest.PostFileRequestBuilder(this);
    }

    public PostStringRequest.PostStringRequestBuilder postStringRequest() {
        return new PostStringRequest.PostStringRequestBuilder(this);
    }

    public PostByteRequest.PostByteRequestBuilder postByteRequest() {
        return new PostByteRequest.PostByteRequestBuilder(this);
    }

    public PostFormRequest.PostFormRequestBuilder postFormRequest() {
        return new PostFormRequest.PostFormRequestBuilder(this);
    }

    public PostBodyRequest.PostBodyRequestBuilder postRequest() {
        return new PostBodyRequest.PostBodyRequestBuilder(this);
    }

    public PostMultiPartFormRequest.PostMultiPartFormRequestBuilder postMultiPartRequest() {
        return new PostMultiPartFormRequest.PostMultiPartFormRequestBuilder(this);
    }

    public PutFormRequest.PutFormRequestBuilder putFormRequest() {
        return new PutFormRequest.PutFormRequestBuilder(this);
    }

    public PutBodyRequest.PutBodyRequestBuilder putRequest() {
        return new PutBodyRequest.PutBodyRequestBuilder(this);
    }

    public HeadRequest.HeadRequestBuilder headerRequest() {
        return new HeadRequest.HeadRequestBuilder(this);
    }

    public DeleteRequest.DeleteRequestBuilder deleteRequest() {
        return new DeleteRequest.DeleteRequestBuilder(this);
    }

    public PatchRequest.PatchRequestBuilder patchRequest() {
        return new PatchRequest.PatchRequestBuilder(this);
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

    private void cancleTagByCall(Call call, Object obj) {
        if (obj.equals(call.request().tag())) {
            call.cancel();
        } else if ((call.request().tag() instanceof HttpRequest) && obj.equals(((HttpRequest) call.request().tag()).tag())) {
            call.cancel();
        }
    }

    public OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
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

    /* JADX INFO: Access modifiers changed from: protected */
    public OkHttpClient initClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(10, 5L, TimeUnit.MINUTES));
            if (this.sHttpDns != null && (this.sHttpDns instanceof Dns)) {
                builder.dns((Dns) this.sHttpDns);
            }
            addStaticInterceptor(builder);
            addFreeCardProxySelector(builder);
            if (HttpRuntime.getHttpContext() != null && HttpRuntime.getHttpContext().getFallbackConnectDelayMs() > 0) {
                builder.fallbackConnectDelayMs(HttpRuntime.getHttpContext().getFallbackConnectDelayMs());
            }
        } catch (IllegalArgumentException e) {
            Log.e(TAG, " set timeout illegal exception, we will use the 10_000 mills default", e);
        }
        return builder.build();
    }

    private void addStaticInterceptor(OkHttpClient.Builder builder) {
        if (sExternalNetworkInterceptorClass != null) {
            try {
                for (Class<? extends Interceptor> cls : sExternalNetworkInterceptorClass) {
                    builder.addNetworkInterceptor(cls.getConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (sExternalInterceptorClass != null) {
            try {
                for (Class<? extends Interceptor> cls2 : sExternalInterceptorClass) {
                    builder.addInterceptor(cls2.getConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void addFreeCardProxySelector(OkHttpClient.Builder builder) {
        if (sProxySelector != null) {
            builder.proxySelector(sProxySelector);
        }
    }

    public Handler getDeliver() {
        return this.deliver;
    }

    public RequestHandler getRequestHandler() {
        return this.requestHandler;
    }

    public void setRequestHandler(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public CookieManager getCookieManager(boolean z, boolean z2) {
        return HttpRuntime.getHttpContext().getCookieManager(z, z2);
    }

    public static void setProductUserAgent(ProductUserAgentHandler productUserAgentHandler) {
        sProductUserAgent = productUserAgentHandler;
    }

    public static ProductUserAgentHandler getProductUserAgent() {
        return sProductUserAgent;
    }

    public static String getClientIP() {
        return sClientIP;
    }

    public static void updateClientIP(String str) {
        if (!TextUtils.isEmpty(str)) {
            sClientIP = str;
        }
    }
}
