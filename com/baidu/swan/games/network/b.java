package com.baidu.swan.games.network;

import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.runtime.e;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes11.dex */
public class b extends HttpManager {
    private static volatile b cqj;

    private b() {
        super(com.baidu.swan.apps.w.a.TU());
    }

    public static b aoP() {
        b bVar = new b();
        bVar.setHttpDnsEnable(aoQ().getHttpDnsEnable());
        return bVar;
    }

    public static b aoQ() {
        if (cqj == null) {
            synchronized (b.class) {
                if (cqj == null) {
                    cqj = new b();
                }
            }
        }
        return cqj;
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    protected OkHttpClient initClient() {
        if (e.acD() == null) {
            return super.initClient();
        }
        com.baidu.swan.games.s.a.a acK = e.acD().acK();
        OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
        int i = 60000;
        if (acK != null && acK.crh != null) {
            i = acK.crh.bPx;
            newBuilder.connectTimeout(acK.crh.bPy, TimeUnit.MILLISECONDS);
            newBuilder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
        }
        newBuilder.readTimeout(i, TimeUnit.MILLISECONDS);
        newBuilder.writeTimeout(i, TimeUnit.MILLISECONDS);
        OkHttpClient build = newBuilder.build();
        build.dispatcher().setMaxRequests(10);
        return build;
    }

    public void a(Request request, Callback callback) {
        if (request != null) {
            getOkHttpClient().newCall(request).enqueue(callback);
        }
    }

    public void a(Request request, List<Interceptor> list, Callback callback) {
        if (request != null) {
            OkHttpClient.Builder newBuilder = getOkHttpClient().newBuilder();
            if (list != null && !list.isEmpty()) {
                for (Interceptor interceptor : list) {
                    if (interceptor != null) {
                        newBuilder.addInterceptor(interceptor);
                    }
                }
            }
            newBuilder.build().newCall(request).enqueue(callback);
        }
    }
}
