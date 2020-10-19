package com.baidu.live.videochat.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private long byO;
    private int byP;
    private long byQ;
    private long byR;
    private long byS;
    private long byT;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.byO = jSONObject.optLong("chat_id");
            this.byP = jSONObject.optInt("chat_status");
            this.byQ = jSONObject.optLong("user_id1");
            this.byR = jSONObject.optLong("live_id1");
            this.byS = jSONObject.optLong("user_id2");
            this.byT = jSONObject.optLong("live_id2");
        }
    }

    public boolean RX() {
        return this.byP == 2;
    }

    public boolean RY() {
        return this.byP == 3 || this.byP == 4;
    }

    public long RZ() {
        return this.byO;
    }

    public int Sa() {
        return this.byP;
    }

    public long Sb() {
        return this.byQ;
    }
}
