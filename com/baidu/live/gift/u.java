package com.baidu.live.gift;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class u {
    public long aVO;
    public int aWR;
    public String name;

    public u M(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.name = jSONObject.optString("name");
            this.aVO = jSONObject.optLong("last_accessed");
            this.aWR = jSONObject.optInt("branch");
        }
        return this;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.name);
            jSONObject.put("last_accessed", this.aVO);
            jSONObject.put("branch", this.aWR);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
