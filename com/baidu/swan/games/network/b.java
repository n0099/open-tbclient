package com.baidu.swan.games.network;

import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.runtime.e;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes10.dex */
public class b extends HttpManager {
    private static volatile b dIZ;

    private b() {
        super(com.baidu.swan.apps.t.a.asf());
    }

    public static b aRW() {
        b bVar = new b();
        bVar.setHttpDnsEnable(aRX().getHttpDnsEnable());
        return bVar;
    }

    public static b aRX() {
        if (dIZ == null) {
            synchronized (b.class) {
                if (dIZ == null) {
                    dIZ = new b();
                }
            }
        }
        return dIZ;
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    protected OkHttpClient initClient() {
        if (e.aDa() == null) {
            return super.initClient();
        }
        com.baidu.swan.games.t.a.a aDk = e.aDa().aDk();
        OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
        int i = 60000;
        if (aDk != null && aDk.dJX != null) {
            i = aDk.dJX.deZ;
            newBuilder.connectTimeout(aDk.dJX.dfa, TimeUnit.MILLISECONDS);
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
