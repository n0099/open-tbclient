package com.baidu.swan.games.u.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends d {
    public int cRw;
    public int errCode;
    public String url;

    @Override // com.baidu.swan.games.u.a.d
    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.url);
            jSONObject.put("errCode", this.errCode);
            jSONObject.put("net", this.cRw);
            jSONObject.put("errMsg", this.errMsg);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
