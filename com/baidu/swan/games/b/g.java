package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g {
    public String edJ;
    public int edK;
    public long interval;
    public int state;

    public static g cv(JSONObject jSONObject) {
        g gVar = new g();
        gVar.state = jSONObject.optInt("state");
        gVar.edJ = jSONObject.optString("msg");
        gVar.edK = jSONObject.optInt("switch_open");
        gVar.interval = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.state + ", limit='" + this.edJ + "', open=" + this.edK + ", interval=" + this.interval + '}';
    }
}
