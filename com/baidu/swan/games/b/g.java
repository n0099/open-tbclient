package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g {
    public String dog;
    public int doh;
    public long interval;
    public int state;

    public static g bZ(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.dog = jSONObject.optString("msg");
        gVar.doh = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.dog + "', open=" + this.doh + ", interval=" + this.interval + '}';
    }
}
