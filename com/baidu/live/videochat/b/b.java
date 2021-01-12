package com.baidu.live.videochat.b;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private long bLo;
    private int bLp;
    private long bLq;
    private long bLr;
    private long bLs;
    private long bLt;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bLo = jSONObject.optLong("chat_id");
            this.bLp = jSONObject.optInt(AlaRecorderLog.KEY_CHAT_STATUS);
            this.bLq = jSONObject.optLong("user_id1");
            this.bLr = jSONObject.optLong("live_id1");
            this.bLs = jSONObject.optLong("user_id2");
            this.bLt = jSONObject.optLong("live_id2");
        }
    }

    public boolean Rb() {
        return this.bLp == 2;
    }

    public boolean UI() {
        return this.bLp == 3 || this.bLp == 4;
    }

    public long UJ() {
        return this.bLo;
    }

    public int Ro() {
        return this.bLp;
    }

    public long UK() {
        return this.bLq;
    }
}
