package com.baidu.searchbox.http;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.searchbox.http.RequestHandler;
import com.baidu.searchbox.http.dns.HttpDns;
import com.baidu.searchbox.http.interceptor.AllRequestsInterceptor;
import com.baidu.searchbox.http.interceptor.ConnReuseProbeInterceptor;
import com.baidu.searchbox.http.interceptor.ExpTraceInterceptor;
import com.baidu.searchbox.http.interceptor.UserAgentInterceptor;
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
import com.baidu.searchbox.http.statistics.NetworkInfoRecord;
import com.baidu.searchbox.http.statistics.NetworkStat;
import com.baidu.searchbox.http.statistics.NetworkStatImpl;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes2.dex */
public abstract class AbstractHttpManager {
    private static final String TAG = "HttpManager";
    private static List<Class<? extends Interceptor>> sExternalInterceptorClass;
    private static List<Class<? extends Interceptor>> sExternalNetworkInterceptorClass;
    private static ProxySelector sProxySelector;
    protected Context context;
    private DnsHelper dnsHelper;
    private HttpDns httpDns;
    private NetworkStat<Request> networkStat;
    protected Handler deliver = new Handler(Looper.getMainLooper());
    private RequestHandler requestHandler = new RequestHandler.Default();
    protected OkHttpClient okHttpClient = initClient();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractHttpManager(Context context) {
        this.context = context.getApplicationContext();
        this.dnsHelper = new DnsHelper(context, false);
        this.httpDns = new HttpDns(this.dnsHelper, false);
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
        if (cls != null && !sExternalNetworkInterceptorClass.contains(cls)) {
            sExternalNetworkInterceptorClass.add(cls);
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
        this.httpDns.setHttpDnsEnable(z);
    }

    public DnsHelper dnsHelper() {
        return this.dnsHelper;
    }

    public void prefetchDnsResult(String str) {
        this.dnsHelper.forceUpdateDomain(str);
    }

    public void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord) {
        if (networkInfoRecord != null) {
            setNetworkStat(new NetworkStatImpl(this.context, networkInfoRecord));
        } else {
            setNetworkStat(null);
        }
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

    protected OkHttpClient initClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            builder.connectTimeout(StatisticConfig.MIN_UPLOAD_INTERVAL, TimeUnit.MILLISECONDS).readTimeout(StatisticConfig.MIN_UPLOAD_INTERVAL, TimeUnit.MILLISECONDS).writeTimeout(StatisticConfig.MIN_UPLOAD_INTERVAL, TimeUnit.MILLISECONDS).dns(this.httpDns).connectionPool(new ConnectionPool(10, 5L, TimeUnit.MINUTES)).addInterceptor(new ExpTraceInterceptor(this.context)).addNetworkInterceptor(new UserAgentInterceptor(this.context)).addNetworkInterceptor(new ConnReuseProbeInterceptor()).addNetworkInterceptor(new AllRequestsInterceptor());
            addStaticInterceptor(builder);
            addFreeCardProxySelector(builder);
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
}
