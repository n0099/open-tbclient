package com.baidu.searchbox.http.callback;

import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import okhttp3.Response;
/* loaded from: classes2.dex */
public interface StatResponseCallback {
    void onFail(Exception exc);

    void onSuccess(Object obj, int i);

    Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception;
}
