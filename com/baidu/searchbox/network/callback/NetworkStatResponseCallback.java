package com.baidu.searchbox.network.callback;

import com.baidu.searchbox.network.core.Response;
import com.baidu.searchbox.network.statistics.NetworkStatRecord;
/* loaded from: classes5.dex */
public interface NetworkStatResponseCallback<T> {
    void onFail(Exception exc);

    void onSuccess(T t, int i);

    T parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception;
}
