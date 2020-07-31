package com.baidu.live.videochat.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private long blO;
    private int blP;
    private long blQ;
    private long blR;
    private long blS;
    private long blT;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.blO = jSONObject.optLong("chat_id");
            this.blP = jSONObject.optInt("chat_status");
            this.blQ = jSONObject.optLong("user_id1");
            this.blR = jSONObject.optLong("live_id1");
            this.blS = jSONObject.optLong("user_id2");
            this.blT = jSONObject.optLong("live_id2");
        }
    }

    public boolean Ka() {
        return this.blP == 2;
    }

    public boolean Kb() {
        return this.blP == 3 || this.blP == 4;
    }

    public long Kc() {
        return this.blO;
    }

    public int Kd() {
        return this.blP;
    }

    public long Ke() {
        return this.blQ;
    }
}
