package com.baidu.livesdk.sdk.http;

import com.baidu.livesdk.api.http.HttpRequestEntity;
import com.baidu.livesdk.api.http.HttpRequestManager;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
/* loaded from: classes3.dex */
public class OkHttpRequestManager implements HttpRequestManager {
    public OkHttpClient mClient;

    public OkHttpRequest createRequest() {
        return new OkHttpRequest();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.livesdk.api.http.HttpRequestManager
    public OkHttpRequest getRequest(HttpRequestEntity httpRequestEntity) {
        OkHttpRequest createRequest = createRequest();
        if (this.mClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectionPool(new ConnectionPool(5, 10L, TimeUnit.MINUTES));
            if (httpRequestEntity.getConnectTimeout() > 0) {
                builder.connectTimeout(httpRequestEntity.getConnectTimeout(), TimeUnit.MILLISECONDS);
            }
            if (httpRequestEntity.getReadTimeout() > 0) {
                builder.readTimeout(httpRequestEntity.getReadTimeout(), TimeUnit.MILLISECONDS);
            }
            OkHttpClient build = builder.build();
            this.mClient = build;
            build.dispatcher().setMaxRequestsPerHost(5);
        }
        createRequest.setOkHttpClient(this.mClient);
        createRequest.setHttpRequestEntity(httpRequestEntity);
        return createRequest;
    }
}
