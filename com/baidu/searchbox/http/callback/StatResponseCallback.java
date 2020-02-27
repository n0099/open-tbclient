package com.baidu.searchbox.http.callback;

import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import okhttp3.Response;
/* loaded from: classes13.dex */
public interface StatResponseCallback<T> {
    void onFail(Exception exc);

    void onSuccess(T t, int i);

    T parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception;
}
