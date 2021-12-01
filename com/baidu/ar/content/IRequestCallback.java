package com.baidu.ar.content;
/* loaded from: classes8.dex */
public interface IRequestCallback<T> {
    void onFail(int i2, String str);

    void onResponse(T t);
}
