package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes3.dex */
public class StatResponse {
    public Response realResponse;
    public NetworkStatRecord statRecord;

    public StatResponse(NetworkStatRecord networkStatRecord) {
        this(null, networkStatRecord);
    }

    public StatResponse(Response response, NetworkStatRecord networkStatRecord) {
        this.realResponse = response;
        this.statRecord = networkStatRecord;
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
