package com.baidu.live.videochat.b;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private long brA;
    private long brB;
    private long brC;
    private long brx;
    private int bry;
    private long brz;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.brx = jSONObject.optLong("chat_id");
            this.bry = jSONObject.optInt("chat_status");
            this.brz = jSONObject.optLong("user_id1");
            this.brA = jSONObject.optLong("live_id1");
            this.brB = jSONObject.optLong("user_id2");
            this.brC = jSONObject.optLong("live_id2");
        }
    }

    public boolean PS() {
        return this.bry == 2;
    }

    public boolean PT() {
        return this.bry == 3 || this.bry == 4;
    }

    public long PU() {
        return this.brx;
    }

    public int PV() {
        return this.bry;
    }

    public long PW() {
        return this.brz;
    }
}
