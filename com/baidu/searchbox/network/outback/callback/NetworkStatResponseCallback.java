package com.baidu.searchbox.network.outback.callback;

import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
/* loaded from: classes2.dex */
public interface NetworkStatResponseCallback {
    void onFail(Exception exc);

    void onSuccess(Object obj, int i);

    Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception;
}
