package com.baidu.swan.apps.network.a;

import android.text.TextUtils;
import com.baidu.swan.apps.an.ac;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class c implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String ir = ac.ir(com.baidu.swan.apps.core.j.c.Bi().BD());
        if (TextUtils.isEmpty(ir)) {
            ir = "";
        }
        return chain.proceed(request.newBuilder().header("User-Agent", ir).build());
    }
}
