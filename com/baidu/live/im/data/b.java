package com.baidu.live.im.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public boolean aXe;
    public String aXf;
    public String liveId;

    public b(boolean z, String str, String str2) {
        this.aXe = z;
        this.aXf = str;
        this.liveId = str2;
    }

    public b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aXe = jSONObject.optBoolean("useCard");
            this.aXf = jSONObject.optString("benefitUid");
            this.liveId = jSONObject.optString("liveId");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("useCard", this.aXe);
            jSONObject.put("benefitUid", this.aXf);
            jSONObject.put("liveId", this.liveId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
