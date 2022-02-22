package com.baidu.searchbox.network.outback.callback;

import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
/* loaded from: classes11.dex */
public interface NetworkStatResponseCallback<T> {
    void onFail(Exception exc);

    void onSuccess(T t, int i2);

    T parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception;
}
