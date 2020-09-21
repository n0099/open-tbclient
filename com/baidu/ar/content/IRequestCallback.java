package com.baidu.ar.content;
/* loaded from: classes10.dex */
public interface IRequestCallback<T> {
    void onFail(int i, String str);

    void onResponse(T t);
}
