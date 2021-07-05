package com.baidu.searchbox.http.callback;

import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import okhttp3.Response;
/* loaded from: classes3.dex */
public interface StatResponseCallback<T> {
    void onFail(Exception exc);

    void onSuccess(T t, int i2);

    T parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception;
}
