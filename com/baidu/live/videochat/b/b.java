package com.baidu.live.videochat.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private long bBK;
    private int bBL;
    private long bBM;
    private long bBN;
    private long bBO;
    private long bBP;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bBK = jSONObject.optLong("chat_id");
            this.bBL = jSONObject.optInt("chat_status");
            this.bBM = jSONObject.optLong("user_id1");
            this.bBN = jSONObject.optLong("live_id1");
            this.bBO = jSONObject.optLong("user_id2");
            this.bBP = jSONObject.optLong("live_id2");
        }
    }

    public boolean SX() {
        return this.bBL == 2;
    }

    public boolean SY() {
        return this.bBL == 3 || this.bBL == 4;
    }

    public long SZ() {
        return this.bBK;
    }

    public int Ta() {
        return this.bBL;
    }

    public long Tb() {
        return this.bBM;
    }
}
