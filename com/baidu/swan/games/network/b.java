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
    private static volatile b dfe;

    private b() {
        super(com.baidu.swan.apps.u.a.afX());
    }

    public static b aCe() {
        b bVar = new b();
        bVar.setHttpDnsEnable(aCf().getHttpDnsEnable());
        return bVar;
    }

    public static b aCf() {
        if (dfe == null) {
            synchronized (b.class) {
                if (dfe == null) {
                    dfe = new b();
                }
            }
        }
        return dfe;
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    protected OkHttpClient initClient() {
        if (e.apM() == null) {
            return super.initClient();
        }
        com.baidu.swan.games.t.a.a apW = e.apM().apW();
        OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
        int i = 60000;
        if (apW != null && apW.dgd != null) {
            i = apW.dgd.cEY;
            newBuilder.connectTimeout(apW.dgd.cEZ, TimeUnit.MILLISECONDS);
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
