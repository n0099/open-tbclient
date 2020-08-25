package com.baidu.live.videochat.b;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private long bru;
    private int brv;
    private long brw;
    private long brx;
    private long bry;
    private long brz;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bru = jSONObject.optLong("chat_id");
            this.brv = jSONObject.optInt("chat_status");
            this.brw = jSONObject.optLong("user_id1");
            this.brx = jSONObject.optLong("live_id1");
            this.bry = jSONObject.optLong("user_id2");
            this.brz = jSONObject.optLong("live_id2");
        }
    }

    public boolean PS() {
        return this.brv == 2;
    }

    public boolean PT() {
        return this.brv == 3 || this.brv == 4;
    }

    public long PU() {
        return this.bru;
    }

    public int PV() {
        return this.brv;
    }

    public long PW() {
        return this.brw;
    }
}
