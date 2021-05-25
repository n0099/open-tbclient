package com.baidu.android.pushservice.e;

import android.text.TextUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f3053a;

    /* renamed from: b  reason: collision with root package name */
    public final OkHttpClient f3054b = new OkHttpClient.Builder().addInterceptor(new C0034a()).connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();

    /* renamed from: com.baidu.android.pushservice.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0034a implements Interceptor {
        public C0034a() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            try {
                Request request = chain.request();
                System.currentTimeMillis();
                Response proceed = chain.proceed(request);
                System.currentTimeMillis();
                return proceed;
            } catch (Exception unused) {
                return chain.proceed(chain.request());
            }
        }
    }

    public static a a() {
        if (f3053a == null) {
            synchronized (a.class) {
                if (f3053a == null) {
                    f3053a = new a();
                }
            }
        }
        return f3053a;
    }

    public static Headers a(String str, String str2) {
        try {
            Headers.Builder builder = new Headers.Builder();
            if (!TextUtils.isEmpty(str)) {
                builder.add("User-Agent", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                builder.add("Host", str2);
            }
            return builder.build();
        } catch (Exception unused) {
            return null;
        }
    }

    public static Headers a(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return new Headers.Builder().build();
        }
        try {
            Headers.Builder builder = new Headers.Builder();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
            return builder.build();
        } catch (Exception unused) {
            return null;
        }
    }

    public b a(String str, String str2, String str3, HashMap<String, String> hashMap, String str4) {
        Request.Builder headers;
        b bVar = new b();
        try {
            if ("POST".equalsIgnoreCase(str2)) {
                headers = new Request.Builder().url(str).headers(a(hashMap)).post(RequestBody.create(MediaType.parse(str4), str3));
            } else {
                if (!TextUtils.isEmpty(str3) && str4.equals("application/x-www-form-urlencoded")) {
                    str = str + "?" + str3;
                }
                headers = new Request.Builder().url(str).headers(a(hashMap));
            }
            Response execute = this.f3054b.newCall(headers.build()).execute();
            bVar.a(execute.code());
            bVar.a(execute.body().byteStream());
        } catch (IOException | Exception unused) {
        }
        return bVar;
    }

    public b a(String str, String str2, HashMap<String, String> hashMap, String str3, String str4) {
        Request.Builder headers;
        b bVar = new b();
        try {
            if ("POST".equalsIgnoreCase(str2)) {
                headers = new Request.Builder().url(str).headers(a(str3, str4)).post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), c.a(hashMap)));
            } else {
                if (hashMap != null && hashMap.size() > 0) {
                    str = str + "?" + c.a(hashMap);
                }
                headers = new Request.Builder().url(str).headers(a(str3, str4));
            }
            Response execute = this.f3054b.newCall(headers.build()).execute();
            bVar.a(execute.code());
            bVar.a(execute.body().byteStream());
        } catch (IOException | Exception unused) {
        }
        return bVar;
    }
}
