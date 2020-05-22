package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g {
    public int cTA;
    public String cTz;
    public long interval;
    public int state;

    public static g bH(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.cTz = jSONObject.optString("msg");
        gVar.cTA = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.cTz + "', open=" + this.cTA + ", interval=" + this.interval + '}';
    }
}
