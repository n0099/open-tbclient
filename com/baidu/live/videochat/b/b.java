package com.baidu.live.videochat.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private long blu;
    private int blv;
    private long blw;
    private long blx;
    private long bly;
    private long blz;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.blu = jSONObject.optLong("chat_id");
            this.blv = jSONObject.optInt("chat_status");
            this.blw = jSONObject.optLong("user_id1");
            this.blx = jSONObject.optLong("live_id1");
            this.bly = jSONObject.optLong("user_id2");
            this.blz = jSONObject.optLong("live_id2");
        }
    }

    public boolean JT() {
        return this.blv == 2;
    }

    public boolean JU() {
        return this.blv == 3 || this.blv == 4;
    }

    public long JV() {
        return this.blu;
    }

    public int JW() {
        return this.blv;
    }

    public long JX() {
        return this.blw;
    }
}
