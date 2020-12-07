package com.baidu.live.im.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public boolean bpc;
    public String bpd;
    public String liveId;

    public d(boolean z, String str, String str2) {
        this.bpc = z;
        this.bpd = str;
        this.liveId = str2;
    }

    public d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bpc = jSONObject.optBoolean("useCard");
            this.bpd = jSONObject.optString("benefitUid");
            this.liveId = jSONObject.optString("liveId");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("useCard", this.bpc);
            jSONObject.put("benefitUid", this.bpd);
            jSONObject.put("liveId", this.liveId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
