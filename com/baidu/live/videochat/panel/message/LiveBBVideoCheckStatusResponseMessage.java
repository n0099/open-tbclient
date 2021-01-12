package com.baidu.live.videochat.panel.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LiveBBVideoCheckStatusResponseMessage extends JsonHttpResponsedMessage {
    private boolean bNC;
    private int bND;

    public LiveBBVideoCheckStatusResponseMessage() {
        super(1021217);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bNC = optJSONObject.optInt("live_status") == 1;
            this.bND = optJSONObject.optInt("liveconnect_status");
        }
    }

    public boolean AG() {
        return this.bNC;
    }

    public boolean Vs() {
        return this.bND == 0;
    }
}
