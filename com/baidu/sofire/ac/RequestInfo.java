package com.baidu.sofire.ac;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RequestInfo {
    public JSONObject data;
    public String sKey;
    public String xDeviceId;

    public RequestInfo(String str, String str2, JSONObject jSONObject) {
        this.sKey = str;
        this.xDeviceId = str2;
        this.data = jSONObject;
    }

    public String toString() {
        return "RequestInfo{sKey='" + this.sKey + "', xDeviceId='" + this.xDeviceId + "', dataLen=" + this.data.length() + '}';
    }
}
