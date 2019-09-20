package com.baidu.swan.games.network;

import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.network.a.c;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes2.dex */
public class b extends HttpManager {
    private static volatile b bjV;

    private b() {
        super(com.baidu.swan.apps.u.a.Eo());
    }

    public static b SF() {
        b bVar = new b();
        bVar.setHttpDnsEnable(SG().getHttpDnsEnable());
        return bVar;
    }

    public static b SG() {
        if (bjV == null) {
            synchronized (b.class) {
                if (bjV == null) {
                    bjV = new b();
                }
            }
        }
        return bjV;
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    protected OkHttpClient initClient() {
        if (com.baidu.swan.apps.ae.b.Mh() == null) {
            return super.initClient();
        }
        com.baidu.swan.games.p.a.a Mj = com.baidu.swan.apps.ae.b.Mh().Mj();
        OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
        int i = 60000;
        if (Mj != null && Mj.bky != null) {
            i = Mj.bky.aRr;
            newBuilder.connectTimeout(Mj.bky.aRs, TimeUnit.MILLISECONDS);
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
