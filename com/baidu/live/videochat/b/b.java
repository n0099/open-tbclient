package com.baidu.live.videochat.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private long bgn;
    private int bgo;
    private long bgp;
    private long bgq;
    private long bgr;
    private long bgt;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bgn = jSONObject.optLong("chat_id");
            this.bgo = jSONObject.optInt("chat_status");
            this.bgp = jSONObject.optLong("user_id1");
            this.bgq = jSONObject.optLong("live_id1");
            this.bgr = jSONObject.optLong("user_id2");
            this.bgt = jSONObject.optLong("live_id2");
        }
    }

    public boolean IG() {
        return this.bgo == 2;
    }

    public boolean IH() {
        return this.bgo == 3 || this.bgo == 4;
    }

    public long II() {
        return this.bgn;
    }

    public int IJ() {
        return this.bgo;
    }

    public long IK() {
        return this.bgp;
    }
}
