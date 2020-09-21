package com.baidu.live.videochat.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private long buM;
    private int buN;
    private long buO;
    private long buP;
    private long buQ;
    private long buR;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.buM = jSONObject.optLong("chat_id");
            this.buN = jSONObject.optInt("chat_status");
            this.buO = jSONObject.optLong("user_id1");
            this.buP = jSONObject.optLong("live_id1");
            this.buQ = jSONObject.optLong("user_id2");
            this.buR = jSONObject.optLong("live_id2");
        }
    }

    public boolean QA() {
        return this.buN == 2;
    }

    public boolean QB() {
        return this.buN == 3 || this.buN == 4;
    }

    public long QC() {
        return this.buM;
    }

    public int QD() {
        return this.buN;
    }

    public long QE() {
        return this.buO;
    }
}
