package com.baidu.ar.content;
/* loaded from: classes10.dex */
public interface IRequestCallback<T> {
    void onFail(int i2, String str);

    void onResponse(T t);
}
