package com.baidu.live.gift;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class u {
    public long aUE;
    public String name;

    public u D(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.name = jSONObject.optString("name");
            this.aUE = jSONObject.optLong("last_accessed");
        }
        return this;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.name);
            jSONObject.put("last_accessed", this.aUE);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
