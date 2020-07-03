package com.baidu.live.im.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public boolean aWk;
    public String aWl;
    public String liveId;

    public b(boolean z, String str, String str2) {
        this.aWk = z;
        this.aWl = str;
        this.liveId = str2;
    }

    public b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aWk = jSONObject.optBoolean("useCard");
            this.aWl = jSONObject.optString("benefitUid");
            this.liveId = jSONObject.optString("liveId");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("useCard", this.aWk);
            jSONObject.put("benefitUid", this.aWl);
            jSONObject.put("liveId", this.liveId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
