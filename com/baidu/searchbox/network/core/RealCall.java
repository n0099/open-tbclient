package com.baidu.searchbox.network.core;

import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import com.baidu.searchbox.network.core.http.BridgeInterceptor;
import com.baidu.searchbox.network.core.http.CallServerInterceptor;
import com.baidu.searchbox.network.core.http.RealInterceptorChain;
import com.baidu.searchbox.network.core.internal.NamedRunnable;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public final class RealCall implements Call {
    @Nullable
    private EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    private ConnectInterceptor mConnectInterceptor;
    final Request originalRequest;
    final RequestClient requestClient;

    private RealCall(RequestClient requestClient, Request request, boolean z) {
        this.requestClient = requestClient;
        this.originalRequest = request;
        this.forWebSocket = z;
    }

    public static RealCall newRealCall(RequestClient requestClient, Request request, boolean z) {
        RealCall realCall = new RealCall(requestClient, request, z);
        realCall.eventListener = requestClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    @Override // com.baidu.searchbox.network.core.Call
    public Request request() {
        return this.originalRequest;
    }

    @Override // com.baidu.searchbox.network.core.Call
    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.eventListener.callStart(this);
        try {
            try {
                this.requestClient.dispatcher().executed(this);
                Response responseWithInterceptorChain = getResponseWithInterceptorChain();
                if (responseWithInterceptorChain == null) {
                    throw new IOException("Canceled");
                }
                return responseWithInterceptorChain;
            } catch (IOException e) {
                this.eventListener.callFailed(this, e);
                throw e;
            }
        } finally {
            this.requestClient.dispatcher().finished(this);
        }
    }

    @Override // com.baidu.searchbox.network.core.Call
    public void enqueue(Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.eventListener.callStart(this);
        this.requestClient.dispatcher().enqueue(new AsyncCall(callback));
    }

    @Override // com.baidu.searchbox.network.core.Call
    public void cancel() {
        if (this.mConnectInterceptor != null) {
            this.mConnectInterceptor.cancel();
        }
    }

    @Override // com.baidu.searchbox.network.core.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    @Override // com.baidu.searchbox.network.core.Call
    public boolean isCanceled() {
        if (this.mConnectInterceptor != null) {
            return this.mConnectInterceptor.isCanceled();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.core.Call
    public RealCall clone() {
        return newRealCall(this.requestClient, this.originalRequest, this.forWebSocket);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class AsyncCall extends NamedRunnable {
        private final Callback responseCallback;

        AsyncCall(Callback callback) {
            super("BaiduNetwork %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String host() {
            return RealCall.this.originalRequest.url().host();
        }

        Request request() {
            return RealCall.this.originalRequest;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public RealCall get() {
            return RealCall.this;
        }

        @Override // com.baidu.searchbox.network.core.internal.NamedRunnable
        protected void execute() {
            try {
                this.responseCallback.onResponse(RealCall.this, RealCall.this.getResponseWithInterceptorChain());
            } catch (IOException e) {
                RealCall.this.eventListener.callFailed(RealCall.this, e);
                this.responseCallback.onFailure(RealCall.this, e);
            } finally {
                RealCall.this.requestClient.dispatcher().finished(this);
            }
        }
    }

    String toLoggableString() {
        return (isCanceled() ? "canceled " : "") + (this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + redactedUrl();
    }

    String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    Response getResponseWithInterceptorChain() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.requestClient.interceptors());
        arrayList.addAll(this.originalRequest.httpRequest().getExtraInterceptors());
        arrayList.add(new BridgeInterceptor(this.requestClient.cookieJar()));
        this.mConnectInterceptor = new ConnectInterceptor(this.requestClient);
        arrayList.add(this.mConnectInterceptor);
        arrayList.addAll(this.requestClient.networkInterceptors());
        arrayList.addAll(this.originalRequest.httpRequest().getExtraNetworkInterceptors());
        arrayList.add(new CallServerInterceptor());
        return new RealInterceptorChain(arrayList, null, 0, this.originalRequest, this, this.eventListener).proceed(this.originalRequest);
    }
}
