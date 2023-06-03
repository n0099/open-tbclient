package com.baidu.searchbox.network.outback.request;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.network.outback.Cancelable;
import com.baidu.searchbox.network.outback.ConnectManager;
import com.baidu.searchbox.network.outback.OutbackComponent;
import com.baidu.searchbox.network.outback.callback.ResponseCallback;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.Callback;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.response.ResponseException;
import com.baidu.searchbox.network.outback.response.StatusCodeException;
import com.baidu.searchbox.network.outback.statistics.DoRecordManager;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.searchbox.network.outback.statistics.RequestCallException;
import java.io.IOException;
/* loaded from: classes4.dex */
public class RequestCall implements Cancelable {
    public Handler deliver = new Handler(Looper.getMainLooper());
    public Call realCall;
    public Request request;

    public RequestCall(Request request) {
        this.request = request;
        buildCall();
    }

    public <T> Cancelable executeAsync(ResponseCallback<T> responseCallback) {
        return executeAsyncWithHandler(null, responseCallback);
    }

    public <T> Cancelable executeAsyncOnUIBack(ResponseCallback<T> responseCallback) {
        return executeAsyncWithHandler(this.deliver, responseCallback);
    }

    public <T> Cancelable executeStat(ResponseCallback<T> responseCallback) {
        return executeStatWithHandler(null, responseCallback);
    }

    public <T> Cancelable executeStatUIBack(ResponseCallback<T> responseCallback) {
        return executeStatWithHandler(this.deliver, responseCallback);
    }

    private void buildCall() {
        this.realCall = this.request.newCall();
    }

    private void checkExecuteWifiOnly() throws IOException {
        if (this.request.isWifiOnly && !ConnectManager.isWifi(getContext())) {
            throw new IOException(" only allow wifi connected");
        }
    }

    private void executePreCheck() throws IOException {
        checkExecuteWifiOnly();
    }

    @Override // com.baidu.searchbox.network.outback.Cancelable
    public void cancel() {
        Call call = this.realCall;
        if (call != null) {
            call.cancel();
        }
    }

    public Response executeStat() throws RequestCallException {
        return executeSync();
    }

    public Call getCall() {
        return this.realCall;
    }

    public Context getContext() {
        return OutbackComponent.getInstance().getContext();
    }

    private void recordStatusCode(int i, String str) {
        if (StatusCodeException.isStatusCodeMatched(i)) {
            StatusCodeException statusCodeException = new StatusCodeException(String.format("Server statusCode Error; statusCode=%s; response.message=%s", Integer.valueOf(i), str));
            Request request = this.request;
            if (request != null) {
                request.onException4NetworkStatRecord(statusCodeException);
            }
        }
    }

    public <T> Cancelable executeAsyncWithHandler(final Handler handler, final ResponseCallback<T> responseCallback) {
        try {
            executePreCheck();
            this.realCall.enqueue(new Callback() { // from class: com.baidu.searchbox.network.outback.request.RequestCall.2
                @Override // com.baidu.searchbox.network.outback.core.Callback
                public void onFailure(Call call, IOException iOException) {
                    RequestCall.this.sendFailResult(handler, responseCallback, iOException);
                }

                @Override // com.baidu.searchbox.network.outback.core.Callback
                public void onResponse(Call call, Response response) {
                    RequestCall.this.sendSuccessResult(handler, responseCallback, response);
                }
            });
            return this;
        } catch (IOException e) {
            sendFailResult(handler, responseCallback, e);
            return this;
        }
    }

