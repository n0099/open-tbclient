package com.baidu.ar.content;
/* loaded from: classes.dex */
public interface IRequestCallback<T> {
    void onFail(int i, String str);

    void onResponse(T t);
}
