package com.baidu.swan.mini.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes7.dex */
public class b extends HttpManager {
    private static volatile b dvf;

    private b() {
        super(AppRuntime.getAppContext());
    }

    public static b aKk() {
        if (dvf == null) {
            synchronized (b.class) {
                if (dvf == null) {
                    dvf = new b();
                }
            }
        }
        return dvf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
        newBuilder.readTimeout(60000, TimeUnit.MILLISECONDS);
        newBuilder.writeTimeout(60000, TimeUnit.MILLISECONDS);
        OkHttpClient build = newBuilder.build();
        build.dispatcher().setMaxRequests(10);
        return build;
    }

    public void a(Request request, Callback callback) {
        if (request != null) {
            getOkHttpClient().newCall(request).enqueue(callback);
        }
    }
}
