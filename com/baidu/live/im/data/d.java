package com.baidu.live.im.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public String beO;
    public boolean bqK;
    public String liveId;

    public d(boolean z, String str, String str2) {
        this.bqK = z;
        this.beO = str;
        this.liveId = str2;
    }

    public d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bqK = jSONObject.optBoolean("useCard");
            this.beO = jSONObject.optString("benefitUid");
            this.liveId = jSONObject.optString("liveId");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("useCard", this.bqK);
            jSONObject.put("benefitUid", this.beO);
            jSONObject.put("liveId", this.liveId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
