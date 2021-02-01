package com.baidu.swan.apps.network.a;

import android.text.TextUtils;
import com.baidu.searchbox.http.request.HttpRequest;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes9.dex */
public class c implements Interceptor {
    private static boolean dps = true;

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        HttpUrl resolve;
        Request request = chain.request();
        if (!dps) {
            return chain.proceed(request);
        }
        if (!b(request)) {
            return chain.proceed(request);
        }
        Headers headers = request.headers();
        String str = headers.get("___request_type___");
        String str2 = headers.get("___plugin_id___");
        Response proceed = chain.proceed(c(request));
        if (d(proceed)) {
            String header = proceed.header(com.baidubce.http.Headers.LOCATION);
            if (!TextUtils.isEmpty(header) && (resolve = proceed.request().url().resolve(header)) != null && com.baidu.swan.apps.af.a.b.Y(str, resolve.toString(), str2) != 0) {
                String str3 = "redirect error:" + resolve.toString() + " scheme illegal or not in domain list";
                com.baidu.swan.apps.console.c.w("SafeRedirectCheck", str3);
                throw new InterruptedIOException(str3);
            }
            return proceed;
        }
        return proceed;
    }

    private boolean b(Request request) {
        if (request == null) {
            return false;
        }
        return TextUtils.equals(request.headers().get("___check_redirect___"), "on");
    }

    private Request c(Request request) {
        if (request == null) {
            return request;
        }
        return request.newBuilder().removeHeader("___check_redirect___").removeHeader("___request_type___").removeHeader("___plugin_id___").build();
    }

    private boolean d(Response response) {
        if (response == null) {
            return false;
        }
        int code = response.code();
        if (TextUtils.isEmpty(response.header(com.baidubce.http.Headers.LOCATION))) {
            return false;
        }
        return (307 <= code && code <= 308) || (300 <= code && code <= 303);
    }

    public static Request a(Request request, String str, String str2) {
        if (dps && request != null) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            return request.newBuilder().addHeader("___check_redirect___", "on").addHeader("___request_type___", str).addHeader("___plugin_id___", str2).build();
        }
        return request;
    }

    public static HttpRequest a(HttpRequest httpRequest, String str, String str2) {
        if (dps && httpRequest != null) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            return httpRequest.newBuilder().addHeader("___check_redirect___", "on").addHeader("___request_type___", str).addHeader("___plugin_id___", str2).build();
        }
        return httpRequest;
    }

    public static Map<String, String> cb(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (dps) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("___check_redirect___", "on");
            hashMap.put("___request_type___", str);
            hashMap.put("___plugin_id___", str2);
        }
        return hashMap;
    }
}
