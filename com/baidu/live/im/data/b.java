package com.baidu.live.im.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public boolean blJ;
    public String blK;
    public String liveId;

    public b(boolean z, String str, String str2) {
        this.blJ = z;
        this.blK = str;
        this.liveId = str2;
    }

    public b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.blJ = jSONObject.optBoolean("useCard");
            this.blK = jSONObject.optString("benefitUid");
            this.liveId = jSONObject.optString("liveId");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("useCard", this.blJ);
            jSONObject.put("benefitUid", this.blK);
            jSONObject.put("liveId", this.liveId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
