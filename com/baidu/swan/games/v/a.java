package com.baidu.swan.games.v;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public com.baidu.swan.games.v.a.d enH;
    private int enI;
    private long ts;
    public int type;

    public a(int i, com.baidu.swan.games.v.a.d dVar) {
        this.type = i;
        this.enH = dVar;
        this.enI = d.bbV() ? 20 : 10;
        this.ts = System.currentTimeMillis();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.enI);
            jSONObject.put("ts", this.ts);
            if (this.enH != null) {
                jSONObject.put("msg", this.enH.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
