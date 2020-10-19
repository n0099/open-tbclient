package com.baidu.searchbox.http.request;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.searchbox.http.Cancelable;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.HttpRuntime;
import com.baidu.searchbox.http.IHttpDns;
import com.baidu.searchbox.http.RequestHandler;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.cookie.CookieJarImpl;
import com.baidu.searchbox.http.interceptor.LogInterceptor;
import com.baidu.searchbox.http.interceptor.ParamInterceptor;
import com.baidu.searchbox.http.response.ResponseException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes15.dex */
public class RequestCall implements Cancelable {
    private static final String TAG = RequestCall.class.getSimpleName();
    private OkHttpClient client;
    private Handler deliver;
    private HttpRequest httpRequest;
    private Call realCall;
    private RequestHandler requestHandler;

    public RequestCall(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
        this.client = httpRequest.client;
        this.deliver = httpRequest.deliver;
        this.requestHandler = httpRequest.requestHandler;
        buildCall();
    }

    private boolean shouldCreateNewRequest() {
        return (this.httpRequest.networkStat == null && this.httpRequest.requestNetStat == null && this.httpRequest.connectionTimeout <= 0 && this.httpRequest.writeTimeout <= 0 && this.httpRequest.readTimeout <= 0 && this.httpRequest.paramsHandler == null && this.httpRequest.enableRetry && TextUtils.isEmpty(this.httpRequest.logTag) && this.httpRequest.cookieManager == null && this.httpRequest.proxy == null && this.httpRequest.followRedirects && this.httpRequest.followSslRedirects) ? false : true;
    }

    private void buildCall() {
        Request okRequest = this.httpRequest.getOkRequest();
        if (shouldCreateNewRequest()) {
            OkHttpClient.Builder newBuilder = this.client.newBuilder();
            if ((this.httpRequest.networkStat != null || this.httpRequest.requestNetStat != null) && HttpRuntime.getHttpContext() != null) {
                IHttpDns newCloneHttpDns = HttpRuntime.getHttpContext().getNewCloneHttpDns(this.httpRequest);
                if (HttpRuntime.getHttpContext().forceHttpDnsIPv4OnlyInDualStack(this.httpRequest)) {
                    newCloneHttpDns.setHttpDnsIPv4OnlyEnable(true);
                    newBuilder.connectionPool(this.httpRequest.httpManager.getIPv4OnlyConnectionPool());
                }
                if (newCloneHttpDns != null && (newCloneHttpDns instanceof Dns)) {
                    newBuilder.dns((Dns) newCloneHttpDns);
                }
            }
            if (this.httpRequest.connectionTimeout > 0) {
                newBuilder.connectTimeout(this.httpRequest.connectionTimeout, TimeUnit.MILLISECONDS);
            }
            if (this.httpRequest.readTimeout > 0) {
                newBuilder.readTimeout(this.httpRequest.readTimeout, TimeUnit.MILLISECONDS);
            }
            if (this.httpRequest.writeTimeout > 0) {
                newBuilder.writeTimeout(this.httpRequest.writeTimeout, TimeUnit.MILLISECONDS);
            }
            if (this.httpRequest.paramsHandler != null) {
                newBuilder.addInterceptor(new ParamInterceptor(this.httpRequest.paramsHandler));
            }
            if (!this.httpRequest.enableRetry) {
                newBuilder.retryOnConnectionFailure(false);
            }
            if (!TextUtils.isEmpty(this.httpRequest.logTag)) {
                newBuilder.addNetworkInterceptor(new LogInterceptor(this.httpRequest.logTag, this.httpRequest.logLevel));
            }
            if (this.httpRequest.cookieManager != null) {
                newBuilder.cookieJar(new CookieJarImpl(this.httpRequest.cookieManager));
            }
            if (this.httpRequest.proxy != null) {
                newBuilder.proxy(this.httpRequest.proxy);
            }
            if (!this.httpRequest.followSslRedirects || !this.httpRequest.followRedirects) {
                newBuilder.followRedirects(this.httpRequest.followRedirects).followSslRedirects(this.httpRequest.followSslRedirects);
            }
            this.realCall = newBuilder.build().newCall(okRequest);
            return;
        }
        this.realCall = this.client.newCall(okRequest);
    }

    public Call getCall() {
        return this.realCall;
    }

    private void checkExecuteWifiOnly() throws IOException {
        if (this.httpRequest.isWifiOnly && !this.httpRequest.httpManager.isWifi()) {
            throw new IOException(" only allow wifi connected");
        }
    }

