package com.baidu.livesdk.api.http;
/* loaded from: classes5.dex */
public interface HttpRequest {
    public static final int GET = 0;
    public static final int POST = 1;

    void cancel();

    HttpRequestEntity getHttpRequestEntity();

    HttpRequest request(ResponseCallback responseCallback);

    HttpResponse requestSync() throws Exception;

    void setHttpRequestEntity(HttpRequestEntity httpRequestEntity);
}
