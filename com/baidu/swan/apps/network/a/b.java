package com.baidu.swan.apps.network.a;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class b implements Interceptor {
    private HashMap<String, String> mHeaders = new HashMap<>();

    public void n(HashMap<String, String> hashMap) {
        this.mHeaders.clear();
        if (hashMap != null && hashMap.size() >= 1) {
            this.mHeaders = hashMap;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        if (this.mHeaders == null || this.mHeaders.size() < 1) {
            return chain.proceed(chain.request());
        }
        Request.Builder newBuilder = chain.request().newBuilder();
        for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
            newBuilder.addHeader(entry.getKey(), entry.getValue());
        }
        return chain.proceed(newBuilder.build());
    }
}
