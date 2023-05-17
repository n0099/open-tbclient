package com.baidu.pass.http;

import android.content.Context;
import com.baidu.pass.common.Log;
/* loaded from: classes3.dex */
public class PassHttpClientRequest implements com.baidu.pass.a, Runnable, Comparable<PassHttpClientRequest> {
    public static final String a = "PassHttpClientRequest";
    public int b;
    public volatile boolean cancelRequest = false;
    public Context context;
    public Method method;
    public PassHttpParamDTO paramDTO;
    public HttpResponseHandler responseHandler;

    public PassHttpClientRequest(Method method, Context context, PassHttpParamDTO passHttpParamDTO, int i, HttpResponseHandler httpResponseHandler) {
        this.b = i;
        this.method = method;
        this.context = context;
        this.paramDTO = passHttpParamDTO;
        this.responseHandler = httpResponseHandler;
    }

    public void cancel() {
        this.cancelRequest = true;
        this.responseHandler = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(PassHttpClientRequest passHttpClientRequest) {
        ReqPriority reqPriority = this.paramDTO.priority;
        ReqPriority reqPriority2 = passHttpClientRequest.paramDTO.priority;
        if (reqPriority == reqPriority2) {
            return this.b - passHttpClientRequest.b;
        }
        return reqPriority2.ordinal() - reqPriority.ordinal();
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpResponseHandler httpResponseHandler = this.responseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.b();
        }
        Log.e(a, "network request already run");
        try {
            new b().a(this);
        } catch (Exception e) {
            Log.e(a, "PassHttpClientRequestrun " + e.getMessage());
            HttpResponseHandler httpResponseHandler2 = this.responseHandler;
            if (httpResponseHandler2 != null) {
                httpResponseHandler2.b(e, e.getMessage());
            }
        }
        HttpResponseHandler httpResponseHandler3 = this.responseHandler;
        if (httpResponseHandler3 != null) {
            httpResponseHandler3.a();
        }
    }
}
