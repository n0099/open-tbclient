package com.baidu.live.videochat.b;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private long bQA;
    private long bQB;
    private long bQC;
    private long bQD;
    private long bQy;
    private int bQz;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bQy = jSONObject.optLong("chat_id");
            this.bQz = jSONObject.optInt(AlaRecorderLog.KEY_CHAT_STATUS);
            this.bQA = jSONObject.optLong("user_id1");
            this.bQB = jSONObject.optLong("live_id1");
            this.bQC = jSONObject.optLong("user_id2");
            this.bQD = jSONObject.optLong("live_id2");
        }
    }

    public boolean SN() {
        return this.bQz == 2;
    }

    public boolean Wu() {
        return this.bQz == 3 || this.bQz == 4;
    }

    public long Wv() {
        return this.bQy;
    }

    public int SY() {
        return this.bQz;
    }

    public long Ww() {
        return this.bQA;
    }
}