    private void executePreCheck() throws IOException {
        checkExecuteWifiOnly();
        if (this.requestHandler != null) {
            this.requestHandler.preExecuteRequest();
        }
    }

    public Response executeSync() throws IOException {
        beginRequest();
        try {
            try {
                executePreCheck();
                return this.realCall.execute();
            } catch (IOException e) {
                IOException wrapNoNetworkExceptionWithDetail = this.httpRequest.httpManager.isNetWorkConnected() ? e : ResponseException.wrapNoNetworkExceptionWithDetail(e);
                if (this.httpRequest.networkStat != null) {
                    this.httpRequest.networkStat.onException(this.httpRequest.okRequest, e);
                }
                if (this.httpRequest.requestNetStat != null) {
                    this.httpRequest.requestNetStat.exception = wrapNoNetworkExceptionWithDetail;
                }
                throw wrapNoNetworkExceptionWithDetail;
            }
        } finally {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.httpRequest.networkStat != null) {
                this.httpRequest.networkStat.onFinish(this.httpRequest.okRequest, currentTimeMillis);
            }
            if (this.httpRequest.requestNetStat != null) {
                this.httpRequest.requestNetStat.finishTs = currentTimeMillis;
                this.httpRequest.requestNetStat.netType = this.httpRequest.httpManager.getNetworkInfo();
            }
        }
    }

    public StatResponse executeStat() throws IOException {
        return new StatResponse(executeSync(), this.httpRequest.requestNetStat);
    }

    public <T> Cancelable executeStat(StatResponseCallback<T> statResponseCallback) {
        return executeStatWithHandler(null, statResponseCallback);
    }

    public <T> Cancelable executeStatUIBack(StatResponseCallback<T> statResponseCallback) {
        return executeStatWithHandler(this.deliver, statResponseCallback);
    }

    public <T> Cancelable executeStatWithHandler(final Handler handler, final StatResponseCallback<T> statResponseCallback) {
        beginRequest();
        try {
            executePreCheck();
            this.realCall.enqueue(new Callback() { // from class: com.baidu.searchbox.http.request.RequestCall.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    RequestCall.this.sendFailResult(handler, statResponseCallback, iOException);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    RequestCall.this.sendSuccessResult(handler, statResponseCallback, response);
                }
            });
        } catch (IOException e) {
            sendFailResult(handler, statResponseCallback, e);
        }
        return this;
    }

    public <T> Cancelable executeAsync(ResponseCallback<T> responseCallback) {
        return executeAsyncWithHandler(null, responseCallback);
    }

    public <T> Cancelable executeAsyncOnUIBack(ResponseCallback<T> responseCallback) {
        return executeAsyncWithHandler(this.deliver, responseCallback);
    }

    public <T> Cancelable executeAsyncWithHandler(final Handler handler, final ResponseCallback<T> responseCallback) {
        beginRequest();
        try {
            executePreCheck();
            this.realCall.enqueue(new Callback() { // from class: com.baidu.searchbox.http.request.RequestCall.2
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    RequestCall.this.sendFailResult(handler, responseCallback, iOException);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    RequestCall.this.sendSuccessResult(handler, responseCallback, response);
                }
            });
        } catch (IOException e) {
            sendFailResult(handler, responseCallback, e);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFailResult(Handler handler, final ResponseCallback responseCallback, Exception exc) {
        if (responseCallback != null) {
            final Exception wrapNoNetworkExceptionWithDetail = this.httpRequest.httpManager.isNetWorkConnected() ? exc : ResponseException.wrapNoNetworkExceptionWithDetail(exc);
            if (this.httpRequest.networkStat != null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.httpRequest.networkStat.onException(this.httpRequest.okRequest, exc);
                this.httpRequest.networkStat.onFinish(this.httpRequest.okRequest, currentTimeMillis);
            }
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.baidu.searchbox.http.request.RequestCall.3
                    @Override // java.lang.Runnable
                    public void run() {
                        responseCallback.onFail(wrapNoNetworkExceptionWithDetail);
                    }
                });
            } else {
                responseCallback.onFail(wrapNoNetworkExceptionWithDetail);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFailResult(Handler handler, final StatResponseCallback statResponseCallback, Exception exc) {
        long currentTimeMillis = System.currentTimeMillis();
        final Exception wrapNoNetworkExceptionWithDetail = this.httpRequest.httpManager.isNetWorkConnected() ? exc : ResponseException.wrapNoNetworkExceptionWithDetail(exc);
        if (this.httpRequest.networkStat != null) {
            this.httpRequest.networkStat.onException(this.httpRequest.okRequest, exc);
            this.httpRequest.networkStat.onFinish(this.httpRequest.okRequest, currentTimeMillis);
        }
        if (this.httpRequest.requestNetStat != null) {
            this.httpRequest.requestNetStat.exception = wrapNoNetworkExceptionWithDetail;
            this.httpRequest.requestNetStat.finishTs = currentTimeMillis;
            this.httpRequest.requestNetStat.netType = this.httpRequest.httpManager.getNetworkInfo();
            if (TextUtils.isEmpty(this.httpRequest.requestNetStat.clientIP) && !TextUtils.isEmpty(HttpManager.getClientIP())) {
                this.httpRequest.requestNetStat.clientIP = HttpManager.getClientIP();
            }
        }
        if (statResponseCallback != null) {
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.baidu.searchbox.http.request.RequestCall.4
                    @Override // java.lang.Runnable
                    public void run() {
                        statResponseCallback.onFail(wrapNoNetworkExceptionWithDetail);
                    }
                });
            } else {
                statResponseCallback.onFail(wrapNoNetworkExceptionWithDetail);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void sendSuccessResult(Handler handler, final StatResponseCallback<T> statResponseCallback, final Response response) {
        if (statResponseCallback != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.httpRequest.networkStat != null) {
                    this.httpRequest.networkStat.onFinish(this.httpRequest.okRequest, currentTimeMillis);
                }
                if (this.httpRequest.requestNetStat != null) {
                    this.httpRequest.requestNetStat.finishTs = currentTimeMillis;
                    this.httpRequest.requestNetStat.netType = this.httpRequest.httpManager.getNetworkInfo();
                }
                final T parseResponse = statResponseCallback.parseResponse(response, response.code(), this.httpRequest.requestNetStat);
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.baidu.searchbox.http.request.RequestCall.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (parseResponse != null) {
                                statResponseCallback.onSuccess(parseResponse, response.code());
                            } else {
                                statResponseCallback.onFail(new IOException("parse response return null"));
                            }
                        }
                    });
                } else if (parseResponse != null) {
                    statResponseCallback.onSuccess(parseResponse, response.code());
                } else {
                    statResponseCallback.onFail(new IOException("parse response return null"));
                }
            } catch (Exception e) {
                sendFailResult(handler, statResponseCallback, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void sendSuccessResult(Handler handler, final ResponseCallback<T> responseCallback, final Response response) {
        if (responseCallback != null) {
            try {
                if (this.httpRequest.networkStat != null) {
                    this.httpRequest.networkStat.onFinish(this.httpRequest.okRequest, System.currentTimeMillis());
                }
                final T parseResponse = responseCallback.parseResponse(response, response.code());
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.baidu.searchbox.http.request.RequestCall.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (parseResponse != null) {
                                responseCallback.onSuccess(parseResponse, response.code());
                            } else {
                                responseCallback.onFail(new IOException("parse response return null"));
                            }
                        }
                    });
                } else if (parseResponse != null) {
                    responseCallback.onSuccess(parseResponse, response.code());
                } else {
                    responseCallback.onFail(new IOException("parse response return null"));
                }
            } catch (Exception e) {
                sendFailResult(handler, responseCallback, e);
            }
        }
    }

    private void beginRequest() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.httpRequest.networkStat != null) {
            this.httpRequest.networkStat.onStartExecute(this.httpRequest.okRequest, currentTimeMillis);
            this.httpRequest.networkStat.setNetEngine(this.httpRequest.okRequest, 2);
        }
        if (this.httpRequest.requestNetStat != null) {
            this.httpRequest.requestNetStat.startTs = currentTimeMillis;
            this.httpRequest.requestNetStat.netEngine = 2;
            this.httpRequest.requestNetStat.from = this.httpRequest.requestFrom;
            this.httpRequest.requestNetStat.bdTraceId = this.httpRequest.getBdTraceId();
            this.httpRequest.requestNetStat.extraUserInfo = this.httpRequest.getExtraUserLog();
        }
    }

    @Override // com.baidu.searchbox.http.Cancelable
    public void cancel() {
        if (this.realCall != null) {
            this.realCall.cancel();
        }
    }
}
