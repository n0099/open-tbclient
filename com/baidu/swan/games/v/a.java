package com.baidu.swan.games.v;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public com.baidu.swan.games.v.a.d dZp;
    private int dZq;
    private long ts;
    public int type;

    public a(int i, com.baidu.swan.games.v.a.d dVar) {
        this.type = i;
        this.dZp = dVar;
        this.dZq = d.aXd() ? 20 : 10;
        this.ts = System.currentTimeMillis();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.dZq);
            jSONObject.put("ts", this.ts);
            if (this.dZp != null) {
                jSONObject.put("msg", this.dZp.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
