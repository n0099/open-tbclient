package com.baidu.searchbox.http.request;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.searchbox.dns.DnsParseResult;
import com.baidu.searchbox.http.Cancelable;
import com.baidu.searchbox.http.RequestHandler;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.cookie.CookieJarImpl;
import com.baidu.searchbox.http.dns.HttpDns;
import com.baidu.searchbox.http.interceptor.LogInterceptor;
import com.baidu.searchbox.http.interceptor.NetworkStatInterceptor;
import com.baidu.searchbox.http.interceptor.ParamInterceptor;
import com.baidu.searchbox.http.response.ResponseException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class RequestCall implements Cancelable {
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
        return (this.httpRequest.networkStat == null && this.httpRequest.requestNetStat == null && this.httpRequest.connectionTimeout <= 0 && this.httpRequest.writeTimeout <= 0 && this.httpRequest.readTimeout <= 0 && this.httpRequest.paramsHandler == null && this.httpRequest.enableRetry && TextUtils.isEmpty(this.httpRequest.logTag) && this.httpRequest.cookieManager == null) ? false : true;
    }

    private void buildCall() {
        Request okRequest = this.httpRequest.getOkRequest();
        if (shouldCreateNewRequest()) {
            OkHttpClient.Builder newBuilder = this.client.newBuilder();
            if (this.httpRequest.networkStat != null || this.httpRequest.requestNetStat != null) {
                newBuilder.addNetworkInterceptor(new NetworkStatInterceptor());
                HttpDns httpDns = new HttpDns(this.httpRequest.dnsHelper, true);
                httpDns.setDnsListener(new HttpDns.HttpDnsListener() { // from class: com.baidu.searchbox.http.request.RequestCall.1
                    @Override // com.baidu.searchbox.http.dns.HttpDns.HttpDnsListener
                    public void onDnsParse(long j, long j2, DnsParseResult dnsParseResult) {
                        if (RequestCall.this.httpRequest != null && RequestCall.this.httpRequest.networkStat != null) {
                            RequestCall.this.httpRequest.networkStat.onDnsParse(RequestCall.this.httpRequest.getOkRequest(), j, j2, dnsParseResult);
                        }
                    }
                });
                newBuilder.dns(httpDns);
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
            this.realCall = newBuilder.build().newCall(okRequest);
            return;
        }
        this.realCall = this.client.newCall(okRequest);
    }

    public Call getCall() {
        return this.realCall;
    }

    private void checkNetworkConnected() throws IOException {
        if (!this.httpRequest.httpManager.isNetWorkConnected()) {
            throw new IOException(ResponseException.NO_NETWORK);
        }
    }

    private void checkExecuteWifiOnly() throws IOException {
        if (this.httpRequest.isWifiOnly && !this.httpRequest.httpManager.isWifi()) {
            throw new IOException(ResponseException.ONLY_WIFI_EXECUTE);
        }
    }

    private void executePreCheck() throws IOException {
        checkNetworkConnected();
        checkExecuteWifiOnly();
        if (this.requestHandler != null) {
            this.requestHandler.preExecuteRequest();
        }
    }

    public Response executeSync() throws IOException {
        try {
            try {
                executePreCheck();
                long currentTimeMillis = System.currentTimeMillis();
                if (this.httpRequest.networkStat != null) {
                    this.httpRequest.networkStat.onStartExecute(this.httpRequest.okRequest, currentTimeMillis);
                }
                if (this.httpRequest.requestNetStat != null) {
                    this.httpRequest.requestNetStat.startTs = currentTimeMillis;
                }
                return this.realCall.execute();
            } catch (IOException e) {
                if (this.httpRequest.networkStat != null) {
                    this.httpRequest.networkStat.onException(this.httpRequest.okRequest, e);
                }
                if (this.httpRequest.requestNetStat != null) {
                    this.httpRequest.requestNetStat.exception = e;
                }
                throw e;
            }
        } finally {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (this.httpRequest.networkStat != null) {
                this.httpRequest.networkStat.onFinish(this.httpRequest.okRequest, currentTimeMillis2);
            }
            if (this.httpRequest.requestNetStat != null) {
                this.httpRequest.requestNetStat.finishTs = currentTimeMillis2;
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
        try {
            executePreCheck();
            long currentTimeMillis = System.currentTimeMillis();
            if (this.httpRequest.networkStat != null) {
                this.httpRequest.networkStat.onStartExecute(this.httpRequest.okRequest, currentTimeMillis);
            }
            if (this.httpRequest.requestNetStat != null) {
                this.httpRequest.requestNetStat.startTs = currentTimeMillis;
            }
            this.realCall.enqueue(new Callback() { // from class: com.baidu.searchbox.http.request.RequestCall.2
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
        try {
            if (this.httpRequest.networkStat != null) {
                this.httpRequest.networkStat.onStartExecute(this.httpRequest.okRequest, System.currentTimeMillis());
            }
            executePreCheck();
            this.realCall.enqueue(new Callback() { // from class: com.baidu.searchbox.http.request.RequestCall.3
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
    public void sendFailResult(Handler handler, final ResponseCallback responseCallback, final Exception exc) {
        if (responseCallback != null) {
            if (this.httpRequest.networkStat != null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.httpRequest.networkStat.onException(this.httpRequest.okRequest, exc);
                this.httpRequest.networkStat.onFinish(this.httpRequest.okRequest, currentTimeMillis);
            }
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.baidu.searchbox.http.request.RequestCall.4
                    @Override // java.lang.Runnable
                    public void run() {
                        responseCallback.onFail(exc);
                    }
                });
            } else {
                responseCallback.onFail(exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFailResult(Handler handler, final StatResponseCallback statResponseCallback, final Exception exc) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.httpRequest.networkStat != null) {
            this.httpRequest.networkStat.onException(this.httpRequest.okRequest, exc);
            this.httpRequest.networkStat.onFinish(this.httpRequest.okRequest, currentTimeMillis);
        }
        if (this.httpRequest.requestNetStat != null) {
            this.httpRequest.requestNetStat.exception = exc;
            this.httpRequest.requestNetStat.finishTs = currentTimeMillis;
            this.httpRequest.requestNetStat.netType = this.httpRequest.httpManager.getNetworkInfo();
        }
        if (statResponseCallback != null) {
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.baidu.searchbox.http.request.RequestCall.5
                    @Override // java.lang.Runnable
                    public void run() {
                        statResponseCallback.onFail(exc);
                    }
                });
            } else {
                statResponseCallback.onFail(exc);
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
                    handler.post(new Runnable() { // from class: com.baidu.searchbox.http.request.RequestCall.6
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
                    handler.post(new Runnable() { // from class: com.baidu.searchbox.http.request.RequestCall.7
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

    @Override // com.baidu.searchbox.http.Cancelable
    public void cancel() {
        if (this.realCall != null) {
            this.realCall.cancel();
        }
    }
}
