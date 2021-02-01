package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes6.dex */
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
