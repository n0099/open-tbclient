package com.baidu.searchbox.http.request;

import android.os.Handler;
import android.text.TextUtils;
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
    public static final String TAG = "RequestCall";
    public OkHttpClient client;
    public Handler deliver;
    public HttpRequest httpRequest;
    public volatile RequestPriorityParams mRequestPriorityParams;
    public Call realCall;
    public RequestHandler requestHandler;

    public RequestCall(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
        this.client = httpRequest.client;
        this.deliver = httpRequest.deliver;
        this.requestHandler = httpRequest.requestHandler;
        buildCall();
    }

    public <T> Cancelable executeAsync(ResponseCallback<T> responseCallback) {
        return executeAsyncWithHandler(null, responseCallback);
    }

    public <T> Cancelable executeAsyncOnUIBack(ResponseCallback<T> responseCallback) {
        return executeAsyncWithHandler(this.deliver, responseCallback);
    }

    public <T> Cancelable executeStat(StatResponseCallback<T> statResponseCallback) {
        return executeStatWithHandler(null, statResponseCallback);
    }

    public <T> Cancelable executeStatUIBack(StatResponseCallback<T> statResponseCallback) {
        return executeStatWithHandler(this.deliver, statResponseCallback);
    }

    private void beginRequest() {
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

    private void buildCall() {
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

    private void checkExecuteWifiOnly() throws IOException {
        HttpRequest httpRequest = this.httpRequest;
        if (httpRequest.isWifiOnly && !httpRequest.httpManager.isWifi()) {
            throw new IOException(" only allow wifi connected");
        }
    }

    private void executePreCheck() throws IOException {
        checkExecuteWifiOnly();
        RequestHandler requestHandler = this.requestHandler;
        if (requestHandler != null) {
            requestHandler.preExecuteRequest();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFinishReadContentCronet() {
        NetworkStatRecord requestNetStat = this.httpRequest.getRequestNetStat();
        HttpRequest httpRequest = this.httpRequest;
        NetworkStat<Request> networkStat = httpRequest.networkStat;
        if (networkStat != null && requestNetStat != null && requestNetStat.netEngine == 3) {
            networkStat.onFinishReadContent(httpRequest.okRequest, httpRequest.getContentLength());
        }
    }

    @Override // com.baidu.searchbox.http.Cancelable
    public void cancel() {
        Call call = this.realCall;
        if (call != null) {
            call.cancel();
        }
    }

    public StatResponse executeStat() throws IOException {
        return new StatResponse(executeSync(), this.httpRequest.requestNetStat);
    }

    public Response executeSync() throws IOException {
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

    public Call getCall() {
        return this.realCall;
    }

    public HttpRequest getHttpRequest() {
        return this.httpRequest;
    }

    @Override // com.baidu.searchbox.requestpriority.IRequestCall
    public int getRequestFrom() {
        return this.httpRequest.getRequestFrom();
    }

    @Override // com.baidu.searchbox.requestpriority.IRequestCall
    public int getRequestSubFrom() {
        return this.httpRequest.getRequestSubFrom();
    }

    @Override // com.baidu.searchbox.requestpriority.IRequestCall
    public boolean isFinished() {
        return this.httpRequest.isFinished;
    }

    private Response execute() throws IOException {
        IOException wrapNoNetworkExceptionWithDetail;
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
                } catch (NullPointerException e) {
                    if (this.httpRequest.networkStat != null) {
                        this.httpRequest.networkStat.onException(this.httpRequest.okRequest, e);
                    }
                    if (this.httpRequest.requestNetStat != null) {
                        this.httpRequest.requestNetStat.exception = e;
                    }
                    throw e;
                }
            } catch (IOException e2) {
                if (this.httpRequest.httpManager.isNetWorkConnected()) {
                    wrapNoNetworkExceptionWithDetail = e2;
                } else {
                    wrapNoNetworkExceptionWithDetail = ResponseException.wrapNoNetworkExceptionWithDetail(e2);
                }
                if (this.httpRequest.networkStat != null) {
                    this.httpRequest.networkStat.onException(this.httpRequest.okRequest, e2);
                }
                if (this.httpRequest.requestNetStat != null) {
                    this.httpRequest.requestNetStat.exception = wrapNoNetworkExceptionWithDetail;
                }
                throw wrapNoNetworkExceptionWithDetail;
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

    private void recordStatusCode(Request request, int i, String str) {
        if (request != null && StatusCodeException.isStatusCodeMatched(i)) {
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
    public <T> void sendSuccessResult(Handler handler, final ResponseCallback<T> responseCallback, final Response response) {
        try {
            if (this.httpRequest.networkStat != null) {
                this.httpRequest.networkStat.onFinish(this.httpRequest.okRequest, System.currentTimeMillis());
            }
            if (response != null) {
                recordStatusCode(this.httpRequest.okRequest, response.code(), response.message());
            }
            if (responseCallback != null) {
                final T parseResponse = responseCallback.parseResponse(response, response.code());
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.baidu.searchbox.http.request.RequestCall.4
                        @Override // java.lang.Runnable
                        public void run() {
                            Object obj = parseResponse;
                            if (obj != null) {
                                responseCallback.onSuccess(obj, response.code());
                            } else {
                                responseCallback.onFail(new IOException("parse response return null"));
                            }
                            RequestCall.this.onFinishReadContentCronet();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFailResult(Handler handler, final ResponseCallback responseCallback, Exception exc) {
        final Exception wrapNoNetworkExceptionWithDetail;
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
                handler.post(new Runnable() { // from class: com.baidu.searchbox.http.request.RequestCall.1
                    @Override // java.lang.Runnable
                    public void run() {
                        responseCallback.onFail(wrapNoNetworkExceptionWithDetail);
                    }
                });
            } else {
                responseCallback.onFail(wrapNoNetworkExceptionWithDetail);
            }
        }
        this.httpRequest.isFinished = true;
        RequestPriorityStrategy.promoteAndExecuteIfNeeded(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFailResult(Handler handler, final StatResponseCallback statResponseCallback, Exception exc) {
        final Exception wrapNoNetworkExceptionWithDetail;
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
                handler.post(new Runnable() { // from class: com.baidu.searchbox.http.request.RequestCall.2
                    @Override // java.lang.Runnable
                    public void run() {
                        statResponseCallback.onFail(wrapNoNetworkExceptionWithDetail);
                    }
                });
            } else {
                statResponseCallback.onFail(wrapNoNetworkExceptionWithDetail);
            }
        }
        this.httpRequest.isFinished = true;
        RequestPriorityStrategy.promoteAndExecuteIfNeeded(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void sendSuccessResult(Handler handler, final StatResponseCallback<T> statResponseCallback, final Response response) {
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
                final T parseResponse = statResponseCallback.parseResponse(response, response.code(), this.httpRequest.requestNetStat);
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.baidu.searchbox.http.request.RequestCall.3
                        @Override // java.lang.Runnable
                        public void run() {
                            Object obj = parseResponse;
                            if (obj != null) {
                                statResponseCallback.onSuccess(obj, response.code());
                            } else {
                                statResponseCallback.onFail(new IOException("parse response return null"));
                            }
                            RequestCall.this.onFinishReadContentCronet();
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

    private boolean shouldCreateNewRequest() {
        HttpRequest httpRequest = this.httpRequest;
        if (httpRequest.networkStat == null && httpRequest.requestNetStat == null && httpRequest.connectionTimeout <= 0 && httpRequest.writeTimeout <= 0 && httpRequest.readTimeout <= 0 && httpRequest.paramsHandler == null && httpRequest.enableRetry && TextUtils.isEmpty(httpRequest.logTag)) {
            HttpRequest httpRequest2 = this.httpRequest;
            if (httpRequest2.cookieManager == null && httpRequest2.proxy == null && httpRequest2.followRedirects && httpRequest2.followSslRedirects && httpRequest2.getDns() == null && this.httpRequest.pingInterval <= 0) {
                return false;
            }
        }
        return true;
    }

    public <T> void enqueueWithResponseCallback(final Handler handler, final ResponseCallback<T> responseCallback) {
        this.realCall.enqueue(new Callback() { // from class: com.baidu.searchbox.http.request.RequestCall.6
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                RequestCall.this.sendFailResult(handler, responseCallback, iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                RequestCall.this.sendSuccessResult(handler, responseCallback, response);
            }
        });
    }

    public <T> void enqueueWithStatResponseCallback(final Handler handler, final StatResponseCallback<T> statResponseCallback) {
        this.realCall.enqueue(new Callback() { // from class: com.baidu.searchbox.http.request.RequestCall.5
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                RequestCall.this.sendFailResult(handler, statResponseCallback, iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                RequestCall.this.sendSuccessResult(handler, statResponseCallback, response);
            }
        });
    }

    public <T> Cancelable executeAsyncWithHandler(Handler handler, ResponseCallback<T> responseCallback) {
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

    public <T> Cancelable executeStatWithHandler(Handler handler, StatResponseCallback<T> statResponseCallback) {
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

    @Override // com.baidu.searchbox.requestpriority.IRequestCall
    public void priorityEnqueueWithResponseCallback(Object obj, Object obj2) {
        Handler handler;
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

    @Override // com.baidu.searchbox.requestpriority.IRequestCall
    public void priorityEnqueueWithStatResponseCallback(Object obj, Object obj2) {
        Handler handler;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.requestpriority.IRequestCall
    public Response priorityExecuteSync() throws IOException {
        return execute();
    }
}
