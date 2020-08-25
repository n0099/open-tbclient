package com.baidu.pass.http;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class PassHttpClient implements com.baidu.pass.a {
    private static final ThreadFactory a = new a();
    private static final ThreadPoolExecutor b = new ThreadPoolExecutor(6, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), a);
    private d c;

    static {
        if (Build.VERSION.SDK_INT >= 9) {
            b.allowCoreThreadTimeOut(true);
        }
    }

    public void cancelRequests(boolean z) {
        new Thread(new b(this)).start();
    }

    public void get(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        try {
            a(context, passHttpParamDTO);
            a(Method.GET, context, passHttpParamDTO, httpResponseHandler);
        } catch (Exception e) {
            if (httpResponseHandler != null) {
                httpResponseHandler.a(e, e.getMessage());
            }
        }
    }

    public void post(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        try {
            a(context, passHttpParamDTO);
            a(Method.POST, context, passHttpParamDTO, httpResponseHandler);
        } catch (Exception e) {
            if (httpResponseHandler != null) {
                httpResponseHandler.a(e, e.getMessage());
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
        this.c = new d(method, context, passHttpParamDTO, httpResponseHandler);
        b.submit(this.c);
    }
}
