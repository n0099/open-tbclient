package com.baidu.swan.a.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
/* loaded from: classes3.dex */
public class a extends HttpManager {
    private static final boolean DEBUG = com.baidu.swan.a.b.isDebug();
    private static volatile a ewq;

    private a() {
        super(com.baidu.swan.a.b.bfA().getAppContext());
    }

    public static a bfE() {
        if (ewq == null) {
            synchronized (a.class) {
                if (ewq == null) {
                    ewq = new a();
                }
            }
        }
        return ewq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        OkHttpClient initClient = super.initClient();
        List<Interceptor> networkInterceptors = com.baidu.swan.a.b.bfA().networkInterceptors();
        if (networkInterceptors != null && networkInterceptors.size() > 0) {
            OkHttpClient.Builder newBuilder = initClient.newBuilder();
            for (Interceptor interceptor : networkInterceptors) {
                newBuilder.addNetworkInterceptor(interceptor);
            }
            return newBuilder.build();
        }
        return initClient;
    }

    public static a eK(Context context) {
        return bfE();
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
        if (aVar.ewm == null) {
            aVar.ewm = bfQ();
        }
        if (yJ(aVar.url)) {
            aVar.ewm.onFail(new Exception("url is invalid"));
            return;
        }
        HttpRequestBuilder d = b.d(aVar);
        a(d, aVar);
        d.build().executeAsync(aVar.ewm);
    }

    public OkHttpClient.Builder bfF() {
        return getOkHttpClient().newBuilder();
    }

    public e bfG() {
        return new e(this);
    }

    public j bfH() {
        return new j(this);
    }

    public com.baidu.swan.a.a.a bfI() {
        return new com.baidu.swan.a.a.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: bfJ */
    public c getRequest() {
        return new c(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: bfK */
    public d headerRequest() {
        return new d(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: bfL */
    public f postRequest() {
        return new f(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: bfM */
    public g postFormRequest() {
        return new g(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: bfN */
    public h postStringRequest() {
        return new h(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: bfO */
    public i putRequest() {
        return new i(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: bfP */
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
        if (aVar.ewn) {
            httpRequestBuilder.userAgent(com.baidu.swan.a.b.bfA().getUserAgent());
        }
        if (aVar.ewo) {
            httpRequestBuilder.cookieManager(com.baidu.swan.a.b.bfA().aBI());
        }
        if (aVar.ewp) {
            a(httpRequestBuilder);
        }
        if (aVar.tag != null) {
            httpRequestBuilder.tag(aVar.tag);
        }
    }

    public void a(HttpRequestBuilder httpRequestBuilder) {
        int aBN = com.baidu.swan.a.b.bfA().aBN();
        if (aBN > 0) {
            httpRequestBuilder.connectionTimeout(aBN);
        }
        int readTimeout = com.baidu.swan.a.b.bfA().getReadTimeout();
        if (readTimeout > 0) {
            httpRequestBuilder.readTimeout(readTimeout);
        }
        int aBO = com.baidu.swan.a.b.bfA().aBO();
        if (aBO > 0) {
            httpRequestBuilder.writeTimeout(aBO);
        }
    }

    public void a(OkHttpClient.Builder builder) {
        int aBN = com.baidu.swan.a.b.bfA().aBN();
        if (aBN > 0) {
            builder.connectTimeout(aBN, TimeUnit.MILLISECONDS);
        }
        int readTimeout = com.baidu.swan.a.b.bfA().getReadTimeout();
        if (readTimeout > 0) {
            builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
        }
        int aBO = com.baidu.swan.a.b.bfA().aBO();
        if (aBO > 0) {
            builder.writeTimeout(aBO, TimeUnit.MILLISECONDS);
        }
    }

    private boolean yJ(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("SwanHttpManager", "url is empty");
            }
            return true;
        }
        return false;
    }

    private ResponseCallback bfQ() {
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
