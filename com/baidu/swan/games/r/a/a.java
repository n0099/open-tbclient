package com.baidu.swan.games.r.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {
    public int bli;
    public int errCode;
    public String url;

    @Override // com.baidu.swan.games.r.a.d
    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.url);
            jSONObject.put("errCode", this.errCode);
            jSONObject.put("net", this.bli);
            jSONObject.put("errMsg", this.errMsg);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
