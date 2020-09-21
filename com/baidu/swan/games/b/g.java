package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String dqh;
    public int dqi;
    public long interval;
    public int state;

    public static g cc(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.dqh = jSONObject.optString("msg");
        gVar.dqi = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.dqh + "', open=" + this.dqi + ", interval=" + this.interval + '}';
    }
}
