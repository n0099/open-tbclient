package com.baidu.searchbox.live.interfaces.callback;
/* loaded from: classes2.dex */
public abstract class LiveStatusDataCallback<T> {
    public abstract void onError(Throwable th);

    public abstract void onResult(T t);
}
