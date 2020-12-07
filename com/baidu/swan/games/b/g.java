package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes25.dex */
public class g {
    public String dVQ;
    public int dVR;
    public long interval;
    public int state;

    public static g co(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.dVQ = jSONObject.optString("msg");
        gVar.dVR = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.dVQ + "', open=" + this.dVR + ", interval=" + this.interval + '}';
    }
}
