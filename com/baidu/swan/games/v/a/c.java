package com.baidu.swan.games.v.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends d {
    public int errCode;
    public String packageName;

    @Override // com.baidu.swan.games.v.a.d
    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("packageName", this.packageName);
            jSONObject.put("errCode", this.errCode);
            jSONObject.put("errMsg", this.errMsg);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
