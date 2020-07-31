package com.baidu.swan.b;

import android.content.Context;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.List;
import okhttp3.Interceptor;
/* loaded from: classes10.dex */
public interface a {
    void a(String str, HttpRequestBuilder httpRequestBuilder);

    int aiA();

    CookieManager aiv();

    Context getAppContext();

    int getConnectionTimeout();

    int getReadTimeout();

    String getUserAgent();

    boolean isDebug();

    List<Interceptor> networkInterceptors();
}
