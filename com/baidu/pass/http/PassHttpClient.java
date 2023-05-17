package com.baidu.pass.http;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.pass.common.Log;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class PassHttpClient implements com.baidu.pass.a {
    public static final int a;
    public static final int b;
    public static final AtomicInteger c;
    public static final ThreadFactory d;
    public static final ThreadPoolExecutor e;
    public static final PassHttpClient f;

    static {
        int i;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        if (availableProcessors > 16) {
            i = availableProcessors / 2;
        } else {
            i = 8;
        }
        b = i;
        c = new AtomicInteger();
        d = new c();
        f = new PassHttpClient();
        int i2 = b;
        e = new ThreadPoolExecutor(i2, i2, 60L, TimeUnit.SECONDS, new PriorityBlockingQueue(), d);
        if (Build.VERSION.SDK_INT >= 9) {
            e.allowCoreThreadTimeOut(true);
        }
    }

    public static PassHttpClient getInstance() {
        return f;
    }

    private PassHttpClientRequest a(Method method, Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        PassHttpClientRequest passHttpClientRequest = new PassHttpClientRequest(method, context, passHttpParamDTO, c.incrementAndGet(), httpResponseHandler);
        e.execute(passHttpClientRequest);
        return passHttpClientRequest;
    }

    private void a(Context context, PassHttpParamDTO passHttpParamDTO) {
        if (context != null) {
            if (passHttpParamDTO != null && !TextUtils.isEmpty(passHttpParamDTO.url)) {
                return;
            }
            throw new IllegalArgumentException("paramDTO can't be null or paramDTO.url can't be empty");
        }
        throw new IllegalArgumentException("Invalid context argument");
    }

    public PassHttpClientRequest get(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        try {
            a(context, passHttpParamDTO);
            return a(Method.GET, context, passHttpParamDTO, httpResponseHandler);
        } catch (Exception e2) {
            Log.e(Log.TAG, "get ex=" + e2.getMessage());
            if (httpResponseHandler != null) {
                httpResponseHandler.a(e2, e2.getMessage());
                return null;
            }
            return null;
        }
    }

    public PassHttpClientRequest post(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        try {
            a(context, passHttpParamDTO);
            return a(Method.POST, context, passHttpParamDTO, httpResponseHandler);
        } catch (Exception e2) {
            if (httpResponseHandler != null) {
                httpResponseHandler.a(e2, e2.getMessage());
                return null;
            }
            return null;
        }
    }
}
