package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    public String ddT;
    public int ddU;
    public long interval;
    public int state;

    public static g bT(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.ddT = jSONObject.optString("msg");
        gVar.ddU = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.ddT + "', open=" + this.ddU + ", interval=" + this.interval + '}';
    }
}
