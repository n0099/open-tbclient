package com.baidu.searchbox.network.callback;

import com.baidu.searchbox.network.core.Response;
/* loaded from: classes15.dex */
public abstract class ResponseCallback<T> {
    public abstract void onFail(Exception exc);

    public abstract void onSuccess(T t, int i);

    public abstract T parseResponse(Response response, int i) throws Exception;
}
