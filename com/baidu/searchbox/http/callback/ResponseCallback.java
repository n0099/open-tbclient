package com.baidu.searchbox.http.callback;

import okhttp3.Response;
/* loaded from: classes12.dex */
public abstract class ResponseCallback<T> {
    public abstract void onFail(Exception exc);

    public abstract void onSuccess(T t, int i);

    public abstract T parseResponse(Response response, int i) throws Exception;
}
