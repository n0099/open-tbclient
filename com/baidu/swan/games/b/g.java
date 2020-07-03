package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g {
    public String cYj;
    public int cYk;
    public long interval;
    public int state;

    public static g bO(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.cYj = jSONObject.optString("msg");
        gVar.cYk = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.cYj + "', open=" + this.cYk + ", interval=" + this.interval + '}';
    }
}
