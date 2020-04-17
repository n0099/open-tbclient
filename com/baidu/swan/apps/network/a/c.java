package com.baidu.swan.apps.network.a;

import android.text.TextUtils;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.k.d;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes11.dex */
public class c implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String oh = ai.oh(d.Yo().YL());
        if (TextUtils.isEmpty(oh)) {
            oh = "";
        }
        return chain.proceed(request.newBuilder().header("User-Agent", oh).build());
    }
}
