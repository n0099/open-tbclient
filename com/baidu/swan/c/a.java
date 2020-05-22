package com.baidu.swan.c;

import android.content.Context;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.List;
import okhttp3.Interceptor;
/* loaded from: classes11.dex */
public interface a {
    void a(String str, HttpRequestBuilder httpRequestBuilder);

    CookieManager aga();

    int agf();

    Context getAppContext();

    int getConnectionTimeout();

    int getReadTimeout();

    String getUserAgent();

    boolean isDebug();

    List<Interceptor> networkInterceptors();
}
