package com.baidu.g.b.b;

import com.baidu.android.imsdk.internal.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    int aEO;
    String aEs;
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
        jSONObject.put("app_version", this.aEs);
        jSONObject.put("source_type", this.sourceType);
        jSONObject.put("caller_flag", this.aEO);
        jSONObject.put("version", this.version);
        jSONObject.put(Constants.KEY_DEVICE_ID, this.cuid);
        return jSONObject.toString();
    }
}
