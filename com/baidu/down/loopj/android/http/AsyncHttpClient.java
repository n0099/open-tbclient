package com.baidu.down.loopj.android.http;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.ConnectManager;
import com.baidu.down.loopj.android.request.handler.UrlConnectionRequestHandler;
import com.baidu.down.loopj.android.urlconnection.ProxyURLConnection;
import com.baidu.down.utils.NamingThreadFactory;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes8.dex */
public class AsyncHttpClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_MAX_CONNECTIONS = 20;
    public static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    public static final int DEFAULT_SOCKET_CONNECT_TIMEOUT = 10000;
    public static final int DEFAULT_SOCKET_TIMEOUT = 30000;
    public static final String ENCODING_GZIP = "gzip";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static String HEADER_CLOSE = "close";
    public static String HEADER_CONNECTION = "Connection";
    public static final String TAG = "AsyncHttpClient";
    public static String USER_AGENT_HTTPCLIENT = "APPSEARCH-DOWN-SDK-HC-V3.x";
    public static String USER_AGENT_HTTPURLCONNECTION = "APPSEARCH-DOWN-SDK-URL-V3.x";
    public static int maxConnections = 20;
    public static int socketTimeout = 30000;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> clientHeaderMap;
    public Context mCtx;
    public ProxyURLConnection mProxyURLConnection;
    public long[] mRetryIntervals;
    public final Map<Context, CopyOnWriteArrayList<WeakReference<Future<AsyncHttpRequest>>>> requestFutureMap;
    public final Map<Context, CopyOnWriteArrayList<WeakReference<AsyncHttpRequest>>> requestMap;
    public ThreadPoolExecutor threadPool;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(958364491, "Lcom/baidu/down/loopj/android/http/AsyncHttpClient;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(958364491, "Lcom/baidu/down/loopj/android/http/AsyncHttpClient;");
        }
    }

    public AsyncHttpClient(Context context, long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCtx = context.getApplicationContext();
        this.mRetryIntervals = jArr;
        ProxyURLConnection proxyURLConnection = new ProxyURLConnection(this.mCtx, jArr);
        this.mProxyURLConnection = proxyURLConnection;
        proxyURLConnection.setFollowRedirects(false);
        this.threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool(new NamingThreadFactory(TAG));
        this.requestFutureMap = new WeakHashMap();
        this.requestMap = new WeakHashMap();
        this.clientHeaderMap = new HashMap();
    }

    public static String getUrlWithQueryString(String str, RequestParams requestParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, requestParams)) == null) {
            if (requestParams != null) {
                String paramString = requestParams.getParamString();
                if (str.indexOf("?") == -1) {
                    return str + "?" + paramString;
                }
                return str + "&" + paramString;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public void addHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.clientHeaderMap.put(str, str2);
        }
    }

    public void cancelRequests(Context context, boolean z, BinaryHttpResponseHandler binaryHttpResponseHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Boolean.valueOf(z), binaryHttpResponseHandler}) == null) {
            if (binaryHttpResponseHandler != null) {
                binaryHttpResponseHandler.stopRunning();
            }
            CopyOnWriteArrayList<WeakReference<AsyncHttpRequest>> remove = this.requestMap.remove(context);
            if (remove != null) {
                for (WeakReference<AsyncHttpRequest> weakReference : remove) {
                    AsyncHttpRequest asyncHttpRequest = weakReference.get();
                    if (asyncHttpRequest != null) {
                        asyncHttpRequest.isInterrupt = true;
                        asyncHttpRequest.cancelRequest();
                    }
                }
            }
            CopyOnWriteArrayList<WeakReference<Future<AsyncHttpRequest>>> remove2 = this.requestFutureMap.remove(context);
            if (remove2 != null) {
                for (WeakReference<Future<AsyncHttpRequest>> weakReference2 : remove2) {
                    Future<AsyncHttpRequest> future = weakReference2.get();
                    if (future != null) {
                        future.cancel(z);
                    }
                }
            }
        }
    }

    public void cancelTaskRequests(Context context, AsyncHttpRequest asyncHttpRequest) {
        CopyOnWriteArrayList<WeakReference<AsyncHttpRequest>> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, asyncHttpRequest) == null) || (copyOnWriteArrayList = this.requestMap.get(context)) == null) {
            return;
        }
        if (asyncHttpRequest != null) {
            asyncHttpRequest.isInterrupt = true;
            asyncHttpRequest.cancelRequest();
        }
        copyOnWriteArrayList.remove(asyncHttpRequest);
    }

    public void get(Context context, String str, Map<String, String> map, RequestParams requestParams, AsyncHttpResponseHandler asyncHttpResponseHandler, MultiSrcRequestParams multiSrcRequestParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, map, requestParams, asyncHttpResponseHandler, multiSrcRequestParams}) == null) {
            performGetURLConnection(context, str, map, requestParams, asyncHttpResponseHandler, multiSrcRequestParams);
        }
    }

    public ConnectManager.NetWorkType getNetWorkType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mProxyURLConnection.getNetWorkType() : (ConnectManager.NetWorkType) invokeV.objValue;
    }

    public List<WeakReference<AsyncHttpRequest>> getTaskHttpRequestList(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            Map<Context, CopyOnWriteArrayList<WeakReference<AsyncHttpRequest>>> map = this.requestMap;
            if (map != null) {
                return map.get(context);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public void interruptRetryWaiting(Context context) {
        CopyOnWriteArrayList<WeakReference<AsyncHttpRequest>> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, context) == null) || (copyOnWriteArrayList = this.requestMap.get(context)) == null) {
            return;
        }
        for (WeakReference<AsyncHttpRequest> weakReference : copyOnWriteArrayList) {
            AsyncHttpRequest asyncHttpRequest = weakReference.get();
            if (asyncHttpRequest != null) {
                asyncHttpRequest.interruptRetryWaiting();
            }
        }
    }

    public boolean isWap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mProxyURLConnection.isWap() : invokeV.booleanValue;
    }

    public void performGetURLConnection(Context context, String str, Map<String, String> map, RequestParams requestParams, AsyncHttpResponseHandler asyncHttpResponseHandler, MultiSrcRequestParams multiSrcRequestParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, str, map, requestParams, asyncHttpResponseHandler, multiSrcRequestParams}) == null) {
            String urlWithQueryString = getUrlWithQueryString(str, requestParams);
            if (map == null) {
                try {
                    map = new HashMap<>();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            Map<String, String> map2 = map;
            if (TextUtils.isEmpty(map2.get("User-Agent"))) {
                map2.put("User-Agent", USER_AGENT_HTTPURLCONNECTION);
            }
            if (asyncHttpResponseHandler instanceof MultiSrcBinaryTaskHandler) {
                sendMultiSrcURLConnectionRequest(urlWithQueryString, asyncHttpResponseHandler, context, str, multiSrcRequestParams, map2);
            } else {
                sendURLConnectionRequest(urlWithQueryString, asyncHttpResponseHandler, context, map2);
            }
        }
    }

    public void sendMultiSrcURLConnectionRequest(String str, AsyncHttpResponseHandler asyncHttpResponseHandler, Context context, String str2, MultiSrcRequestParams multiSrcRequestParams, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, asyncHttpResponseHandler, context, str2, multiSrcRequestParams, map}) == null) {
            MultiSrcAsyncHttpRequest multiSrcAsyncHttpRequest = new MultiSrcAsyncHttpRequest(new UrlConnectionRequestHandler(this.mProxyURLConnection, str, map), asyncHttpResponseHandler, str2, multiSrcRequestParams);
            Future<?> submit = this.threadPool.submit(multiSrcAsyncHttpRequest);
            if (context != null) {
                CopyOnWriteArrayList<WeakReference<Future<AsyncHttpRequest>>> copyOnWriteArrayList = this.requestFutureMap.get(context);
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                    this.requestFutureMap.put(context, copyOnWriteArrayList);
                }
                copyOnWriteArrayList.add(new WeakReference<>(submit));
                CopyOnWriteArrayList<WeakReference<AsyncHttpRequest>> copyOnWriteArrayList2 = this.requestMap.get(context);
                if (copyOnWriteArrayList2 == null) {
                    copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                    this.requestMap.put(context, copyOnWriteArrayList2);
                }
                copyOnWriteArrayList2.add(new WeakReference<>(multiSrcAsyncHttpRequest));
            }
        }
    }

    public void sendURLConnectionRequest(String str, AsyncHttpResponseHandler asyncHttpResponseHandler, Context context, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, str, asyncHttpResponseHandler, context, map) == null) {
            AsyncHttpRequest asyncHttpRequest = new AsyncHttpRequest(new UrlConnectionRequestHandler(this.mProxyURLConnection, str, map), asyncHttpResponseHandler);
            Future<?> submit = this.threadPool.submit(asyncHttpRequest);
            if (context != null) {
                CopyOnWriteArrayList<WeakReference<Future<AsyncHttpRequest>>> copyOnWriteArrayList = this.requestFutureMap.get(context);
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                    this.requestFutureMap.put(context, copyOnWriteArrayList);
                }
                copyOnWriteArrayList.add(new WeakReference<>(submit));
                CopyOnWriteArrayList<WeakReference<AsyncHttpRequest>> copyOnWriteArrayList2 = this.requestMap.get(context);
                if (copyOnWriteArrayList2 == null) {
                    copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                    this.requestMap.put(context, copyOnWriteArrayList2);
                }
                copyOnWriteArrayList2.add(new WeakReference<>(asyncHttpRequest));
            }
        }
    }

    public void setConnectTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mProxyURLConnection.setConnectTimeout(i2);
        }
    }

    public void setThreadPool(ThreadPoolExecutor threadPoolExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, threadPoolExecutor) == null) {
            this.threadPool = threadPoolExecutor;
        }
    }

    public void setTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mProxyURLConnection.setSocketTimeout(i2);
        }
    }

    public void switchProxy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mProxyURLConnection.initProxyHttpClient();
        }
    }
}
