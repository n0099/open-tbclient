package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g {
    public String dQA;
    public int dQB;
    public long interval;
    public int state;

    public static g cs(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.dQA = jSONObject.optString("msg");
        gVar.dQB = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.dQA + "', open=" + this.dQB + ", interval=" + this.interval + '}';
    }
}
