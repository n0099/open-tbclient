package com.baidu.livesdk.api.http;
/* loaded from: classes7.dex */
public interface ResponseCallback {
    void onFail(int i2, Exception exc);

    void onSuccess(HttpResponse httpResponse);
}
