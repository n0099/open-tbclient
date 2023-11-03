package com.baidu.android.pushservice.q;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    public static volatile a b;
    public final OkHttpClient a = new OkHttpClient.Builder().addInterceptor(new b()).connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();

    /* loaded from: classes.dex */
    public class b implements Interceptor {
        public b(a aVar) {
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
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
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

    public Bitmap a(String str) {
        try {
            return BitmapFactory.decodeStream(this.a.newCall(new Request.Builder().url(str).build()).execute().body().byteStream());
        } catch (Exception unused) {
            return null;
        }
    }

    public com.baidu.android.pushservice.q.b a(String str, String str2, String str3, HashMap<String, String> hashMap, String str4) {
        Request.Builder headers;
        com.baidu.android.pushservice.q.b bVar = new com.baidu.android.pushservice.q.b();
        try {
            if ("POST".equalsIgnoreCase(str2)) {
                headers = new Request.Builder().url(str).headers(a(hashMap)).post(RequestBody.create(MediaType.parse(str4), str3));
            } else {
                if (!TextUtils.isEmpty(str3) && str4.equals("application/x-www-form-urlencoded")) {
                    str = str + "?" + str3;
                }
                headers = new Request.Builder().url(str).headers(a(hashMap));
            }
            Response execute = this.a.newCall(headers.build()).execute();
            bVar.a(execute.code());
            bVar.a(execute.body().byteStream());
        } catch (IOException | Exception unused) {
        }
        return bVar;
    }

    public com.baidu.android.pushservice.q.b a(String str, String str2, HashMap<String, String> hashMap, String str3, String str4) {
        Request.Builder headers;
        com.baidu.android.pushservice.q.b bVar = new com.baidu.android.pushservice.q.b();
        try {
            if ("POST".equalsIgnoreCase(str2)) {
                headers = new Request.Builder().url(str).headers(a(str3, str4)).post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), c.a(hashMap)));
            } else {
                if (hashMap != null && hashMap.size() > 0) {
                    str = str + "?" + c.a(hashMap);
                }
                headers = new Request.Builder().url(str).headers(a(str3, str4));
            }
            Response execute = this.a.newCall(headers.build()).execute();
            bVar.a(execute.code());
            bVar.a(execute.body().byteStream());
        } catch (IOException | Exception unused) {
        }
        return bVar;
    }
}
