package com.baidu.swan.a;

import android.content.Context;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.List;
import okhttp3.Interceptor;
/* loaded from: classes3.dex */
public interface a {
    void a(String str, HttpRequestBuilder httpRequestBuilder);

    CookieManager axP();

    int axU();

    int axV();

    Context getAppContext();

    int getReadTimeout();

    String getUserAgent();

    boolean isDebug();

    List<Interceptor> networkInterceptors();
}
