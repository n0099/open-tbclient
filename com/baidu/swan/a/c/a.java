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
/* loaded from: classes8.dex */
public class a extends HttpManager {
    private static final boolean DEBUG = com.baidu.swan.a.b.isDebug();
    private static volatile a eho;

    private a() {
        super(com.baidu.swan.a.b.baG().getAppContext());
    }

    public static a baK() {
        if (eho == null) {
            synchronized (a.class) {
                if (eho == null) {
                    eho = new a();
                }
            }
        }
        return eho;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        OkHttpClient initClient = super.initClient();
        List<Interceptor> networkInterceptors = com.baidu.swan.a.b.baG().networkInterceptors();
        if (networkInterceptors != null && networkInterceptors.size() > 0) {
            OkHttpClient.Builder newBuilder = initClient.newBuilder();
            for (Interceptor interceptor : networkInterceptors) {
                newBuilder.addNetworkInterceptor(interceptor);
            }
            return newBuilder.build();
        }
        return initClient;
    }

    public static a dL(Context context) {
        return baK();
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
        if (aVar.ehk == null) {
            aVar.ehk = baW();
        }
        if (yi(aVar.url)) {
            aVar.ehk.onFail(new Exception("url is invalid"));
            return;
        }
        HttpRequestBuilder d = b.d(aVar);
        a(d, aVar);
        d.build().executeAsync(aVar.ehk);
    }

    public OkHttpClient.Builder baL() {
        return getOkHttpClient().newBuilder();
    }

    public e baM() {
        return new e(this);
    }

    public j baN() {
        return new j(this);
    }

    public com.baidu.swan.a.a.a baO() {
        return new com.baidu.swan.a.a.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: baP */
    public c getRequest() {
        return new c(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: baQ */
    public d headerRequest() {
        return new d(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: baR */
    public f postRequest() {
        return new f(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: baS */
    public g postFormRequest() {
        return new g(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: baT */
    public h postStringRequest() {
        return new h(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: baU */
    public i putRequest() {
        return new i(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: baV */
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
        if (aVar.ehl) {
            httpRequestBuilder.userAgent(com.baidu.swan.a.b.baG().getUserAgent());
        }
        if (aVar.ehm) {
            httpRequestBuilder.cookieManager(com.baidu.swan.a.b.baG().axR());
        }
        if (aVar.ehn) {
            a(httpRequestBuilder);
        }
        if (aVar.tag != null) {
            httpRequestBuilder.tag(aVar.tag);
        }
    }

    public void a(HttpRequestBuilder httpRequestBuilder) {
        int connectionTimeout = com.baidu.swan.a.b.baG().getConnectionTimeout();
        if (connectionTimeout > 0) {
            httpRequestBuilder.connectionTimeout(connectionTimeout);
        }
        int readTimeout = com.baidu.swan.a.b.baG().getReadTimeout();
        if (readTimeout > 0) {
            httpRequestBuilder.readTimeout(readTimeout);
        }
        int axW = com.baidu.swan.a.b.baG().axW();
        if (axW > 0) {
            httpRequestBuilder.writeTimeout(axW);
        }
    }

    public void a(OkHttpClient.Builder builder) {
        int connectionTimeout = com.baidu.swan.a.b.baG().getConnectionTimeout();
        if (connectionTimeout > 0) {
            builder.connectTimeout(connectionTimeout, TimeUnit.MILLISECONDS);
        }
        int readTimeout = com.baidu.swan.a.b.baG().getReadTimeout();
        if (readTimeout > 0) {
            builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
        }
        int axW = com.baidu.swan.a.b.baG().axW();
        if (axW > 0) {
            builder.writeTimeout(axW, TimeUnit.MILLISECONDS);
        }
    }

    private boolean yi(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("SwanHttpManager", "url is empty");
            }
            return true;
        }
        return false;
    }

    private ResponseCallback baW() {
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
