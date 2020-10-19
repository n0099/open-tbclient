package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g {
    public String dCl;
    public int dCm;
    public long interval;
    public int state;

    public static g cj(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.dCl = jSONObject.optString("msg");
        gVar.dCm = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.dCl + "', open=" + this.dCm + ", interval=" + this.interval + '}';
    }
}
