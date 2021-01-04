package com.baidu.live.gift;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class u {
    public long aVW;
    public String name;

    public u K(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.name = jSONObject.optString("name");
            this.aVW = jSONObject.optLong("last_accessed");
        }
        return this;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.name);
            jSONObject.put("last_accessed", this.aVW);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
