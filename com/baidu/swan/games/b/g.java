package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g {
    public String dKI;
    public int dKJ;
    public long interval;
    public int state;

    public static g cm(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.dKI = jSONObject.optString("msg");
        gVar.dKJ = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.dKI + "', open=" + this.dKJ + ", interval=" + this.interval + '}';
    }
}
