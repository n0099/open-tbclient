package com.baidu.searchbox.http.request;

import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.Cancelable;
import com.baidu.searchbox.http.HttpRuntime;
import com.baidu.searchbox.http.IHttpDns;
import com.baidu.searchbox.http.RequestHandler;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.cookie.CookieJarImpl;
import com.baidu.searchbox.http.interceptor.LogInterceptor;
import com.baidu.searchbox.http.interceptor.ParamInterceptor;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.searchbox.http.response.StatusCodeException;
import com.baidu.searchbox.http.statistics.NetworkStat;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class RequestCall implements Cancelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RequestCall";
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient client;
    public Handler deliver;
    public HttpRequest httpRequest;
    public Call realCall;
    public RequestHandler requestHandler;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-655414949, "Lcom/baidu/searchbox/http/request/RequestCall;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-655414949, "Lcom/baidu/searchbox/http/request/RequestCall;");
        }
    }

    public RequestCall(HttpRequest httpRequest) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpRequest};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.httpRequest = httpRequest;
        this.client = httpRequest.client;
        this.deliver = httpRequest.deliver;
        this.requestHandler = httpRequest.requestHandler;
        buildCall();
    }

    private void beginRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            HttpRequest httpRequest = this.httpRequest;
            NetworkStat<Request> networkStat = httpRequest.networkStat;
            if (networkStat != null) {
                networkStat.onStartExecute(httpRequest.okRequest, currentTimeMillis);
                HttpRequest httpRequest2 = this.httpRequest;
                httpRequest2.networkStat.setNetEngine(httpRequest2.okRequest, 2);
            }
            HttpRequest httpRequest3 = this.httpRequest;
            NetworkStatRecord networkStatRecord = httpRequest3.requestNetStat;
            if (networkStatRecord != null) {
                networkStatRecord.startTs = currentTimeMillis;
                networkStatRecord.netEngine = 2;
                networkStatRecord.from = httpRequest3.requestFrom;
                networkStatRecord.bdTraceId = httpRequest3.getBdTraceId();
                HttpRequest httpRequest4 = this.httpRequest;
                httpRequest4.requestNetStat.extraUserInfo = httpRequest4.getExtraUserLog();
            }
        }
    }

    private void buildCall() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            Request okRequest = this.httpRequest.getOkRequest();
            if (shouldCreateNewRequest()) {
                OkHttpClient.Builder newBuilder = this.client.newBuilder();
                HttpRequest httpRequest = this.httpRequest;
                if ((httpRequest.networkStat != null || httpRequest.requestNetStat != null) && HttpRuntime.getHttpContext() != null) {
                    IHttpDns newCloneHttpDns = HttpRuntime.getHttpContext().getNewCloneHttpDns(this.httpRequest);
                    if (HttpRuntime.getHttpContext().forceHttpDnsIPv4OnlyInDualStack(this.httpRequest)) {
                        newCloneHttpDns.setHttpDnsIPv4OnlyEnable(true);
                        newBuilder.connectionPool(this.httpRequest.httpManager.getIPv4OnlyConnectionPool());
                    }
                    if (newCloneHttpDns != null && (newCloneHttpDns instanceof Dns)) {
                        newBuilder.dns((Dns) newCloneHttpDns);
                    }
                }
                int i2 = this.httpRequest.connectionTimeout;
                if (i2 > 0) {
                    newBuilder.connectTimeout(i2, TimeUnit.MILLISECONDS);
                }
                int i3 = this.httpRequest.readTimeout;
                if (i3 > 0) {
                    newBuilder.readTimeout(i3, TimeUnit.MILLISECONDS);
                }
                int i4 = this.httpRequest.writeTimeout;
                if (i4 > 0) {
                    newBuilder.writeTimeout(i4, TimeUnit.MILLISECONDS);
                }
                IAsyncRequestParamsHandler iAsyncRequestParamsHandler = this.httpRequest.paramsHandler;
                if (iAsyncRequestParamsHandler != null) {
                    newBuilder.addInterceptor(new ParamInterceptor(iAsyncRequestParamsHandler));
                }
                if (!this.httpRequest.enableRetry) {
                    newBuilder.retryOnConnectionFailure(false);
                }
                if (!TextUtils.isEmpty(this.httpRequest.logTag)) {
                    HttpRequest httpRequest2 = this.httpRequest;
                    newBuilder.addNetworkInterceptor(new LogInterceptor(httpRequest2.logTag, httpRequest2.logLevel));
                }
                if (this.httpRequest.cookieManager != null) {
                    newBuilder.cookieJar(new CookieJarImpl(this.httpRequest.cookieManager));
                }
                Proxy proxy = this.httpRequest.proxy;
                if (proxy != null) {
                    newBuilder.proxy(proxy);
                }
                HttpRequest httpRequest3 = this.httpRequest;
                if (!httpRequest3.followSslRedirects || !httpRequest3.followRedirects) {
                    newBuilder.followRedirects(this.httpRequest.followRedirects).followSslRedirects(this.httpRequest.followSslRedirects);
                }
                this.realCall = newBuilder.build().newCall(okRequest);
                return;
            }
            this.realCall = this.client.newCall(okRequest);
        }
    }

    private void checkExecuteWifiOnly() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            HttpRequest httpRequest = this.httpRequest;
            if (httpRequest.isWifiOnly && !httpRequest.httpManager.isWifi()) {
                throw new IOException(ResponseException.ONLY_WIFI_EXECUTE);
            }
        }
    }

    private void executePreCheck() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            checkExecuteWifiOnly();
            RequestHandler requestHandler = this.requestHandler;
            if (requestHandler != null) {
                requestHandler.preExecuteRequest();
            }
        }
    }

    private void recordStatusCode(Request request, int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65546, this, request, i2, str) == null) && request != null && StatusCodeException.isStatusCodeMatched(i2)) {
            StatusCodeException statusCodeException = new StatusCodeException(String.format(StatusCodeException.ERROR_MSG_FORMATED, Integer.valueOf(i2), str));
            try {
                if (this.httpRequest.networkStat != null) {
                    this.httpRequest.networkStat.onException(request, statusCodeException);
                }
                if (this.httpRequest.requestNetStat != null) {
                    this.httpRequest.requestNetStat.exception = statusCodeException;
                }
                this.httpRequest.requestNetStat.netType = this.httpRequest.httpManager.getNetworkInfo();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFailResult(Handler handler, ResponseCallback responseCallback, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, this, handler, responseCallback, exc) == null) {
            Exception wrapNoNetworkExceptionWithDetail = this.httpRequest.httpManager.isNetWorkConnected() ? exc : ResponseException.wrapNoNetworkExceptionWithDetail(exc);
            if (this.httpRequest.networkStat != null) {
                long currentTimeMillis = System.currentTimeMillis();
                HttpRequest httpRequest = this.httpRequest;
                httpRequest.networkStat.onException(httpRequest.okRequest, exc);
                HttpRequest httpRequest2 = this.httpRequest;
                httpRequest2.networkStat.onFinish(httpRequest2.okRequest, currentTimeMillis);
            }
            if (responseCallback != null) {
                if (handler != null) {
                    handler.post(new Runnable(this, responseCallback, wrapNoNetworkExceptionWithDetail) { // from class: com.baidu.searchbox.http.request.RequestCall.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ RequestCall this$0;
                        public final /* synthetic */ ResponseCallback val$callback;
                        public final /* synthetic */ Exception val$wrappedException;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, responseCallback, wrapNoNetworkExceptionWithDetail};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$callback = responseCallback;
                            this.val$wrappedException = wrapNoNetworkExceptionWithDetail;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$callback.onFail(this.val$wrappedException);
                            }
                        }
                    });
                } else {
                    responseCallback.onFail(wrapNoNetworkExceptionWithDetail);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void sendSuccessResult(Handler handler, StatResponseCallback<T> statResponseCallback, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, this, handler, statResponseCallback, response) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.httpRequest.networkStat != null) {
                    this.httpRequest.networkStat.onFinish(this.httpRequest.okRequest, currentTimeMillis);
                }
                if (this.httpRequest.requestNetStat != null) {
                    this.httpRequest.requestNetStat.finishTs = currentTimeMillis;
                    this.httpRequest.requestNetStat.netType = this.httpRequest.httpManager.getNetworkInfo();
                }
                if (response != null) {
                    recordStatusCode(this.httpRequest.okRequest, response.code(), response.message());
                }
                if (statResponseCallback != null) {
                    T parseResponse = statResponseCallback.parseResponse(response, response.code(), this.httpRequest.requestNetStat);
                    if (handler != null) {
                        handler.post(new Runnable(this, parseResponse, statResponseCallback, response) { // from class: com.baidu.searchbox.http.request.RequestCall.5
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ RequestCall this$0;
                            public final /* synthetic */ StatResponseCallback val$callback;
                            public final /* synthetic */ Object val$entity;
                            public final /* synthetic */ Response val$response;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, parseResponse, statResponseCallback, response};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$entity = parseResponse;
                                this.val$callback = statResponseCallback;
                                this.val$response = response;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    Object obj = this.val$entity;
                                    if (obj != null) {
                                        this.val$callback.onSuccess(obj, this.val$response.code());
                                    } else {
                                        this.val$callback.onFail(new IOException("parse response return null"));
                                    }
                                }
                            }
                        });
                    } else if (parseResponse != null) {
                        statResponseCallback.onSuccess(parseResponse, response.code());
                    } else {
                        statResponseCallback.onFail(new IOException("parse response return null"));
                    }
                }
            } catch (Exception e2) {
                sendFailResult(handler, statResponseCallback, e2);
            }
        }
    }

    private boolean shouldCreateNewRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            HttpRequest httpRequest = this.httpRequest;
            if (httpRequest.networkStat == null && httpRequest.requestNetStat == null && httpRequest.connectionTimeout <= 0 && httpRequest.writeTimeout <= 0 && httpRequest.readTimeout <= 0 && httpRequest.paramsHandler == null && httpRequest.enableRetry && TextUtils.isEmpty(httpRequest.logTag)) {
                HttpRequest httpRequest2 = this.httpRequest;
                if (httpRequest2.cookieManager == null && httpRequest2.proxy == null && httpRequest2.followRedirects && httpRequest2.followSslRedirects) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.http.Cancelable
    public void cancel() {
        Call call;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (call = this.realCall) == null) {
            return;
        }
        call.cancel();
    }

    public <T> Cancelable executeAsync(ResponseCallback<T> responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseCallback)) == null) ? executeAsyncWithHandler(null, responseCallback) : (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeAsyncOnUIBack(ResponseCallback<T> responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback)) == null) ? executeAsyncWithHandler(this.deliver, responseCallback) : (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeAsyncWithHandler(Handler handler, ResponseCallback<T> responseCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, handler, responseCallback)) == null) {
            beginRequest();
            try {
                executePreCheck();
                this.realCall.enqueue(new Callback(this, handler, responseCallback) { // from class: com.baidu.searchbox.http.request.RequestCall.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RequestCall this$0;
                    public final /* synthetic */ ResponseCallback val$callback;
                    public final /* synthetic */ Handler val$handler;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, handler, responseCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$handler = handler;
                        this.val$callback = responseCallback;
                    }

                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, call, iOException) == null) {
                            this.this$0.sendFailResult(this.val$handler, this.val$callback, iOException);
                        }
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                            this.this$0.sendSuccessResult(this.val$handler, this.val$callback, response);
                        }
                    }
                });
                return this;
            } catch (IOException e2) {
                sendFailResult(handler, responseCallback, e2);
                return this;
            }
        }
        return (Cancelable) invokeLL.objValue;
    }

    public StatResponse executeStat() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new StatResponse(executeSync(), this.httpRequest.requestNetStat) : (StatResponse) invokeV.objValue;
    }

    public <T> Cancelable executeStatUIBack(StatResponseCallback<T> statResponseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, statResponseCallback)) == null) ? executeStatWithHandler(this.deliver, statResponseCallback) : (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeStatWithHandler(Handler handler, StatResponseCallback<T> statResponseCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, handler, statResponseCallback)) == null) {
            beginRequest();
            try {
                executePreCheck();
                this.realCall.enqueue(new Callback(this, handler, statResponseCallback) { // from class: com.baidu.searchbox.http.request.RequestCall.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RequestCall this$0;
                    public final /* synthetic */ StatResponseCallback val$callback;
                    public final /* synthetic */ Handler val$handler;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, handler, statResponseCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$handler = handler;
                        this.val$callback = statResponseCallback;
                    }

                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, call, iOException) == null) {
                            this.this$0.sendFailResult(this.val$handler, this.val$callback, iOException);
                        }
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                            this.this$0.sendSuccessResult(this.val$handler, this.val$callback, response);
                        }
                    }
                });
                return this;
            } catch (IOException e2) {
                sendFailResult(handler, statResponseCallback, e2);
                return this;
            }
        }
        return (Cancelable) invokeLL.objValue;
    }

    public Response executeSync() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            beginRequest();
            try {
                try {
                    try {
                        executePreCheck();
                        Response execute = this.realCall.execute();
                        if (execute != null) {
                            recordStatusCode(this.httpRequest.okRequest, execute.code(), execute.message());
                        }
                        return execute;
                    } catch (IOException e2) {
                        IOException wrapNoNetworkExceptionWithDetail = this.httpRequest.httpManager.isNetWorkConnected() ? e2 : ResponseException.wrapNoNetworkExceptionWithDetail(e2);
                        if (this.httpRequest.networkStat != null) {
                            this.httpRequest.networkStat.onException(this.httpRequest.okRequest, e2);
                        }
                        if (this.httpRequest.requestNetStat != null) {
                            this.httpRequest.requestNetStat.exception = wrapNoNetworkExceptionWithDetail;
                        }
                        throw wrapNoNetworkExceptionWithDetail;
                    }
                } catch (NullPointerException e3) {
                    if (this.httpRequest.networkStat != null) {
                        this.httpRequest.networkStat.onException(this.httpRequest.okRequest, e3);
                    }
                    if (this.httpRequest.requestNetStat != null) {
                        this.httpRequest.requestNetStat.exception = e3;
                    }
                    throw e3;
                }
            } finally {
                long currentTimeMillis = System.currentTimeMillis();
                HttpRequest httpRequest = this.httpRequest;
                NetworkStat<Request> networkStat = httpRequest.networkStat;
                if (networkStat != null) {
                    networkStat.onFinish(httpRequest.okRequest, currentTimeMillis);
                }
                HttpRequest httpRequest2 = this.httpRequest;
                NetworkStatRecord networkStatRecord = httpRequest2.requestNetStat;
                if (networkStatRecord != null) {
                    networkStatRecord.finishTs = currentTimeMillis;
                    networkStatRecord.netType = httpRequest2.httpManager.getNetworkInfo();
                }
            }
        }
        return (Response) invokeV.objValue;
    }

    public Call getCall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.realCall : (Call) invokeV.objValue;
    }

    public <T> Cancelable executeStat(StatResponseCallback<T> statResponseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, statResponseCallback)) == null) ? executeStatWithHandler(null, statResponseCallback) : (Cancelable) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFailResult(Handler handler, StatResponseCallback statResponseCallback, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, this, handler, statResponseCallback, exc) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Exception wrapNoNetworkExceptionWithDetail = this.httpRequest.httpManager.isNetWorkConnected() ? exc : ResponseException.wrapNoNetworkExceptionWithDetail(exc);
            HttpRequest httpRequest = this.httpRequest;
            NetworkStat<Request> networkStat = httpRequest.networkStat;
            if (networkStat != null) {
                networkStat.onException(httpRequest.okRequest, exc);
                HttpRequest httpRequest2 = this.httpRequest;
                httpRequest2.networkStat.onFinish(httpRequest2.okRequest, currentTimeMillis);
            }
            HttpRequest httpRequest3 = this.httpRequest;
            NetworkStatRecord networkStatRecord = httpRequest3.requestNetStat;
            if (networkStatRecord != null) {
                networkStatRecord.exception = wrapNoNetworkExceptionWithDetail;
                networkStatRecord.finishTs = currentTimeMillis;
                networkStatRecord.netType = httpRequest3.httpManager.getNetworkInfo();
                if (TextUtils.isEmpty(this.httpRequest.requestNetStat.clientIP) && !TextUtils.isEmpty(AbstractHttpManager.getClientIP())) {
                    this.httpRequest.requestNetStat.clientIP = AbstractHttpManager.getClientIP();
                }
            }
            if (statResponseCallback != null) {
                if (handler != null) {
                    handler.post(new Runnable(this, statResponseCallback, wrapNoNetworkExceptionWithDetail) { // from class: com.baidu.searchbox.http.request.RequestCall.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ RequestCall this$0;
                        public final /* synthetic */ StatResponseCallback val$callback;
                        public final /* synthetic */ Exception val$wrappedException;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, statResponseCallback, wrapNoNetworkExceptionWithDetail};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$callback = statResponseCallback;
                            this.val$wrappedException = wrapNoNetworkExceptionWithDetail;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$callback.onFail(this.val$wrappedException);
                            }
                        }
                    });
                } else {
                    statResponseCallback.onFail(wrapNoNetworkExceptionWithDetail);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void sendSuccessResult(Handler handler, ResponseCallback<T> responseCallback, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, this, handler, responseCallback, response) == null) {
            try {
                if (this.httpRequest.networkStat != null) {
                    this.httpRequest.networkStat.onFinish(this.httpRequest.okRequest, System.currentTimeMillis());
                }
                if (response != null) {
                    recordStatusCode(this.httpRequest.okRequest, response.code(), response.message());
                }
                if (responseCallback != null) {
                    T parseResponse = responseCallback.parseResponse(response, response.code());
                    if (handler != null) {
                        handler.post(new Runnable(this, parseResponse, responseCallback, response) { // from class: com.baidu.searchbox.http.request.RequestCall.6
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ RequestCall this$0;
                            public final /* synthetic */ ResponseCallback val$callback;
                            public final /* synthetic */ Object val$entity;
                            public final /* synthetic */ Response val$response;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, parseResponse, responseCallback, response};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$entity = parseResponse;
                                this.val$callback = responseCallback;
                                this.val$response = response;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    Object obj = this.val$entity;
                                    if (obj != null) {
                                        this.val$callback.onSuccess(obj, this.val$response.code());
                                    } else {
                                        this.val$callback.onFail(new IOException("parse response return null"));
                                    }
                                }
                            }
                        });
                    } else if (parseResponse != null) {
                        responseCallback.onSuccess(parseResponse, response.code());
                    } else {
                        responseCallback.onFail(new IOException("parse response return null"));
                    }
                }
            } catch (Exception e2) {
                sendFailResult(handler, responseCallback, e2);
            }
        }
    }
}
