package com.baidu.live.videochat.b;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private long bLn;
    private int bLo;
    private long bLp;
    private long bLq;
    private long bLr;
    private long bLs;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bLn = jSONObject.optLong("chat_id");
            this.bLo = jSONObject.optInt(AlaRecorderLog.KEY_CHAT_STATUS);
            this.bLp = jSONObject.optLong("user_id1");
            this.bLq = jSONObject.optLong("live_id1");
            this.bLr = jSONObject.optLong("user_id2");
            this.bLs = jSONObject.optLong("live_id2");
        }
    }

    public boolean TR() {
        return this.bLo == 2;
    }

    public boolean Xu() {
        return this.bLo == 3 || this.bLo == 4;
    }

    public long Xv() {
        return this.bLn;
    }

    public int Uc() {
        return this.bLo;
    }

    public long Xw() {
        return this.bLp;
    }
}
