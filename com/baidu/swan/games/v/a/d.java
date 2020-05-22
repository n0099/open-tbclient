package com.baidu.swan.games.v.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public String errMsg;

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errMsg", this.errMsg);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
