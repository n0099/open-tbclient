package com.baidu.searchbox.network.request;

import com.baidu.searchbox.network.core.Response;
import com.baidu.searchbox.network.core.ResponseBody;
import com.baidu.searchbox.network.statistics.NetworkStatRecord;
/* loaded from: classes13.dex */
public class StatResponse {
    private Response realResponse;
    private NetworkStatRecord statRecord;

    public StatResponse(Response response, NetworkStatRecord networkStatRecord) {
        this.realResponse = response;
        this.statRecord = networkStatRecord;
    }

    public StatResponse(NetworkStatRecord networkStatRecord) {
        this(null, networkStatRecord);
    }

    public NetworkStatRecord getStatRecord() {
        return this.statRecord;
    }

    public Response getResponse() {
        return this.realResponse;
    }

    public ResponseBody body() {
        if (this.realResponse != null) {
            return this.realResponse.body();
        }
        return null;
    }
}
