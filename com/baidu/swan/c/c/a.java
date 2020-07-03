package com.baidu.swan.c.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.swan.c.a.c;
import com.baidu.swan.c.a.d;
import com.baidu.swan.c.a.e;
import com.baidu.swan.c.a.f;
import com.baidu.swan.c.a.g;
import com.baidu.swan.c.a.h;
import com.baidu.swan.c.a.i;
import com.baidu.swan.c.a.j;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
/* loaded from: classes11.dex */
public class a extends HttpManager {
    private static final boolean DEBUG = com.baidu.swan.c.b.isDebug();
    private static volatile a dpR;

    private a() {
        super(com.baidu.swan.c.b.aGz().getAppContext());
    }

    public static a aGD() {
        if (dpR == null) {
            synchronized (a.class) {
                if (dpR == null) {
                    dpR = new a();
                }
            }
        }
        return dpR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        OkHttpClient initClient = super.initClient();
        List<Interceptor> networkInterceptors = com.baidu.swan.c.b.aGz().networkInterceptors();
        if (networkInterceptors != null && networkInterceptors.size() > 0) {
            OkHttpClient.Builder newBuilder = initClient.newBuilder();
            for (Interceptor interceptor : networkInterceptors) {
                newBuilder.addNetworkInterceptor(interceptor);
            }
            return newBuilder.build();
        }
        return initClient;
    }

    public static a dw(Context context) {
        return aGD();
    }

    public void a(com.baidu.swan.c.b.a aVar) {
        aVar.method = "GET";
        c(aVar);
    }

    public void b(com.baidu.swan.c.b.a aVar) {
        aVar.method = "POST";
        c(aVar);
    }

    public void c(@NonNull com.baidu.swan.c.b.a aVar) {
        if (aVar.dpN == null) {
            aVar.dpN = aGP();
        }
        if (tk(aVar.url)) {
            aVar.dpN.onFail(new Exception("url is invalid"));
            return;
        }
        HttpRequestBuilder d = b.d(aVar);
        a(d, aVar);
        d.build().executeAsync(aVar.dpN);
    }

    public OkHttpClient.Builder aGE() {
        return getOkHttpClient().newBuilder();
    }

    public e aGF() {
        return new e(this);
    }

    public j aGG() {
        return new j(this);
    }

    public com.baidu.swan.c.a.a aGH() {
        return new com.baidu.swan.c.a.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aGI */
    public c getRequest() {
        return new c(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aGJ */
    public d headerRequest() {
        return new d(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aGK */
    public f postRequest() {
        return new f(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aGL */
    public g postFormRequest() {
        return new g(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aGM */
    public h postStringRequest() {
        return new h(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aGN */
    public i putRequest() {
        return new i(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aGO */
    public com.baidu.swan.c.a.b deleteRequest() {
        return new com.baidu.swan.c.a.b(this);
    }

    public void a(HttpRequestBuilder httpRequestBuilder, com.baidu.swan.c.b.a aVar) {
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
        if (aVar.dpO) {
            httpRequestBuilder.userAgent(com.baidu.swan.c.b.aGz().getUserAgent());
        }
        if (aVar.dpP) {
            httpRequestBuilder.cookieManager(com.baidu.swan.c.b.aGz().ahg());
        }
        if (aVar.dpQ) {
            a(httpRequestBuilder);
        }
        if (aVar.tag != null) {
            httpRequestBuilder.tag(aVar.tag);
        }
    }

    public void a(HttpRequestBuilder httpRequestBuilder) {
        int connectionTimeout = com.baidu.swan.c.b.aGz().getConnectionTimeout();
        if (connectionTimeout > 0) {
            httpRequestBuilder.connectionTimeout(connectionTimeout);
        }
        int readTimeout = com.baidu.swan.c.b.aGz().getReadTimeout();
        if (readTimeout > 0) {
            httpRequestBuilder.readTimeout(readTimeout);
        }
        int ahl = com.baidu.swan.c.b.aGz().ahl();
        if (ahl > 0) {
            httpRequestBuilder.writeTimeout(ahl);
        }
    }

    public void a(OkHttpClient.Builder builder) {
        int connectionTimeout = com.baidu.swan.c.b.aGz().getConnectionTimeout();
        if (connectionTimeout > 0) {
            builder.connectTimeout(connectionTimeout, TimeUnit.MILLISECONDS);
        }
        int readTimeout = com.baidu.swan.c.b.aGz().getReadTimeout();
        if (readTimeout > 0) {
            builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
        }
        int ahl = com.baidu.swan.c.b.aGz().ahl();
        if (ahl > 0) {
            builder.writeTimeout(ahl, TimeUnit.MILLISECONDS);
        }
    }

    private boolean tk(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("SwanHttpManager", "url is empty");
            }
            return true;
        }
        return false;
    }

    private ResponseCallback aGP() {
        return new ResponseCallback() { // from class: com.baidu.swan.c.c.a.1
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
