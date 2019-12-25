package com.baidu.pass.http;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class PassHttpClient {
    private static final ThreadFactory a = new ThreadFactory() { // from class: com.baidu.pass.http.PassHttpClient.1
        private final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pass_net_work_request_thread # " + this.a.getAndIncrement());
        }
    };
    private static final ThreadPoolExecutor b = new ThreadPoolExecutor(6, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), a);
    private a c;

    static {
        if (Build.VERSION.SDK_INT >= 9) {
            b.allowCoreThreadTimeOut(true);
        }
    }

    public void cancelRequests(boolean z) {
        new Thread(new Runnable() { // from class: com.baidu.pass.http.PassHttpClient.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (PassHttpClient.this.c != null && PassHttpClient.this.c.b() != null) {
                        PassHttpClient.this.c.b().disconnect();
                        PassHttpClient.this.c.a();
                    }
                } catch (Exception e) {
                }
            }
        }).start();
    }

    public void get(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        try {
            a(context, passHttpParamDTO);
            a(Method.GET, context, passHttpParamDTO, httpResponseHandler);
        } catch (Exception e) {
            if (httpResponseHandler != null) {
                httpResponseHandler.b(e, e.getMessage());
            }
        }
    }

    public void post(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        try {
            a(context, passHttpParamDTO);
            a(Method.POST, context, passHttpParamDTO, httpResponseHandler);
        } catch (Exception e) {
            if (httpResponseHandler != null) {
                httpResponseHandler.b(e, e.getMessage());
            }
        }
    }

    private void a(Context context, PassHttpParamDTO passHttpParamDTO) {
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        }
        if (passHttpParamDTO == null || TextUtils.isEmpty(passHttpParamDTO.url)) {
            throw new IllegalArgumentException("paramDTO can't be null or paramDTO.url can't be empty");
        }
    }

    private void a(Method method, Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        this.c = new a(method, context, passHttpParamDTO, httpResponseHandler);
        b.submit(this.c);
    }
}
