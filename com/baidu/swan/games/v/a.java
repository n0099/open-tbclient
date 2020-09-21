package com.baidu.swan.games.v;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public com.baidu.swan.games.v.a.d dyZ;
    private int dza;
    private long ts;
    public int type;

    public a(int i, com.baidu.swan.games.v.a.d dVar) {
        this.type = i;
        this.dyZ = dVar;
        this.dza = d.aQa() ? 20 : 10;
        this.ts = System.currentTimeMillis();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.dza);
            jSONObject.put("ts", this.ts);
            if (this.dyZ != null) {
                jSONObject.put("msg", this.dyZ.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
