package com.baidu.live.gift;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class t {
    public long aTn;
    public String name;

    public t J(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.name = jSONObject.optString("name");
            this.aTn = jSONObject.optLong("last_accessed");
        }
        return this;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.name);
            jSONObject.put("last_accessed", this.aTn);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
