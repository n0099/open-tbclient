package com.baidu.searchbox.network;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.searchbox.network.RequestHandler;
import com.baidu.searchbox.network.cookie.CookieJarImpl;
import com.baidu.searchbox.network.cookie.CookieManager;
import com.baidu.searchbox.network.core.Call;
import com.baidu.searchbox.network.core.Dns;
import com.baidu.searchbox.network.core.HttpResourceManager;
import com.baidu.searchbox.network.core.Interceptor;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.RequestClient;
import com.baidu.searchbox.network.request.DeleteRequest;
import com.baidu.searchbox.network.request.GetRequest;
import com.baidu.searchbox.network.request.HeadRequest;
import com.baidu.searchbox.network.request.HttpRequest;
import com.baidu.searchbox.network.request.PostBodyRequest;
import com.baidu.searchbox.network.request.PostByteRequest;
import com.baidu.searchbox.network.request.PostFileRequest;
import com.baidu.searchbox.network.request.PostFormRequest;
import com.baidu.searchbox.network.request.PostMultiPartFormRequest;
import com.baidu.searchbox.network.request.PostStringRequest;
import com.baidu.searchbox.network.request.PutBodyRequest;
import com.baidu.searchbox.network.request.PutFormRequest;
import com.baidu.searchbox.network.statistics.NetworkStat;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public abstract class AbstractHttpManager {
    private static final String TAG = "HttpManager";
    private static List<Class<? extends Interceptor>> sExternalInterceptorClass;
    private static List<Class<? extends Interceptor>> sExternalNetworkInterceptorClass;
    private static ProductUserAgentHandler sProductUserAgent;
    private static ProxySelector sProxySelector;
    protected Context context;
    protected Handler deliver;
    private NetworkStat<Request> networkStat;
    protected RequestClient requestClient;
    private RequestHandler requestHandler;
    private IHttpDns sHttpDns;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractHttpManager(Context context) {
        if (HttpRuntime.getHttpContext() != null) {
            HttpRuntime.getHttpContext().init(this);
            this.sHttpDns = HttpRuntime.getHttpContext().getNewHttpDns();
        }
        this.context = context.getApplicationContext();
        this.deliver = new Handler(Looper.getMainLooper());
        this.requestHandler = new RequestHandler.Default();
        if (HttpResourceManager.getSingleton().getContext() == null) {
            HttpResourceManager.getSingleton().setContext(this.context);
        }
        this.requestClient = initClient();
        if (HttpRuntime.getHttpContext() != null) {
            this.requestClient.setHttpDelegator(HttpRuntime.getHttpContext().getCronetHttpDelegator());
        }
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

    public void cancelAll() {
        if (this.requestClient instanceof RequestClient) {
            this.requestClient.dispatcher().cancelAll();
        }
    }

    public void cancelTag(Object obj) {
        if ((this.requestClient instanceof RequestClient) && obj != null) {
            for (Call call : this.requestClient.dispatcher().queuedCalls()) {
                cancleTagByCall(call, obj);
            }
            for (Call call2 : this.requestClient.dispatcher().runningCalls()) {
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

    public RequestClient getRequestClient() {
        return this.requestClient;
    }

    protected RequestClient initClient() {
        RequestClient.Builder builder = new RequestClient.Builder();
        try {
            builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS);
            if (this.sHttpDns != null && (this.sHttpDns instanceof Dns)) {
                builder.dns(this.sHttpDns);
            }
            addStaticInterceptor(builder);
            addFreeCardProxySelector(builder);
            builder.cookieJar(new CookieJarImpl());
        } catch (IllegalArgumentException e) {
            Log.e(TAG, " set timeout illegal exception, we will use the 10_000 mills default", e);
        }
        return builder.build();
    }

    private void addStaticInterceptor(RequestClient.Builder builder) {
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

    private void addFreeCardProxySelector(RequestClient.Builder builder) {
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
}
