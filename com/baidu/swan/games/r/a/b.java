package com.baidu.swan.games.r.a;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d {
    public String key;

    @Override // com.baidu.swan.games.r.a.d
    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TiebaInitialize.Params.KEY, this.key);
            jSONObject.put("errMsg", this.errMsg);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
