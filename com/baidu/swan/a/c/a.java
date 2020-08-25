package com.baidu.swan.a.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.swan.a.a.c;
import com.baidu.swan.a.a.d;
import com.baidu.swan.a.a.e;
import com.baidu.swan.a.a.f;
import com.baidu.swan.a.a.g;
import com.baidu.swan.a.a.h;
import com.baidu.swan.a.a.i;
import com.baidu.swan.a.a.j;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
/* loaded from: classes4.dex */
public class a extends HttpManager {
    private static final boolean DEBUG = com.baidu.swan.a.b.isDebug();
    private static volatile a dER;

    private a() {
        super(com.baidu.swan.a.b.aSS().getAppContext());
    }

    public static a aSW() {
        if (dER == null) {
            synchronized (a.class) {
                if (dER == null) {
                    dER = new a();
                }
            }
        }
        return dER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        OkHttpClient initClient = super.initClient();
        List<Interceptor> networkInterceptors = com.baidu.swan.a.b.aSS().networkInterceptors();
        if (networkInterceptors != null && networkInterceptors.size() > 0) {
            OkHttpClient.Builder newBuilder = initClient.newBuilder();
            for (Interceptor interceptor : networkInterceptors) {
                newBuilder.addNetworkInterceptor(interceptor);
            }
            return newBuilder.build();
        }
        return initClient;
    }

    public static a dG(Context context) {
        return aSW();
    }

    public void a(com.baidu.swan.a.b.a aVar) {
        aVar.method = "GET";
        c(aVar);
    }

    public void b(com.baidu.swan.a.b.a aVar) {
        aVar.method = "POST";
        c(aVar);
    }

    public void c(@NonNull com.baidu.swan.a.b.a aVar) {
        if (aVar.dEN == null) {
            aVar.dEN = aTi();
        }
        if (wv(aVar.url)) {
            aVar.dEN.onFail(new Exception("url is invalid"));
            return;
        }
        HttpRequestBuilder d = b.d(aVar);
        a(d, aVar);
        d.build().executeAsync(aVar.dEN);
    }

    public OkHttpClient.Builder aSX() {
        return getOkHttpClient().newBuilder();
    }

    public e aSY() {
        return new e(this);
    }

    public j aSZ() {
        return new j(this);
    }

    public com.baidu.swan.a.a.a aTa() {
        return new com.baidu.swan.a.a.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aTb */
    public c getRequest() {
        return new c(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aTc */
    public d headerRequest() {
        return new d(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aTd */
    public f postRequest() {
        return new f(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aTe */
    public g postFormRequest() {
        return new g(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aTf */
    public h postStringRequest() {
        return new h(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aTg */
    public i putRequest() {
        return new i(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: aTh */
    public com.baidu.swan.a.a.b deleteRequest() {
        return new com.baidu.swan.a.a.b(this);
    }

    public void a(HttpRequestBuilder httpRequestBuilder, com.baidu.swan.a.b.a aVar) {
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
        if (aVar.dEO) {
            httpRequestBuilder.userAgent(com.baidu.swan.a.b.aSS().getUserAgent());
        }
        if (aVar.dEP) {
            httpRequestBuilder.cookieManager(com.baidu.swan.a.b.aSS().aqb());
        }
        if (aVar.dEQ) {
            a(httpRequestBuilder);
        }
        if (aVar.tag != null) {
            httpRequestBuilder.tag(aVar.tag);
        }
    }

    public void a(HttpRequestBuilder httpRequestBuilder) {
        int connectionTimeout = com.baidu.swan.a.b.aSS().getConnectionTimeout();
        if (connectionTimeout > 0) {
            httpRequestBuilder.connectionTimeout(connectionTimeout);
        }
        int readTimeout = com.baidu.swan.a.b.aSS().getReadTimeout();
        if (readTimeout > 0) {
            httpRequestBuilder.readTimeout(readTimeout);
        }
        int aqg = com.baidu.swan.a.b.aSS().aqg();
        if (aqg > 0) {
            httpRequestBuilder.writeTimeout(aqg);
        }
    }

    public void a(OkHttpClient.Builder builder) {
        int connectionTimeout = com.baidu.swan.a.b.aSS().getConnectionTimeout();
        if (connectionTimeout > 0) {
            builder.connectTimeout(connectionTimeout, TimeUnit.MILLISECONDS);
        }
        int readTimeout = com.baidu.swan.a.b.aSS().getReadTimeout();
        if (readTimeout > 0) {
            builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
        }
        int aqg = com.baidu.swan.a.b.aSS().aqg();
        if (aqg > 0) {
            builder.writeTimeout(aqg, TimeUnit.MILLISECONDS);
        }
    }

    private boolean wv(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("SwanHttpManager", "url is empty");
            }
            return true;
        }
        return false;
    }

    private ResponseCallback aTi() {
        return new ResponseCallback() { // from class: com.baidu.swan.a.c.a.1
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
