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
/* loaded from: classes2.dex */
public class PassHttpClient implements com.baidu.pass.a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9231a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9232b;

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicInteger f9233c;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadFactory f9234d;

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadPoolExecutor f9235e;

    /* renamed from: f  reason: collision with root package name */
    public static final PassHttpClient f9236f;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f9231a = availableProcessors;
        f9232b = availableProcessors > 4 ? availableProcessors / 2 : 2;
        f9233c = new AtomicInteger();
        f9234d = new c();
        f9236f = new PassHttpClient();
        int i2 = f9232b;
        f9235e = new ThreadPoolExecutor(i2, i2, 60L, TimeUnit.SECONDS, new PriorityBlockingQueue(), f9234d);
        if (Build.VERSION.SDK_INT >= 9) {
            f9235e.allowCoreThreadTimeOut(true);
        }
    }

    private void a(Context context, PassHttpParamDTO passHttpParamDTO) {
        if (context != null) {
            if (passHttpParamDTO == null || TextUtils.isEmpty(passHttpParamDTO.url)) {
                throw new IllegalArgumentException("paramDTO can't be null or paramDTO.url can't be empty");
            }
            return;
        }
        throw new IllegalArgumentException("Invalid context argument");
    }

    public static PassHttpClient getInstance() {
        return f9236f;
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

    private PassHttpClientRequest a(Method method, Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        PassHttpClientRequest passHttpClientRequest = new PassHttpClientRequest(method, context, passHttpParamDTO, f9233c.incrementAndGet(), httpResponseHandler);
        f9235e.execute(passHttpClientRequest);
        return passHttpClientRequest;
    }
}
