package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g {
    public String eeN;
    public int eeO;
    public long interval;
    public int state;

    public static g cw(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.eeN = jSONObject.optString("msg");
        gVar.eeO = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.eeN + "', open=" + this.eeO + ", interval=" + this.interval + '}';
    }
}
