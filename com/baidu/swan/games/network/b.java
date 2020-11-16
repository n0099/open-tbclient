package com.baidu.swan.games.network;

import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.runtime.e;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes7.dex */
public class b extends HttpManager {
    private static volatile b dVG;

    private b() {
        super(com.baidu.swan.apps.t.a.avS());
    }

    public static b aVI() {
        b bVar = new b();
        bVar.setHttpDnsEnable(aVJ().getHttpDnsEnable());
        return bVar;
    }

    public static b aVJ() {
        if (dVG == null) {
            synchronized (b.class) {
                if (dVG == null) {
                    dVG = new b();
                }
            }
        }
        return dVG;
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    protected OkHttpClient initClient() {
        if (e.aGM() == null) {
            return super.initClient();
        }
        com.baidu.swan.games.t.a.a aGW = e.aGM().aGW();
        OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
        int i = 60000;
        if (aGW != null && aGW.dWE != null) {
            i = aGW.dWE.drN;
            newBuilder.connectTimeout(aGW.dWE.drO, TimeUnit.MILLISECONDS);
            newBuilder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.d());
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
