package com.baidu.i.b.b;

import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    String appVersion;
    int bZE;
    String cuid;
    long num;
    long roomId;
    int sourceType;
    long uid;
    int version = 1;

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("room_id", this.roomId);
        jSONObject.put(UgcConstant.SOURCE_TYPE, 0);
        jSONObject.put("uid", this.uid);
        jSONObject.put("number", this.num);
        jSONObject.put("app_version", this.appVersion);
        jSONObject.put(UgcConstant.SOURCE_TYPE, this.sourceType);
        jSONObject.put("caller_flag", this.bZE);
        jSONObject.put("version", this.version);
        jSONObject.put("device_id", this.cuid);
        return jSONObject.toString();
    }
}
