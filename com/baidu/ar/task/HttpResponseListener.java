package com.baidu.ar.task;
/* loaded from: classes3.dex */
public interface HttpResponseListener<T> {
    void onErrorResponse(String str);

    void onResponse(T t);
}
