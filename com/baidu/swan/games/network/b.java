package com.baidu.swan.games.network;

import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.network.a.c;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes2.dex */
public class b extends HttpManager {
    private static volatile b beu;

    private b() {
        super(com.baidu.swan.apps.u.a.Cw());
    }

    public static b OD() {
        b bVar = new b();
        bVar.setHttpDnsEnable(OE().getHttpDnsEnable());
        return bVar;
    }

    public static b OE() {
        if (beu == null) {
            synchronized (b.class) {
                if (beu == null) {
                    beu = new b();
                }
            }
        }
        return beu;
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    protected OkHttpClient initClient() {
        if (com.baidu.swan.apps.ae.b.IV() == null) {
            return super.initClient();
        }
        com.baidu.swan.games.o.a.a IX = com.baidu.swan.apps.ae.b.IV().IX();
        OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
        int i = 60000;
        if (IX != null && IX.beW != null) {
            i = IX.beW.aOg;
            newBuilder.connectTimeout(IX.beW.aOh, TimeUnit.MILLISECONDS);
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
