package com.baidu.pass.http;

import android.content.Context;
import com.baidu.pass.common.Log;
import java.io.IOException;
/* loaded from: classes2.dex */
public class PassHttpClientRequest implements com.baidu.pass.a, Runnable, Comparable<PassHttpClientRequest> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9180a = "PassHttpClientRequest";

    /* renamed from: b  reason: collision with root package name */
    public int f9181b;
    public volatile boolean cancelRequest = false;
    public Context context;
    public Method method;
    public PassHttpParamDTO paramDTO;
    public HttpResponseHandler responseHandler;

    public PassHttpClientRequest(Method method, Context context, PassHttpParamDTO passHttpParamDTO, int i2, HttpResponseHandler httpResponseHandler) {
        this.f9181b = i2;
        this.method = method;
        this.context = context;
        this.paramDTO = passHttpParamDTO;
        this.responseHandler = httpResponseHandler;
    }

    public void cancel() {
        this.cancelRequest = true;
        this.responseHandler = null;
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpResponseHandler httpResponseHandler = this.responseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.b();
        }
        try {
            new b().a(this);
        } catch (IOException e2) {
            Log.e(f9180a, "PassHttpClientRequestrun " + e2.getMessage());
            HttpResponseHandler httpResponseHandler2 = this.responseHandler;
            if (httpResponseHandler2 != null) {
                httpResponseHandler2.b(e2, e2.getMessage());
            }
        }
        HttpResponseHandler httpResponseHandler3 = this.responseHandler;
        if (httpResponseHandler3 != null) {
            httpResponseHandler3.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(PassHttpClientRequest passHttpClientRequest) {
        ReqPriority reqPriority = this.paramDTO.priority;
        ReqPriority reqPriority2 = passHttpClientRequest.paramDTO.priority;
        return reqPriority == reqPriority2 ? this.f9181b - passHttpClientRequest.f9181b : reqPriority2.ordinal() - reqPriority.ordinal();
    }
}
