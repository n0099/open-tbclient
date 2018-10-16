package com.baidu.searchbox.ng.ai.apps.network.interceptor;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class AiAppUserAgentInterceptor implements Interceptor {
    private static final String HEADER_USER_AGENT = "User-Agent";

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String encodeChinese = AiAppsUtils.encodeChinese(AiAppsCoreRuntime.getInstance().getWebViewUa());
        if (TextUtils.isEmpty(encodeChinese)) {
            encodeChinese = "";
        }
        return chain.proceed(request.newBuilder().header("User-Agent", encodeChinese).build());
    }
}
