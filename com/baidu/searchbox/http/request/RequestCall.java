package com.baidu.searchbox.http.request;

import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.Cancelable;
import com.baidu.searchbox.http.HttpRuntime;
import com.baidu.searchbox.http.IHttpDns;
import com.baidu.searchbox.http.RequestHandler;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.cookie.CookieJarImpl;
import com.baidu.searchbox.http.interceptor.CronetInterceptor;
import com.baidu.searchbox.http.interceptor.LogInterceptor;
import com.baidu.searchbox.http.interceptor.ParamInterceptor;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.searchbox.http.response.StatusCodeException;
import com.baidu.searchbox.http.statistics.NetworkStat;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.requestpriority.IRequestCall;
import com.baidu.searchbox.requestpriority.RequestPriorityParams;
import com.baidu.searchbox.requestpriority.RequestPriorityStrategy;
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
/* loaded from: classes2.dex */
public class RequestCall implements Cancelable, IRequestCall {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RequestCall";
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient client;
    public Handler deliver;
    public HttpRequest httpRequest;
    public volatile RequestPriorityParams mRequestPriorityParams;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public <T> Cancelable executeAsync(ResponseCallback<T> responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, responseCallback)) == null) {
            return executeAsyncWithHandler(null, responseCallback);
        }
        return (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeAsyncOnUIBack(ResponseCallback<T> responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, responseCallback)) == null) {
            return executeAsyncWithHandler(this.deliver, responseCallback);
        }
        return (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeStat(StatResponseCallback<T> statResponseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, statResponseCallback)) == null) {
            return executeStatWithHandler(null, statResponseCallback);
        }
        return (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeStatUIBack(StatResponseCallback<T> statResponseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, statResponseCallback)) == null) {
            return executeStatWithHandler(this.deliver, statResponseCallback);
        }
        return (Cancelable) invokeL.objValue;
    }

    private void beginRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
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

    private boolean shouldCreateNewRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            HttpRequest httpRequest = this.httpRequest;
            if (httpRequest.networkStat == null && httpRequest.requestNetStat == null && httpRequest.connectionTimeout <= 0 && httpRequest.writeTimeout <= 0 && httpRequest.readTimeout <= 0 && httpRequest.paramsHandler == null && httpRequest.enableRetry && TextUtils.isEmpty(httpRequest.logTag)) {
                HttpRequest httpRequest2 = this.httpRequest;
                if (httpRequest2.cookieManager == null && httpRequest2.proxy == null && httpRequest2.followRedirects && httpRequest2.followSslRedirects && httpRequest2.getDns() == null && this.httpRequest.pingInterval <= 0) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private void buildCall() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
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
                    if (newCloneHttpDns != null && (newCloneHttpDns instanceof Dns) && this.httpRequest.getDns() == null) {
                        newBuilder.dns((Dns) newCloneHttpDns);
                    }
                }
                if (this.httpRequest.getDns() != null) {
                    newBuilder.dns(this.httpRequest.getDns());
                }
                int i = this.httpRequest.connectionTimeout;
                if (i > 0) {
                    newBuilder.connectTimeout(i, TimeUnit.MILLISECONDS);
                }
                int i2 = this.httpRequest.readTimeout;
                if (i2 > 0) {
                    newBuilder.readTimeout(i2, TimeUnit.MILLISECONDS);
                }
                int i3 = this.httpRequest.writeTimeout;
                if (i3 > 0) {
                    newBuilder.writeTimeout(i3, TimeUnit.MILLISECONDS);
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
                CronetInterceptor cronetInterceptor = null;
                if (this.httpRequest.isOldHttpUseTurbonet()) {
                    cronetInterceptor = new CronetInterceptor();
                    newBuilder.addInterceptor(cronetInterceptor);
                }
                if (this.httpRequest.cookieManager != null) {
                    newBuilder.cookieJar(new CookieJarImpl(this.httpRequest.cookieManager));
                    NetworkStatRecord requestNetStat = this.httpRequest.getRequestNetStat();
                    if (requestNetStat != null) {
                        requestNetStat.hasCookieManager = true;
                    }
                }
                Proxy proxy = this.httpRequest.proxy;
                if (proxy != null) {
                    newBuilder.proxy(proxy);
                }
                HttpRequest httpRequest3 = this.httpRequest;
                if (!httpRequest3.followSslRedirects || !httpRequest3.followRedirects) {
                    newBuilder.followRedirects(this.httpRequest.followRedirects).followSslRedirects(this.httpRequest.followSslRedirects);
                }
                int i4 = this.httpRequest.pingInterval;
                if (i4 > 0) {
                    newBuilder.pingInterval(i4, TimeUnit.MILLISECONDS);
                }
                OkHttpClient build = newBuilder.build();
                if (cronetInterceptor != null) {
                    cronetInterceptor.setClient(build);
                }
                this.realCall = build.newCall(okRequest);
                return;
            }
            this.realCall = this.client.newCall(okRequest);
        }
    }

    private void checkExecuteWifiOnly() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            HttpRequest httpRequest = this.httpRequest;
            if (httpRequest.isWifiOnly && !httpRequest.httpManager.isWifi()) {
                throw new IOException(" only allow wifi connected");
            }
        }
    }

    private void executePreCheck() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            checkExecuteWifiOnly();
            RequestHandler requestHandler = this.requestHandler;
            if (requestHandler != null) {
                requestHandler.preExecuteRequest();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFinishReadContentCronet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            NetworkStatRecord requestNetStat = this.httpRequest.getRequestNetStat();
            HttpRequest httpRequest = this.httpRequest;
            NetworkStat<Request> networkStat = httpRequest.networkStat;
            if (networkStat != null && requestNetStat != null && requestNetStat.netEngine == 3) {
                networkStat.onFinishReadContent(httpRequest.okRequest, httpRequest.getContentLength());
            }
        }
    }

    @Override // com.baidu.searchbox.http.Cancelable
    public void cancel() {
        Call call;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (call = this.realCall) != null) {
            call.cancel();
        }
    }

    public StatResponse executeStat() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new StatResponse(executeSync(), this.httpRequest.requestNetStat);
        }
        return (StatResponse) invokeV.objValue;
    }

    public Call getCall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.realCall;
        }
        return (Call) invokeV.objValue;
    }

    public HttpRequest getHttpRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.httpRequest;
        }
        return (HttpRequest) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.requestpriority.IRequestCall
    public int getRequestFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.httpRequest.getRequestFrom();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.requestpriority.IRequestCall
    public int getRequestSubFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.httpRequest.getRequestSubFrom();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.requestpriority.IRequestCall
    public boolean isFinished() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.httpRequest.isFinished;
        }
        return invokeV.booleanValue;
    }

    private Response execute() throws IOException {
        InterceptResult invokeV;
        IOException wrapNoNetworkExceptionWithDetail;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            beginRequest();
            try {
                try {
                    executePreCheck();
                    Response execute = this.realCall.execute();
                    if (execute != null) {
                        recordStatusCode(this.httpRequest.okRequest, execute.code(), execute.message());
                    }
                    return execute;
                } catch (IOException e) {
                    if (this.httpRequest.httpManager.isNetWorkConnected()) {
                        wrapNoNetworkExceptionWithDetail = e;
                    } else {
                        wrapNoNetworkExceptionWithDetail = ResponseException.wrapNoNetworkExceptionWithDetail(e);
                    }
                    if (this.httpRequest.networkStat != null) {
                        this.httpRequest.networkStat.onException(this.httpRequest.okRequest, e);
                    }
                    if (this.httpRequest.requestNetStat != null) {
                        this.httpRequest.requestNetStat.exception = wrapNoNetworkExceptionWithDetail;
                    }
                    throw wrapNoNetworkExceptionWithDetail;
                } catch (NullPointerException e2) {
                    if (this.httpRequest.networkStat != null) {
                        this.httpRequest.networkStat.onException(this.httpRequest.okRequest, e2);
                    }
                    if (this.httpRequest.requestNetStat != null) {
                        this.httpRequest.requestNetStat.exception = e2;
                    }
                    throw e2;
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
                    this.httpRequest.requestNetStat.getNetworkInfoTs = System.currentTimeMillis() - currentTimeMillis;
                }
                this.httpRequest.isFinished = true;
                RequestPriorityStrategy.promoteAndExecuteIfNeeded(this);
            }
        }
        return (Response) invokeV.objValue;
    }

    private void recordStatusCode(Request request, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65549, this, request, i, str) == null) && request != null && StatusCodeException.isStatusCodeMatched(i)) {
            StatusCodeException statusCodeException = new StatusCodeException(String.format("Server statusCode Error; statusCode=%s; response.message=%s", Integer.valueOf(i), str));
            try {
                if (this.httpRequest.networkStat != null) {
                    this.httpRequest.networkStat.onException(request, statusCodeException);
                }
                if (this.httpRequest.requestNetStat != null) {
                    this.httpRequest.requestNetStat.exception = statusCodeException;
                }
                long currentTimeMillis = System.currentTimeMillis();
                this.httpRequest.requestNetStat.netType = this.httpRequest.httpManager.getNetworkInfo();
                this.httpRequest.requestNetStat.getNetworkInfoTs = System.currentTimeMillis() - currentTimeMillis;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFailResult(Handler handler, StatResponseCallback statResponseCallback, Exception exc) {
        Exception wrapNoNetworkExceptionWithDetail;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, this, handler, statResponseCallback, exc) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.httpRequest.httpManager.isNetWorkConnected()) {
                wrapNoNetworkExceptionWithDetail = exc;
            } else {
                wrapNoNetworkExceptionWithDetail = ResponseException.wrapNoNetworkExceptionWithDetail(exc);
            }
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
                this.httpRequest.requestNetStat.getNetworkInfoTs = System.currentTimeMillis() - currentTimeMillis;
                if (TextUtils.isEmpty(this.httpRequest.requestNetStat.clientIP) && !TextUtils.isEmpty(AbstractHttpManager.getClientIP())) {
                    this.httpRequest.requestNetStat.clientIP = AbstractHttpManager.getClientIP();
                }
            }
            if (statResponseCallback != null) {
                if (handler != null) {
                    handler.post(new Runnable(this, statResponseCallback, wrapNoNetworkExceptionWithDetail) { // from class: com.baidu.searchbox.http.request.RequestCall.2
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
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
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
            this.httpRequest.isFinished = true;
            RequestPriorityStrategy.promoteAndExecuteIfNeeded(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void sendSuccessResult(Handler handler, ResponseCallback<T> responseCallback, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, this, handler, responseCallback, response) == null) {
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
                        handler.post(new Runnable(this, parseResponse, responseCallback, response) { // from class: com.baidu.searchbox.http.request.RequestCall.4
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
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
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
                                    this.this$0.onFinishReadContentCronet();
                                }
                            }
                        });
                    } else {
                        if (parseResponse != null) {
                            responseCallback.onSuccess(parseResponse, response.code());
                        } else {
                            responseCallback.onFail(new IOException("parse response return null"));
                        }
                        onFinishReadContentCronet();
                    }
                }
                this.httpRequest.isFinished = true;
                RequestPriorityStrategy.promoteAndExecuteIfNeeded(this);
            } catch (Exception e) {
                sendFailResult(handler, responseCallback, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFailResult(Handler handler, ResponseCallback responseCallback, Exception exc) {
        Exception wrapNoNetworkExceptionWithDetail;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, this, handler, responseCallback, exc) == null) {
            if (this.httpRequest.httpManager.isNetWorkConnected()) {
                wrapNoNetworkExceptionWithDetail = exc;
            } else {
                wrapNoNetworkExceptionWithDetail = ResponseException.wrapNoNetworkExceptionWithDetail(exc);
            }
            if (this.httpRequest.networkStat != null) {
                long currentTimeMillis = System.currentTimeMillis();
                HttpRequest httpRequest = this.httpRequest;
                httpRequest.networkStat.onException(httpRequest.okRequest, exc);
                HttpRequest httpRequest2 = this.httpRequest;
                httpRequest2.networkStat.onFinish(httpRequest2.okRequest, currentTimeMillis);
            }
            if (responseCallback != null) {
                if (handler != null) {
                    handler.post(new Runnable(this, responseCallback, wrapNoNetworkExceptionWithDetail) { // from class: com.baidu.searchbox.http.request.RequestCall.1
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
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
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
            this.httpRequest.isFinished = true;
            RequestPriorityStrategy.promoteAndExecuteIfNeeded(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void sendSuccessResult(Handler handler, StatResponseCallback<T> statResponseCallback, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, this, handler, statResponseCallback, response) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.httpRequest.networkStat != null) {
                    this.httpRequest.networkStat.onFinish(this.httpRequest.okRequest, currentTimeMillis);
                }
                if (this.httpRequest.requestNetStat != null) {
                    this.httpRequest.requestNetStat.finishTs = currentTimeMillis;
                    this.httpRequest.requestNetStat.netType = this.httpRequest.httpManager.getNetworkInfo();
                    this.httpRequest.requestNetStat.getNetworkInfoTs = System.currentTimeMillis() - currentTimeMillis;
                }
                if (response != null) {
                    recordStatusCode(this.httpRequest.okRequest, response.code(), response.message());
                }
                if (statResponseCallback != null) {
                    T parseResponse = statResponseCallback.parseResponse(response, response.code(), this.httpRequest.requestNetStat);
                    if (handler != null) {
                        handler.post(new Runnable(this, parseResponse, statResponseCallback, response) { // from class: com.baidu.searchbox.http.request.RequestCall.3
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
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
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
                                    this.this$0.onFinishReadContentCronet();
                                }
                            }
                        });
                    } else {
                        if (parseResponse != null) {
                            statResponseCallback.onSuccess(parseResponse, response.code());
                        } else {
                            statResponseCallback.onFail(new IOException("parse response return null"));
                        }
                        onFinishReadContentCronet();
                    }
                }
                this.httpRequest.isFinished = true;
                RequestPriorityStrategy.promoteAndExecuteIfNeeded(this);
            } catch (Exception e) {
                sendFailResult(handler, statResponseCallback, e);
            }
        }
    }

    public <T> void enqueueWithResponseCallback(Handler handler, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, handler, responseCallback) == null) {
            this.realCall.enqueue(new Callback(this, handler, responseCallback) { // from class: com.baidu.searchbox.http.request.RequestCall.6
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 != null && interceptable2.invokeLL(1048576, this, call, iOException) != null) {
                        return;
                    }
                    this.this$0.sendFailResult(this.val$handler, this.val$callback, iOException);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) != null) {
                        return;
                    }
                    this.this$0.sendSuccessResult(this.val$handler, this.val$callback, response);
                }
            });
        }
    }

    public <T> void enqueueWithStatResponseCallback(Handler handler, StatResponseCallback<T> statResponseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, handler, statResponseCallback) == null) {
            this.realCall.enqueue(new Callback(this, handler, statResponseCallback) { // from class: com.baidu.searchbox.http.request.RequestCall.5
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 != null && interceptable2.invokeLL(1048576, this, call, iOException) != null) {
                        return;
                    }
                    this.this$0.sendFailResult(this.val$handler, this.val$callback, iOException);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) != null) {
                        return;
                    }
                    this.this$0.sendSuccessResult(this.val$handler, this.val$callback, response);
                }
            });
        }
    }

    public <T> Cancelable executeAsyncWithHandler(Handler handler, ResponseCallback<T> responseCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, handler, responseCallback)) == null) {
            beginRequest();
            try {
                executePreCheck();
                if (RequestPriorityStrategy.isRequestPriorityEnabled()) {
                    RequestPriorityStrategy.enqueueWithResponseCallback(this, handler, responseCallback);
                } else {
                    enqueueWithResponseCallback(handler, responseCallback);
                }
                return this;
            } catch (IOException e) {
                sendFailResult(handler, responseCallback, e);
                return this;
            }
        }
        return (Cancelable) invokeLL.objValue;
    }

    public <T> Cancelable executeStatWithHandler(Handler handler, StatResponseCallback<T> statResponseCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, handler, statResponseCallback)) == null) {
            beginRequest();
            try {
                executePreCheck();
                if (RequestPriorityStrategy.isRequestPriorityEnabled()) {
                    RequestPriorityStrategy.enqueueWithStatResponseCallback(this, handler, statResponseCallback);
                } else {
                    enqueueWithStatResponseCallback(handler, statResponseCallback);
                }
                return this;
            } catch (IOException e) {
                sendFailResult(handler, statResponseCallback, e);
                return this;
            }
        }
        return (Cancelable) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.requestpriority.IRequestCall
    public void priorityEnqueueWithResponseCallback(Object obj, Object obj2) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, obj, obj2) == null) {
            if (obj instanceof Handler) {
                handler = (Handler) obj;
            } else {
                handler = null;
            }
            if (obj2 instanceof ResponseCallback) {
                enqueueWithResponseCallback(handler, (ResponseCallback) obj2);
            } else {
                enqueueWithResponseCallback(handler, null);
            }
        }
    }

    @Override // com.baidu.searchbox.requestpriority.IRequestCall
    public void priorityEnqueueWithStatResponseCallback(Object obj, Object obj2) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, obj, obj2) == null) {
            if (obj instanceof Handler) {
                handler = (Handler) obj;
            } else {
                handler = null;
            }
            if (obj2 instanceof StatResponseCallback) {
                enqueueWithStatResponseCallback(handler, (StatResponseCallback) obj2);
            } else {
                enqueueWithStatResponseCallback(handler, null);
            }
        }
    }

    public Response executeSync() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (RequestPriorityStrategy.isRequestPriorityEnabled()) {
                try {
                    Object executeSync = RequestPriorityStrategy.executeSync(this);
                    if (executeSync instanceof Response) {
                        return (Response) executeSync;
                    }
                    return null;
                } catch (Exception e) {
                    throw new IOException(e.getMessage(), e);
                }
            }
            return execute();
        }
        return (Response) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.requestpriority.IRequestCall
    public Response priorityExecuteSync() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return execute();
        }
        return (Response) invokeV.objValue;
    }
}
