package com.baidu.swan.apps.network.a;

import android.text.TextUtils;
import com.baidu.swan.apps.an.ac;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String jd = ac.jd(com.baidu.swan.apps.core.j.c.GO().Hj());
        if (TextUtils.isEmpty(jd)) {
            jd = "";
        }
        return chain.proceed(request.newBuilder().header(HTTP.USER_AGENT, jd).build());
    }
}
