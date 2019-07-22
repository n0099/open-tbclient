package com.baidu.swan.games.network;

import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.network.a.c;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes2.dex */
public class b extends HttpManager {
    private static volatile b bjx;

    private b() {
        super(com.baidu.swan.apps.u.a.Ek());
    }

    public static b SB() {
        b bVar = new b();
        bVar.setHttpDnsEnable(SC().getHttpDnsEnable());
        return bVar;
    }

    public static b SC() {
        if (bjx == null) {
            synchronized (b.class) {
                if (bjx == null) {
                    bjx = new b();
                }
            }
        }
        return bjx;
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    protected OkHttpClient initClient() {
        if (com.baidu.swan.apps.ae.b.Md() == null) {
            return super.initClient();
        }
        com.baidu.swan.games.p.a.a Mf = com.baidu.swan.apps.ae.b.Md().Mf();
        OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
        int i = 60000;
        if (Mf != null && Mf.bka != null) {
            i = Mf.bka.aQT;
            newBuilder.connectTimeout(Mf.bka.aQU, TimeUnit.MILLISECONDS);
            newBuilder.addNetworkInterceptor(new c());
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
}
