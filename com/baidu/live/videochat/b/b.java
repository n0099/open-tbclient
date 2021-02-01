package com.baidu.live.videochat.b;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private long bOY;
    private int bOZ;
    private long bPa;
    private long bPb;
    private long bPc;
    private long bPd;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bOY = jSONObject.optLong("chat_id");
            this.bOZ = jSONObject.optInt(AlaRecorderLog.KEY_CHAT_STATUS);
            this.bPa = jSONObject.optLong("user_id1");
            this.bPb = jSONObject.optLong("live_id1");
            this.bPc = jSONObject.optLong("user_id2");
            this.bPd = jSONObject.optLong("live_id2");
        }
    }

    public boolean SK() {
        return this.bOZ == 2;
    }

    public boolean Wr() {
        return this.bOZ == 3 || this.bOZ == 4;
    }

    public long Ws() {
        return this.bOY;
    }

    public int SV() {
        return this.bOZ;
    }

    public long Wt() {
        return this.bPa;
    }
}
