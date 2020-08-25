package com.baidu.searchbox.network.request;

import android.os.Handler;
import com.baidu.searchbox.network.Cancelable;
import com.baidu.searchbox.network.HttpRuntime;
import com.baidu.searchbox.network.RequestHandler;
import com.baidu.searchbox.network.callback.NetworkStatResponseCallback;
import com.baidu.searchbox.network.callback.ResponseCallback;
import com.baidu.searchbox.network.core.Call;
import com.baidu.searchbox.network.core.Callback;
import com.baidu.searchbox.network.core.RequestClient;
import com.baidu.searchbox.network.core.Response;
import java.io.IOException;
/* loaded from: classes14.dex */
public class RequestCall implements Cancelable {
    private RequestClient client;
    private Handler deliver;
    private HttpRequest httpRequest;
    private Call realCall;
    private RequestHandler requestHandler;

    public RequestCall(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
        if (httpRequest.client != null && (httpRequest.client instanceof RequestClient)) {
            this.client = httpRequest.client;
        }
        this.deliver = httpRequest.deliver;
        this.requestHandler = httpRequest.requestHandler;
        if (!httpRequest.httpManager.getRequestClient().isHasSetHttpDelegator() && HttpRuntime.getHttpContext() != null) {
            httpRequest.httpManager.getRequestClient().setHttpDelegator(HttpRuntime.getHttpContext().getCronetHttpDelegator());
        }
        buildCall();
    }

    private void buildCall() {
        if (this.client != null) {
            this.realCall = this.client.newCall(this.httpRequest.getRequest());
        }
    }

    public Call getCall() {
        return this.realCall;
    }

    private void checkNetworkConnected() throws IOException {
        if (!this.httpRequest.httpManager.isNetWorkConnected()) {
            throw new IOException(" no network connected");
        }
    }

    private void checkExecuteWifiOnly() throws IOException {
        if (this.httpRequest.isWifiOnly && !this.httpRequest.httpManager.isWifi()) {
            throw new IOException(" only allow wifi connected");
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
        beginRequest();
        try {
            try {
                executePreCheck();
                return this.realCall.execute();
            } catch (IOException e) {
                if (this.httpRequest.networkStat != null) {
                    this.httpRequest.networkStat.onException(this.httpRequest.request, e);
                }
                if (this.httpRequest.requestNetStat != null) {
                    this.httpRequest.requestNetStat.exception = e;
                }
                throw e;
            }
        } finally {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.httpRequest.networkStat != null) {
                this.httpRequest.networkStat.onFinish(this.httpRequest.request, currentTimeMillis);
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

    public <T> Cancelable executeStat(NetworkStatResponseCallback<T> networkStatResponseCallback) {
        return executeStatWithHandler(null, networkStatResponseCallback);
    }

    public <T> Cancelable executeStatUIBack(NetworkStatResponseCallback<T> networkStatResponseCallback) {
        return executeStatWithHandler(this.deliver, networkStatResponseCallback);
    }

    public <T> Cancelable executeStatWithHandler(final Handler handler, final NetworkStatResponseCallback<T> networkStatResponseCallback) {
        beginRequest();
        try {
            executePreCheck();
            this.realCall.enqueue(new Callback() { // from class: com.baidu.searchbox.network.request.RequestCall.1
                @Override // com.baidu.searchbox.network.core.Callback
                public void onFailure(Call call, IOException iOException) {
                    RequestCall.this.sendFailResult(handler, networkStatResponseCallback, iOException);
                }

                @Override // com.baidu.searchbox.network.core.Callback
                public void onResponse(Call call, Response response) {
                    RequestCall.this.sendSuccessResult(handler, networkStatResponseCallback, response);
                }
            });
        } catch (IOException e) {
            sendFailResult(handler, networkStatResponseCallback, e);
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
            this.realCall.enqueue(new Callback() { // from class: com.baidu.searchbox.network.request.RequestCall.2
                @Override // com.baidu.searchbox.network.core.Callback
                public void onFailure(Call call, IOException iOException) {
                    RequestCall.this.sendFailResult(handler, responseCallback, iOException);
                }

                @Override // com.baidu.searchbox.network.core.Callback
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
                this.httpRequest.networkStat.onException(this.httpRequest.request, exc);
                this.httpRequest.networkStat.onFinish(this.httpRequest.request, currentTimeMillis);
            }
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.baidu.searchbox.network.request.RequestCall.3
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
    public void sendFailResult(Handler handler, final NetworkStatResponseCallback networkStatResponseCallback, final Exception exc) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.httpRequest.networkStat != null) {
            this.httpRequest.networkStat.onException(this.httpRequest.request, exc);
            this.httpRequest.networkStat.onFinish(this.httpRequest.request, currentTimeMillis);
        }
        if (this.httpRequest.requestNetStat != null) {
            this.httpRequest.requestNetStat.exception = exc;
            this.httpRequest.requestNetStat.finishTs = currentTimeMillis;
            this.httpRequest.requestNetStat.netType = this.httpRequest.httpManager.getNetworkInfo();
        }
        if (networkStatResponseCallback != null) {
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.baidu.searchbox.network.request.RequestCall.4
                    @Override // java.lang.Runnable
                    public void run() {
                        networkStatResponseCallback.onFail(exc);
                    }
                });
            } else {
                networkStatResponseCallback.onFail(exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void sendSuccessResult(Handler handler, final NetworkStatResponseCallback<T> networkStatResponseCallback, final Response response) {
        if (networkStatResponseCallback != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.httpRequest.networkStat != null) {
                    this.httpRequest.networkStat.onFinish(this.httpRequest.request, currentTimeMillis);
                }
                if (this.httpRequest.requestNetStat != null) {
                    this.httpRequest.requestNetStat.finishTs = currentTimeMillis;
                    this.httpRequest.requestNetStat.netType = this.httpRequest.httpManager.getNetworkInfo();
                }
                final T parseResponse = networkStatResponseCallback.parseResponse(response, response.code(), this.httpRequest.requestNetStat);
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.baidu.searchbox.network.request.RequestCall.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (parseResponse != null) {
                                networkStatResponseCallback.onSuccess(parseResponse, response.code());
                            } else {
                                networkStatResponseCallback.onFail(new IOException("parse response return null"));
                            }
                        }
                    });
                } else if (parseResponse != null) {
                    networkStatResponseCallback.onSuccess(parseResponse, response.code());
                } else {
                    networkStatResponseCallback.onFail(new IOException("parse response return null"));
                }
            } catch (Exception e) {
                sendFailResult(handler, networkStatResponseCallback, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void sendSuccessResult(Handler handler, final ResponseCallback<T> responseCallback, final Response response) {
        if (responseCallback != null) {
            try {
                if (this.httpRequest.networkStat != null) {
                    this.httpRequest.networkStat.onFinish(this.httpRequest.request, System.currentTimeMillis());
                }
                final T parseResponse = responseCallback.parseResponse(response, response.code());
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.baidu.searchbox.network.request.RequestCall.6
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
            this.httpRequest.networkStat.onStartExecute(this.httpRequest.request, currentTimeMillis);
        }
        if (this.httpRequest.requestNetStat != null) {
            this.httpRequest.requestNetStat.startTs = currentTimeMillis;
            this.httpRequest.requestNetStat.from = this.httpRequest.requestFrom;
        }
    }

    @Override // com.baidu.searchbox.network.Cancelable
    public void cancel() {
        if (this.realCall != null) {
            this.realCall.cancel();
        }
    }
}
