package com.baidu.live.videochat.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private long aYM;
    private int aYN;
    private long aYO;
    private long aYP;
    private long aYQ;
    private long aYR;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aYM = jSONObject.optLong("chat_id");
            this.aYN = jSONObject.optInt("chat_status");
            this.aYO = jSONObject.optLong("user_id1");
            this.aYP = jSONObject.optLong("live_id1");
            this.aYQ = jSONObject.optLong("user_id2");
            this.aYR = jSONObject.optLong("live_id2");
        }
    }

    public boolean GO() {
        return this.aYN == 2;
    }

    public boolean GP() {
        return this.aYN == 3 || this.aYN == 4;
    }

    public long GQ() {
        return this.aYM;
    }

    public int GR() {
        return this.aYN;
    }

    public long GS() {
        return this.aYO;
    }
}
