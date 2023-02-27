package com.baidu.searchbox.network.outback.request;

import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.core.ResponseBody;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
/* loaded from: classes2.dex */
public class StatResponse {
    public Response realResponse;
    public NetworkStatRecord statRecord;

    public StatResponse(Response response, NetworkStatRecord networkStatRecord) {
        this.realResponse = response;
        this.statRecord = networkStatRecord;
    }

    public StatResponse(NetworkStatRecord networkStatRecord) {
        this(null, networkStatRecord);
    }

    public ResponseBody body() {
        Response response = this.realResponse;
        if (response != null) {
            return response.body();
        }
        return null;
    }

    public Response getResponse() {
        return this.realResponse;
    }

    public NetworkStatRecord getStatRecord() {
        return this.statRecord;
    }
}
