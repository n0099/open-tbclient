package com.baidu.swan.games.v.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends d {
    public int ele;
    public int errCode;
    public String url;

    @Override // com.baidu.swan.games.v.a.d
    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.url);
            jSONObject.put("errCode", this.errCode);
            jSONObject.put("net", this.ele);
            jSONObject.put("errMsg", this.errMsg);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
