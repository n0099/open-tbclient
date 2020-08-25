package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g {
    public String dob;
    public int dod;
    public long interval;
    public int state;

    public static g bZ(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.dob = jSONObject.optString("msg");
        gVar.dod = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.dob + "', open=" + this.dod + ", interval=" + this.interval + '}';
    }
}
