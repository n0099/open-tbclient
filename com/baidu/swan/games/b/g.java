package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g {
    public String eci;
    public int ecj;
    public long interval;
    public int state;

    public static g ct(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.eci = jSONObject.optString("msg");
        gVar.ecj = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.eci + "', open=" + this.ecj + ", interval=" + this.interval + '}';
    }
}
