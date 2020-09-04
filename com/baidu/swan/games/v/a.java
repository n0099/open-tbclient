package com.baidu.swan.games.v;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public com.baidu.swan.games.v.a.d dwY;
    private int dwZ;
    private long ts;
    public int type;

    public a(int i, com.baidu.swan.games.v.a.d dVar) {
        this.type = i;
        this.dwY = dVar;
        this.dwZ = d.aPp() ? 20 : 10;
        this.ts = System.currentTimeMillis();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.dwZ);
            jSONObject.put("ts", this.ts);
            if (this.dwY != null) {
                jSONObject.put("msg", this.dwY.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
