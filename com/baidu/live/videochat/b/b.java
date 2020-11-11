package com.baidu.live.videochat.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private long bHQ;
    private int bHR;
    private long bHS;
    private long bHT;
    private long bHU;
    private long bHV;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bHQ = jSONObject.optLong("chat_id");
            this.bHR = jSONObject.optInt("chat_status");
            this.bHS = jSONObject.optLong("user_id1");
            this.bHT = jSONObject.optLong("live_id1");
            this.bHU = jSONObject.optLong("user_id2");
            this.bHV = jSONObject.optLong("live_id2");
        }
    }

    public boolean Sc() {
        return this.bHR == 2;
    }

    public boolean VD() {
        return this.bHR == 3 || this.bHR == 4;
    }

    public long VE() {
        return this.bHQ;
    }

    public int Sn() {
        return this.bHR;
    }

    public long VF() {
        return this.bHS;
    }
}
