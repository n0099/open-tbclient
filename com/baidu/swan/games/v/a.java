package com.baidu.swan.games.v;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public com.baidu.swan.games.v.a.d dTx;
    private int dTy;
    private long ts;
    public int type;

    public a(int i, com.baidu.swan.games.v.a.d dVar) {
        this.type = i;
        this.dTx = dVar;
        this.dTy = d.aUD() ? 20 : 10;
        this.ts = System.currentTimeMillis();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.dTy);
            jSONObject.put("ts", this.ts);
            if (this.dTx != null) {
                jSONObject.put("msg", this.dTx.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
