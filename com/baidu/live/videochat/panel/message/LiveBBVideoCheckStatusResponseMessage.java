package com.baidu.live.videochat.panel.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveBBVideoCheckStatusResponseMessage extends JsonHttpResponsedMessage {
    private boolean bKe;
    private int bKf;

    public LiveBBVideoCheckStatusResponseMessage() {
        super(1021217);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bKe = optJSONObject.optInt("live_status") == 1;
            this.bKf = optJSONObject.optInt("liveconnect_status");
        }
    }

    public boolean Ej() {
        return this.bKe;
    }

    public boolean Wm() {
        return this.bKf == 0;
    }
}
