package com.baidu.searchbox.http.interceptor;

import com.baidu.searchbox.http.request.IAsyncRequestParamsHandler;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes16.dex */
public class ParamInterceptor implements Interceptor {
    private IAsyncRequestParamsHandler paramsHandler;

    public ParamInterceptor(IAsyncRequestParamsHandler iAsyncRequestParamsHandler) {
        this.paramsHandler = iAsyncRequestParamsHandler;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request;
        Request request2 = chain.request();
        if (this.paramsHandler != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this.paramsHandler.onHandleParams(linkedHashMap);
            if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                HttpUrl.Builder newBuilder = request2.url().newBuilder();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    newBuilder.setQueryParameter((String) entry.getKey(), (String) entry.getValue());
                }
                request = request2.newBuilder().url(newBuilder.build()).build();
                return chain.proceed(request);
            }
        }
        request = request2;
        return chain.proceed(request);
    }
}
