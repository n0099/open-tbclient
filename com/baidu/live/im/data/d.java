package com.baidu.live.im.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public String bdf;
    public boolean bps;
    public String liveId;

    public d(boolean z, String str, String str2) {
        this.bps = z;
        this.bdf = str;
        this.liveId = str2;
    }

    public d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bps = jSONObject.optBoolean("useCard");
            this.bdf = jSONObject.optString("benefitUid");
            this.liveId = jSONObject.optString("liveId");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("useCard", this.bps);
            jSONObject.put("benefitUid", this.bdf);
            jSONObject.put("liveId", this.liveId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
