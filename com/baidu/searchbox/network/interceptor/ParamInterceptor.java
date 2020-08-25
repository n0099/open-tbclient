package com.baidu.searchbox.network.interceptor;

import com.baidu.searchbox.network.core.HttpUrl;
import com.baidu.searchbox.network.core.Interceptor;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.Response;
import com.baidu.searchbox.network.request.IAsyncRequestParamsHandler;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes14.dex */
public class ParamInterceptor implements Interceptor {
    private IAsyncRequestParamsHandler paramsHandler;

    public ParamInterceptor(IAsyncRequestParamsHandler iAsyncRequestParamsHandler) {
        this.paramsHandler = iAsyncRequestParamsHandler;
    }

    @Override // com.baidu.searchbox.network.core.Interceptor
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
