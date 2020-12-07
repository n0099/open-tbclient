package com.baidu.swan.a;

import android.content.Context;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.List;
import okhttp3.Interceptor;
/* loaded from: classes5.dex */
public interface a {
    void a(String str, HttpRequestBuilder httpRequestBuilder);

    CookieManager aAr();

    int aAw();

    int aAx();

    Context getAppContext();

    int getReadTimeout();

    String getUserAgent();

    boolean isDebug();

    List<Interceptor> networkInterceptors();
}
