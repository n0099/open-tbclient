package com.baidu.live.im.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public boolean bfi;
    public String bfj;
    public String liveId;

    public b(boolean z, String str, String str2) {
        this.bfi = z;
        this.bfj = str;
        this.liveId = str2;
    }

    public b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bfi = jSONObject.optBoolean("useCard");
            this.bfj = jSONObject.optString("benefitUid");
            this.liveId = jSONObject.optString("liveId");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("useCard", this.bfi);
            jSONObject.put("benefitUid", this.bfj);
            jSONObject.put("liveId", this.liveId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
