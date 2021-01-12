package com.baidu.live.im.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public String aZY;
    public boolean blX;
    public String liveId;

    public d(boolean z, String str, String str2) {
        this.blX = z;
        this.aZY = str;
        this.liveId = str2;
    }

    public d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.blX = jSONObject.optBoolean("useCard");
            this.aZY = jSONObject.optString("benefitUid");
            this.liveId = jSONObject.optString("liveId");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("useCard", this.blX);
            jSONObject.put("benefitUid", this.aZY);
            jSONObject.put("liveId", this.liveId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