    public <T> Cancelable executeStatWithHandler(final Handler handler, final ResponseCallback<T> responseCallback) {
        try {
            executePreCheck();
            this.realCall.enqueue(new Callback() { // from class: com.baidu.searchbox.network.outback.request.RequestCall.1
                @Override // com.baidu.searchbox.network.outback.core.Callback
                public void onFailure(Call call, IOException iOException) {
                    RequestCall.this.sendFailResult(handler, responseCallback, iOException);
                }

                @Override // com.baidu.searchbox.network.outback.core.Callback
                public void onResponse(Call call, Response response) {
                    RequestCall.this.sendSuccessResult(handler, responseCallback, response);
                }
            });
            return this;
        } catch (IOException e) {
            sendFailResult(handler, responseCallback, e);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFailResult(Handler handler, final ResponseCallback responseCallback, Exception exc) {
        final Exception wrapNoNetworkExceptionWithDetail;
        final String message;
        if (responseCallback != null) {
            if (ConnectManager.isNetworkConnected(getContext())) {
                wrapNoNetworkExceptionWithDetail = exc;
            } else {
                wrapNoNetworkExceptionWithDetail = ResponseException.wrapNoNetworkExceptionWithDetail(exc);
            }
            this.request.onException4NetworkStatRecord(wrapNoNetworkExceptionWithDetail);
            if (TextUtils.isEmpty(wrapNoNetworkExceptionWithDetail.getMessage())) {
                message = exc.getClass().getName();
            } else {
                message = wrapNoNetworkExceptionWithDetail.getMessage();
            }
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.baidu.searchbox.network.outback.request.RequestCall.3
                    @Override // java.lang.Runnable
                    public void run() {
                        responseCallback.onFail(new RequestCallException(message, wrapNoNetworkExceptionWithDetail, RequestCall.this.request.getNetworkStatRecord()));
                    }
                });
            } else {
                responseCallback.onFail(new RequestCallException(message, wrapNoNetworkExceptionWithDetail, this.request.getNetworkStatRecord()));
            }
        }
        DoRecordManager.getInstance().doRecord(this.request.getNetworkStatRecord(), DoRecordManager.FAILED_MSG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void sendSuccessResult(Handler handler, final ResponseCallback<T> responseCallback, final Response response) {
        if (response != null) {
            try {
                recordStatusCode(response.code(), response.message());
                if (responseCallback != null) {
                    final T parseResponse = responseCallback.parseResponse(response, response.code());
                    if (handler != null) {
                        handler.post(new Runnable() { // from class: com.baidu.searchbox.network.outback.request.RequestCall.4
                            @Override // java.lang.Runnable
                            public void run() {
                                Object obj = parseResponse;
                                if (obj != null) {
                                    responseCallback.onSuccess(obj, response.code());
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
                }
                DoRecordManager.getInstance().doRecord(response.getStatRecord(), DoRecordManager.SUCCESSFUL_MSG);
            } catch (Exception e) {
                sendFailResult(handler, responseCallback, e);
            }
        }
    }

    public Response executeSync() throws RequestCallException {
        Exception wrapNoNetworkExceptionWithDetail;
        String message;
        int i = DoRecordManager.FAILED_MSG;
        NetworkStatRecord networkStatRecord = this.request.getNetworkStatRecord();
        try {
            try {
                executePreCheck();
                Response execute = this.realCall.execute();
                if (execute != null) {
                    recordStatusCode(execute.code(), execute.message());
                    networkStatRecord = execute.getStatRecord();
                    i = DoRecordManager.SUCCESSFUL_MSG;
                }
                return execute;
            } catch (Exception e) {
                if (ConnectManager.isNetworkConnected(getContext())) {
                    wrapNoNetworkExceptionWithDetail = e;
                } else {
                    wrapNoNetworkExceptionWithDetail = ResponseException.wrapNoNetworkExceptionWithDetail(e);
                }
                wrapNoNetworkExceptionWithDetail.printStackTrace();
                this.request.onException4NetworkStatRecord(wrapNoNetworkExceptionWithDetail);
                networkStatRecord = this.request.getNetworkStatRecord();
                i = DoRecordManager.FAILED_MSG;
                if (TextUtils.isEmpty(wrapNoNetworkExceptionWithDetail.getMessage())) {
                    message = Log.getStackTraceString(e);
                } else {
                    message = wrapNoNetworkExceptionWithDetail.getMessage();
                }
                throw new RequestCallException(message, wrapNoNetworkExceptionWithDetail, this.request.getNetworkStatRecord());
            }
        } finally {
            DoRecordManager.getInstance().doRecord(networkStatRecord, i);
        }
    }
}
