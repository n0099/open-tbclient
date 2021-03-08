package com.baidu.live.im.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public String beH;
    public boolean bqS;
    public String liveId;

    public d(boolean z, String str, String str2) {
        this.bqS = z;
        this.beH = str;
        this.liveId = str2;
    }

    public d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bqS = jSONObject.optBoolean("useCard");
            this.beH = jSONObject.optString("benefitUid");
            this.liveId = jSONObject.optString("liveId");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("useCard", this.bqS);
            jSONObject.put("benefitUid", this.beH);
            jSONObject.put("liveId", this.liveId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
