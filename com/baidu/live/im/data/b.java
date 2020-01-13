package com.baidu.live.im.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public boolean aqh;
    public String aqi;
    public String liveId;

    public b(boolean z, String str, String str2) {
        this.aqh = z;
        this.aqi = str;
        this.liveId = str2;
    }

    public b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aqh = jSONObject.optBoolean("useCard");
            this.aqi = jSONObject.optString("benefitUid");
            this.liveId = jSONObject.optString("liveId");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("useCard", this.aqh);
            jSONObject.put("benefitUid", this.aqi);
            jSONObject.put("liveId", this.liveId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
