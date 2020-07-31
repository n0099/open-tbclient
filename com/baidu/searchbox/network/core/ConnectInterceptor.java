package com.baidu.searchbox.network.core;

import com.baidu.searchbox.network.core.Interceptor;
import com.baidu.searchbox.network.core.connect.Connection;
import com.baidu.searchbox.network.core.connect.IConnect;
import com.baidu.searchbox.network.core.connect.URLConnectionManager;
import com.baidu.searchbox.network.core.http.RealInterceptorChain;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class ConnectInterceptor implements Interceptor {
    private static final String TAG = ConnectInterceptor.class.getSimpleName();
    private boolean isCanceled;
    private Connection mConnection;
    private final IConnect mConnectionManager;
    private RequestClient mRequestClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectInterceptor(RequestClient requestClient) {
        this.mRequestClient = requestClient;
        this.mConnectionManager = URLConnectionManager.newBuilder().requestClient(this.mRequestClient).build();
    }

    @Override // com.baidu.searchbox.network.core.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        if (this.isCanceled) {
            throw new IOException("The request has been cancelled.");
        }
        Request request = chain.request();
        this.mConnection = connect(request);
        return ((RealInterceptorChain) chain).proceed(request, this.mConnection);
    }

    public Connection getConnection() {
        return this.mConnection;
    }

    public void cancel() {
        this.isCanceled = true;
        if (this.mConnection != null) {
            this.mConnection.disconnect();
        }
    }

    public boolean isCanceled() {
        return this.isCanceled;
    }

    private Connection connect(Request request) throws IOException {
        return this.mConnectionManager.connect(request);
    }
}
