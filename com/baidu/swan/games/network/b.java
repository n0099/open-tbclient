package com.baidu.swan.games.network;

import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.network.a.c;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes2.dex */
public class b extends HttpManager {
    private static volatile b bep;

    private b() {
        super(com.baidu.swan.apps.u.a.Cy());
    }

    public static b OF() {
        b bVar = new b();
        bVar.setHttpDnsEnable(OG().getHttpDnsEnable());
        return bVar;
    }

    public static b OG() {
        if (bep == null) {
            synchronized (b.class) {
                if (bep == null) {
                    bep = new b();
                }
            }
        }
        return bep;
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    protected OkHttpClient initClient() {
        if (com.baidu.swan.apps.ae.b.IX() == null) {
            return super.initClient();
        }
        com.baidu.swan.games.o.a.a IZ = com.baidu.swan.apps.ae.b.IX().IZ();
        OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
        int i = 60000;
        if (IZ != null && IZ.beS != null) {
            i = IZ.beS.aOc;
            newBuilder.connectTimeout(IZ.beS.aOd, TimeUnit.MILLISECONDS);
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
