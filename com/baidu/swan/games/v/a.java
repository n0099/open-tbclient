package com.baidu.swan.games.v;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public com.baidu.swan.games.v.a.d dXH;
    private int dXI;
    private long ts;
    public int type;

    public a(int i, com.baidu.swan.games.v.a.d dVar) {
        this.type = i;
        this.dXH = dVar;
        this.dXI = d.aWv() ? 20 : 10;
        this.ts = System.currentTimeMillis();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.dXI);
            jSONObject.put("ts", this.ts);
            if (this.dXH != null) {
                jSONObject.put("msg", this.dXH.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
