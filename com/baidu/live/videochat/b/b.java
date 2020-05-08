package com.baidu.live.videochat.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private long aYR;
    private int aYS;
    private long aYT;
    private long aYU;
    private long aYV;
    private long aYW;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aYR = jSONObject.optLong("chat_id");
            this.aYS = jSONObject.optInt("chat_status");
            this.aYT = jSONObject.optLong("user_id1");
            this.aYU = jSONObject.optLong("live_id1");
            this.aYV = jSONObject.optLong("user_id2");
            this.aYW = jSONObject.optLong("live_id2");
        }
    }

    public boolean GN() {
        return this.aYS == 2;
    }

    public boolean GO() {
        return this.aYS == 3 || this.aYS == 4;
    }

    public long GP() {
        return this.aYR;
    }

    public int GQ() {
        return this.aYS;
    }

    public long GR() {
        return this.aYT;
    }
}
