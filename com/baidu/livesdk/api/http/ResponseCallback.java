package com.baidu.livesdk.api.http;
/* loaded from: classes2.dex */
public interface ResponseCallback {
    void onFail(int i, Exception exc);

    void onSuccess(HttpResponse httpResponse);
}
