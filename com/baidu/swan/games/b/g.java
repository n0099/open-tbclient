package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g {
    public String eab;
    public int eac;
    public long interval;
    public int state;

    public static g cw(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.eab = jSONObject.optString("msg");
        gVar.eac = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.eab + "', open=" + this.eac + ", interval=" + this.interval + '}';
    }
}
