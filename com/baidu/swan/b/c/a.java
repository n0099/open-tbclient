package com.baidu.swan.b.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.swan.b.a.c;
import com.baidu.swan.b.a.d;
import com.baidu.swan.b.a.e;
import com.baidu.swan.b.a.f;
import com.baidu.swan.b.a.g;
import com.baidu.swan.b.a.h;
import com.baidu.swan.b.a.i;
import com.baidu.swan.b.a.j;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
/* loaded from: classes10.dex */
public class a extends HttpManager {
    private static final boolean DEBUG = com.baidu.swan.b.b.isDebug();
    private static volatile a dvI;

    private a() {
        super(com.baidu.swan.b.b.aKq().getAppContext());
    }

    public static a aKu() {
        if (dvI == null) {
            synchronized (a.class) {
                if (dvI == null) {
                    dvI = new a();
                }
            }
        }
        return dvI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        OkHttpClient initClient = super.initClient();
        List<Interceptor> networkInterceptors = com.baidu.swan.b.b.aKq().networkInterceptors();
        if (networkInterceptors != null && networkInterceptors.size() > 0) {
            OkHttpClient.Builder newBuilder = initClient.newBuilder();
            for (Interceptor interceptor : networkInterceptors) {
                newBuilder.addNetworkInterceptor(interceptor);
            }
            return newBuilder.build();
        }
        return initClient;
    }

    public static a dA(Context context) {
        return aKu();
    }

    public void a(com.baidu.swan.b.b.a aVar) {
        aVar.method = "GET";
        c(aVar);
    }

    public void b(com.baidu.swan.b.b.a aVar) {
        aVar.method = "POST";
        c(aVar);
    }

    public void c(@NonNull com.baidu.swan.b.b.a aVar) {
        if (aVar.dvE == null) {
            aVar.dvE = aKG();
        }
        if (un(aVar.url)) {
            aVar.dvE.onFail(new Exception("url is invalid"));
            return;
        }
        HttpRequestBuilder d = b.d(aVar);
        a(d, aVar);
        d.build().executeAsync(aVar.dvE);
    }

    public OkHttpClient.Builder aKv() {
        return getOkHttpClient().newBuilder();
    }

    public e aKw() {
        return new e(this);
    }

    public j aKx() {
        return new j(this);
    }

    public com.baidu.swan.b.a.a aKy() {
        return new com.baidu.swan.b.a.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aKz */
    public c getRequest() {
        return new c(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aKA */
    public d headerRequest() {
        return new d(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aKB */
    public f postRequest() {
        return new f(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aKC */
    public g postFormRequest() {
        return new g(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aKD */
    public h postStringRequest() {
        return new h(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aKE */
    public i putRequest() {
        return new i(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aKF */
    public com.baidu.swan.b.a.b deleteRequest() {
        return new com.baidu.swan.b.a.b(this);
    }

    public void a(HttpRequestBuilder httpRequestBuilder, com.baidu.swan.b.b.a aVar) {
        if (httpRequestBuilder == null || aVar == null) {
            if (DEBUG) {
                Log.e("SwanHttpManager", "setNetworkConfig fail");
                return;
            }
            return;
        }
        httpRequestBuilder.url(aVar.url);
        if (aVar.headers != null && aVar.headers.size() > 0) {
            httpRequestBuilder.headers(aVar.headers);
        }
        if (aVar.dvF) {
            httpRequestBuilder.userAgent(com.baidu.swan.b.b.aKq().getUserAgent());
        }
        if (aVar.dvG) {
            httpRequestBuilder.cookieManager(com.baidu.swan.b.b.aKq().aiv());
        }
        if (aVar.dvH) {
            a(httpRequestBuilder);
        }
        if (aVar.tag != null) {
            httpRequestBuilder.tag(aVar.tag);
        }
    }

    public void a(HttpRequestBuilder httpRequestBuilder) {
        int connectionTimeout = com.baidu.swan.b.b.aKq().getConnectionTimeout();
        if (connectionTimeout > 0) {
            httpRequestBuilder.connectionTimeout(connectionTimeout);
        }
        int readTimeout = com.baidu.swan.b.b.aKq().getReadTimeout();
        if (readTimeout > 0) {
            httpRequestBuilder.readTimeout(readTimeout);
        }
        int aiA = com.baidu.swan.b.b.aKq().aiA();
        if (aiA > 0) {
            httpRequestBuilder.writeTimeout(aiA);
        }
    }

    public void a(OkHttpClient.Builder builder) {
        int connectionTimeout = com.baidu.swan.b.b.aKq().getConnectionTimeout();
        if (connectionTimeout > 0) {
            builder.connectTimeout(connectionTimeout, TimeUnit.MILLISECONDS);
        }
        int readTimeout = com.baidu.swan.b.b.aKq().getReadTimeout();
        if (readTimeout > 0) {
            builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
        }
        int aiA = com.baidu.swan.b.b.aKq().aiA();
        if (aiA > 0) {
            builder.writeTimeout(aiA, TimeUnit.MILLISECONDS);
        }
    }

    private boolean un(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("SwanHttpManager", "url is empty");
            }
            return true;
        }
        return false;
    }

    private ResponseCallback aKG() {
        return new ResponseCallback() { // from class: com.baidu.swan.b.c.a.1
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                if (a.DEBUG) {
                    Log.w("SwanHttpManager", "response is ignore");
                }
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (a.DEBUG) {
                    Log.e("SwanHttpManager", "request is fail");
                }
            }
        };
    }
}
