package com.baidu.h.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    String appVersion;
    int cbz;
    String cuid;
    long num;
    long roomId;
    int sourceType;
    long uid;
    int version = 1;

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("room_id", this.roomId);
        jSONObject.put("source_type", 0);
        jSONObject.put("uid", this.uid);
        jSONObject.put("number", this.num);
        jSONObject.put("app_version", this.appVersion);
        jSONObject.put("source_type", this.sourceType);
        jSONObject.put("caller_flag", this.cbz);
        jSONObject.put("version", this.version);
        jSONObject.put("device_id", this.cuid);
        return jSONObject.toString();
    }
}
