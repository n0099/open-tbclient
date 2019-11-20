package com.baidu.swan.games.network;

import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.network.a.c;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes2.dex */
public class b extends HttpManager {
    private static volatile b bBS;

    private b() {
        super(com.baidu.swan.apps.u.a.Jj());
    }

    public static b Xu() {
        b bVar = new b();
        bVar.setHttpDnsEnable(Xv().getHttpDnsEnable());
        return bVar;
    }

    public static b Xv() {
        if (bBS == null) {
            synchronized (b.class) {
                if (bBS == null) {
                    bBS = new b();
                }
            }
        }
        return bBS;
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    protected OkHttpClient initClient() {
        if (com.baidu.swan.apps.ae.b.Ra() == null) {
            return super.initClient();
        }
        com.baidu.swan.games.p.a.a Rd = com.baidu.swan.apps.ae.b.Ra().Rd();
        OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
        int i = 60000;
        if (Rd != null && Rd.bCv != null) {
            i = Rd.bCv.bkd;
            newBuilder.connectTimeout(Rd.bCv.bke, TimeUnit.MILLISECONDS);
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
