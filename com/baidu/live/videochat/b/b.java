package com.baidu.live.videochat.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private long bGf;
    private int bGg;
    private long bGh;
    private long bGi;
    private long bGj;
    private long bGk;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bGf = jSONObject.optLong("chat_id");
            this.bGg = jSONObject.optInt("chat_status");
            this.bGh = jSONObject.optLong("user_id1");
            this.bGi = jSONObject.optLong("live_id1");
            this.bGj = jSONObject.optLong("user_id2");
            this.bGk = jSONObject.optLong("live_id2");
        }
    }

    public boolean Rt() {
        return this.bGg == 2;
    }

    public boolean UU() {
        return this.bGg == 3 || this.bGg == 4;
    }

    public long UV() {
        return this.bGf;
    }

    public int RE() {
        return this.bGg;
    }

    public long UW() {
        return this.bGh;
    }
}
