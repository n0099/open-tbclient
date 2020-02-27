package com.baidu.searchbox.network.core.http;

import com.baidu.searchbox.network.core.Call;
import com.baidu.searchbox.network.core.EventListener;
import com.baidu.searchbox.network.core.Interceptor;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.Response;
import com.baidu.searchbox.network.core.connect.Connection;
import java.io.IOException;
import java.util.List;
/* loaded from: classes13.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final Call call;
    private int calls;
    private Connection connection;
    private final EventListener eventListener;
    private final int index;
    private final List<Interceptor> interceptors;
    private final Request request;

    public RealInterceptorChain(List<Interceptor> list, Connection connection, int i, Request request, Call call, EventListener eventListener) {
        this.interceptors = list;
        this.connection = connection;
        this.index = i;
        this.request = request;
        this.call = call;
        this.eventListener = eventListener;
    }

    @Override // com.baidu.searchbox.network.core.Interceptor.Chain
    public Connection connection() {
        return this.connection;
    }

    @Override // com.baidu.searchbox.network.core.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    public EventListener eventListener() {
        return this.eventListener;
    }

    @Override // com.baidu.searchbox.network.core.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    public Response proceed(Request request, Connection connection) throws IOException {
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError();
        }
        this.calls++;
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, connection, this.index + 1, request, this.call, this.eventListener);
        Interceptor interceptor = this.interceptors.get(this.index);
        Response intercept = interceptor.intercept(realInterceptorChain);
        if (intercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (intercept.body() == null) {
            throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
        }
        return intercept;
    }

    @Override // com.baidu.searchbox.network.core.Interceptor.Chain
    public Response proceed(Request request) throws IOException {
        return proceed(request, this.connection);
    }
}
