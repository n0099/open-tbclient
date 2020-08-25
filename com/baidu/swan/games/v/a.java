package com.baidu.swan.games.v;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public com.baidu.swan.games.v.a.d dwU;
    private int dwV;
    private long ts;
    public int type;

    public a(int i, com.baidu.swan.games.v.a.d dVar) {
        this.type = i;
        this.dwU = dVar;
        this.dwV = d.aPp() ? 20 : 10;
        this.ts = System.currentTimeMillis();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.dwV);
            jSONObject.put("ts", this.ts);
            if (this.dwU != null) {
                jSONObject.put("msg", this.dwU.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
