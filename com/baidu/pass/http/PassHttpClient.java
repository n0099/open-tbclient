package com.baidu.pass.http;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class PassHttpClient implements com.baidu.pass.a {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadFactory f9749a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadPoolExecutor f9750b = new ThreadPoolExecutor(12, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), f9749a);

    /* renamed from: c  reason: collision with root package name */
    public d f9751c;

    static {
        if (Build.VERSION.SDK_INT >= 9) {
            f9750b.allowCoreThreadTimeOut(true);
        }
    }

    public void cancelRequests(boolean z) {
        new Thread(new b(this)).start();
    }

    public void get(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        try {
            a(context, passHttpParamDTO);
            a(Method.GET, context, passHttpParamDTO, httpResponseHandler);
        } catch (Exception e2) {
            if (httpResponseHandler != null) {
                httpResponseHandler.a(e2, e2.getMessage());
            }
        }
    }

    public void post(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        try {
            a(context, passHttpParamDTO);
            a(Method.POST, context, passHttpParamDTO, httpResponseHandler);
        } catch (Exception e2) {
            if (httpResponseHandler != null) {
                httpResponseHandler.a(e2, e2.getMessage());
            }
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

    private void a(Method method, Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        d dVar = new d(method, context, passHttpParamDTO, httpResponseHandler);
        this.f9751c = dVar;
        f9750b.submit(dVar);
    }
}
