package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    public String dOS;
    public int dOT;
    public long interval;
    public int state;

    public static g cm(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.dOS = jSONObject.optString("msg");
        gVar.dOT = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.dOS + "', open=" + this.dOT + ", interval=" + this.interval + '}';
    }
}
