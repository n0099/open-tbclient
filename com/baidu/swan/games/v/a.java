package com.baidu.swan.games.v;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a {
    public com.baidu.swan.games.v.a.d eeG;
    private int eeH;
    private long ts;
    public int type;

    public a(int i, com.baidu.swan.games.v.a.d dVar) {
        this.type = i;
        this.eeG = dVar;
        this.eeH = d.aZA() ? 20 : 10;
        this.ts = System.currentTimeMillis();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.eeH);
            jSONObject.put("ts", this.ts);
            if (this.eeG != null) {
                jSONObject.put("msg", this.eeG.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
