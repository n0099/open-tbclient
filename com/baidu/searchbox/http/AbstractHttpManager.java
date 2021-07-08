package com.baidu.searchbox.http;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HttpManager";
    public static String sClientIP;
    public static List<Class<? extends Interceptor>> sExternalInterceptorClass;
    public static List<Class<? extends Interceptor>> sExternalNetworkInterceptorClass;
    public static ProductUserAgentHandler sProductUserAgent;
    public static ProxySelector sProxySelector;
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;
    public Handler deliver;
    public ConnectionPool ipv4OnlyConnectionPool;
    public NetworkStat<Request> networkStat;
    public OkHttpClient okHttpClient;
    public RequestHandler requestHandler;
    public IHttpDns sHttpDns;

    public AbstractHttpManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, cls) == null) {
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
    }

    public static void addExternalNetworkInterceptorClass(Class<? extends Interceptor> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cls) == null) {
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
    }

    private void addFreeCardProxySelector(OkHttpClient.Builder builder) {
        ProxySelector proxySelector;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, builder) == null) || (proxySelector = sProxySelector) == null) {
            return;
        }
        builder.proxySelector(proxySelector);
    }

    private void addStaticInterceptor(OkHttpClient.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, builder) == null) {
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
    }

    private void cancleTagByCall(Call call, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, call, obj) == null) {
            if (obj.equals(call.request().tag())) {
                call.cancel();
            } else if ((call.request().tag() instanceof HttpRequest) && obj.equals(((HttpRequest) call.request().tag()).tag())) {
                call.cancel();
            }
        }
    }

    public static String getClientIP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? sClientIP : (String) invokeV.objValue;
    }

    public static ProductUserAgentHandler getProductUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? sProductUserAgent : (ProductUserAgentHandler) invokeV.objValue;
    }

    public static void setGlobalProxySelector(ProxySelector proxySelector) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, proxySelector) == null) || proxySelector == null) {
            return;
        }
        sProxySelector = proxySelector;
    }

    public static void setProductUserAgent(ProductUserAgentHandler productUserAgentHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, productUserAgentHandler) == null) {
            sProductUserAgent = productUserAgentHandler;
        }
    }

    public static void updateClientIP(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        sClientIP = str;
    }

    public void cancelAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            getOkHttpClient().dispatcher().cancelAll();
        }
    }

    public void cancelTag(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) || obj == null) {
            return;
        }
        for (Call call : getOkHttpClient().dispatcher().queuedCalls()) {
            cancleTagByCall(call, obj);
        }
        for (Call call2 : getOkHttpClient().dispatcher().runningCalls()) {
            cancleTagByCall(call2, obj);
        }
    }

    public DeleteRequest.DeleteRequestBuilder deleteRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new DeleteRequest.DeleteRequestBuilder(this) : (DeleteRequest.DeleteRequestBuilder) invokeV.objValue;
    }

    public CookieManager getCookieManager(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? HttpRuntime.getHttpContext().getCookieManager(z, z2) : (CookieManager) invokeCommon.objValue;
    }

    public Handler getDeliver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.deliver : (Handler) invokeV.objValue;
    }

    public IHttpDns getHttpDns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.sHttpDns : (IHttpDns) invokeV.objValue;
    }

    public boolean getHttpDnsEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            IHttpDns iHttpDns = this.sHttpDns;
            if (iHttpDns != null) {
                return iHttpDns.getHttpDnsEnable();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ConnectionPool getIPv4OnlyConnectionPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.ipv4OnlyConnectionPool == null) {
                synchronized (AbstractHttpManager.class) {
                    if (this.ipv4OnlyConnectionPool == null) {
                        this.ipv4OnlyConnectionPool = new ConnectionPool(10, 5L, TimeUnit.MINUTES);
                    }
                }
            }
            return this.ipv4OnlyConnectionPool;
        }
        return (ConnectionPool) invokeV.objValue;
    }

    public String getNetworkInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ConnectManager.getNetworkInfo(this.context) : (String) invokeV.objValue;
    }

    public NetworkStat<Request> getNetworkStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.networkStat : (NetworkStat) invokeV.objValue;
    }

    public OkHttpClient getOkHttpClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.okHttpClient : (OkHttpClient) invokeV.objValue;
    }

    public GetRequest.GetRequestBuilder getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new GetRequest.GetRequestBuilder(this) : (GetRequest.GetRequestBuilder) invokeV.objValue;
    }

    public RequestHandler getRequestHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.requestHandler : (RequestHandler) invokeV.objValue;
    }

    public HeadRequest.HeadRequestBuilder headerRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new HeadRequest.HeadRequestBuilder(this) : (HeadRequest.HeadRequestBuilder) invokeV.objValue;
    }

    public OkHttpClient initClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
                if (HttpRuntime.getHttpContext() != null && HttpRuntime.getHttpContext().getEventListener() != null) {
                    builder.eventListener(HttpRuntime.getHttpContext().getEventListener());
                }
            } catch (IllegalArgumentException e2) {
                Log.e("HttpManager", " set timeout illegal exception, we will use the 10_000 mills default", e2);
            }
            return builder.build();
        }
        return (OkHttpClient) invokeV.objValue;
    }

    public boolean isNetWorkConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? ConnectManager.isNetworkConnected(this.context) : invokeV.booleanValue;
    }

    public boolean isWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? ConnectManager.isWifi(this.context) : invokeV.booleanValue;
    }

    public PatchRequest.PatchRequestBuilder patchRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new PatchRequest.PatchRequestBuilder(this) : (PatchRequest.PatchRequestBuilder) invokeV.objValue;
    }

    public PostByteRequest.PostByteRequestBuilder postByteRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? new PostByteRequest.PostByteRequestBuilder(this) : (PostByteRequest.PostByteRequestBuilder) invokeV.objValue;
    }

    public PostFileRequest.PostFileRequestBuilder postFileRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? new PostFileRequest.PostFileRequestBuilder(this) : (PostFileRequest.PostFileRequestBuilder) invokeV.objValue;
    }

    public PostFormRequest.PostFormRequestBuilder postFormRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? new PostFormRequest.PostFormRequestBuilder(this) : (PostFormRequest.PostFormRequestBuilder) invokeV.objValue;
    }

    public PostMultiPartFormRequest.PostMultiPartFormRequestBuilder postMultiPartRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? new PostMultiPartFormRequest.PostMultiPartFormRequestBuilder(this) : (PostMultiPartFormRequest.PostMultiPartFormRequestBuilder) invokeV.objValue;
    }

    public PostBodyRequest.PostBodyRequestBuilder postRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? new PostBodyRequest.PostBodyRequestBuilder(this) : (PostBodyRequest.PostBodyRequestBuilder) invokeV.objValue;
    }

    public PostStringRequest.PostStringRequestBuilder postStringRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? new PostStringRequest.PostStringRequestBuilder(this) : (PostStringRequest.PostStringRequestBuilder) invokeV.objValue;
    }

    public PutFormRequest.PutFormRequestBuilder putFormRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? new PutFormRequest.PutFormRequestBuilder(this) : (PutFormRequest.PutFormRequestBuilder) invokeV.objValue;
    }

    public PutBodyRequest.PutBodyRequestBuilder putRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? new PutBodyRequest.PutBodyRequestBuilder(this) : (PutBodyRequest.PutBodyRequestBuilder) invokeV.objValue;
    }

    public void setHttpDnsEnable(boolean z) {
        IHttpDns iHttpDns;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || (iHttpDns = this.sHttpDns) == null) {
            return;
        }
        iHttpDns.setHttpDnsEnable(z);
    }

    public void setNetworkStat(NetworkStat<Request> networkStat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, networkStat) == null) {
            this.networkStat = networkStat;
        }
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, okHttpClient) == null) {
            this.okHttpClient = okHttpClient;
        }
    }

    public void setRequestHandler(RequestHandler requestHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, requestHandler) == null) {
            this.requestHandler = requestHandler;
        }
    }
}
