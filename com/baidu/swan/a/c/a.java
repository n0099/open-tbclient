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
/* loaded from: classes5.dex */
public class a extends HttpManager {
    private static final boolean DEBUG = com.baidu.swan.a.b.isDebug();
    private static volatile a emH;

    private a() {
        super(com.baidu.swan.a.b.bde().getAppContext());
    }

    public static a bdi() {
        if (emH == null) {
            synchronized (a.class) {
                if (emH == null) {
                    emH = new a();
                }
            }
        }
        return emH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        OkHttpClient initClient = super.initClient();
        List<Interceptor> networkInterceptors = com.baidu.swan.a.b.bde().networkInterceptors();
        if (networkInterceptors != null && networkInterceptors.size() > 0) {
            OkHttpClient.Builder newBuilder = initClient.newBuilder();
            for (Interceptor interceptor : networkInterceptors) {
                newBuilder.addNetworkInterceptor(interceptor);
            }
            return newBuilder.build();
        }
        return initClient;
    }

    public static a er(Context context) {
        return bdi();
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
        if (aVar.emD == null) {
            aVar.emD = bdu();
        }
        if (yK(aVar.url)) {
            aVar.emD.onFail(new Exception("url is invalid"));
            return;
        }
        HttpRequestBuilder d = b.d(aVar);
        a(d, aVar);
        d.build().executeAsync(aVar.emD);
    }

    public OkHttpClient.Builder bdj() {
        return getOkHttpClient().newBuilder();
    }

    public e bdk() {
        return new e(this);
    }

    public j bdl() {
        return new j(this);
    }

    public com.baidu.swan.a.a.a bdm() {
        return new com.baidu.swan.a.a.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: bdn */
    public c getRequest() {
        return new c(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: bdo */
    public d headerRequest() {
        return new d(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: bdp */
    public f postRequest() {
        return new f(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: bdq */
    public g postFormRequest() {
        return new g(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: bdr */
    public h postStringRequest() {
        return new h(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: bds */
    public i putRequest() {
        return new i(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: bdt */
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
        if (aVar.emE) {
            httpRequestBuilder.userAgent(com.baidu.swan.a.b.bde().getUserAgent());
        }
        if (aVar.emF) {
            httpRequestBuilder.cookieManager(com.baidu.swan.a.b.bde().aAr());
        }
        if (aVar.emG) {
            a(httpRequestBuilder);
        }
        if (aVar.tag != null) {
            httpRequestBuilder.tag(aVar.tag);
        }
    }

    public void a(HttpRequestBuilder httpRequestBuilder) {
        int aAw = com.baidu.swan.a.b.bde().aAw();
        if (aAw > 0) {
            httpRequestBuilder.connectionTimeout(aAw);
        }
        int readTimeout = com.baidu.swan.a.b.bde().getReadTimeout();
        if (readTimeout > 0) {
            httpRequestBuilder.readTimeout(readTimeout);
        }
        int aAx = com.baidu.swan.a.b.bde().aAx();
        if (aAx > 0) {
            httpRequestBuilder.writeTimeout(aAx);
        }
    }

    public void a(OkHttpClient.Builder builder) {
        int aAw = com.baidu.swan.a.b.bde().aAw();
        if (aAw > 0) {
            builder.connectTimeout(aAw, TimeUnit.MILLISECONDS);
        }
        int readTimeout = com.baidu.swan.a.b.bde().getReadTimeout();
        if (readTimeout > 0) {
            builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
        }
        int aAx = com.baidu.swan.a.b.bde().aAx();
        if (aAx > 0) {
            builder.writeTimeout(aAx, TimeUnit.MILLISECONDS);
        }
    }

    private boolean yK(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("SwanHttpManager", "url is empty");
            }
            return true;
        }
        return false;
    }

    private ResponseCallback bdu() {
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
