package com.baidu.live.videochat.b;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private long bQa;
    private int bQb;
    private long bQc;
    private long bQd;
    private long bQe;
    private long bQf;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bQa = jSONObject.optLong("chat_id");
            this.bQb = jSONObject.optInt(AlaRecorderLog.KEY_CHAT_STATUS);
            this.bQc = jSONObject.optLong("user_id1");
            this.bQd = jSONObject.optLong("live_id1");
            this.bQe = jSONObject.optLong("user_id2");
            this.bQf = jSONObject.optLong("live_id2");
        }
    }

    public boolean UW() {
        return this.bQb == 2;
    }

    public boolean YB() {
        return this.bQb == 3 || this.bQb == 4;
    }

    public long YC() {
        return this.bQa;
    }

    public int Vh() {
        return this.bQb;
    }

    public long YD() {
        return this.bQc;
    }
}
