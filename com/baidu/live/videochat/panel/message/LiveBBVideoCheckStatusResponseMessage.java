package com.baidu.live.videochat.panel.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveBBVideoCheckStatusResponseMessage extends JsonHttpResponsedMessage {
    private boolean bEx;
    private int bEy;

    public LiveBBVideoCheckStatusResponseMessage() {
        super(1021217);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bEx = optJSONObject.optInt("live_status") == 1;
            this.bEy = optJSONObject.optInt("liveconnect_status");
        }
    }

    public boolean DQ() {
        return this.bEx;
    }

    public boolean TM() {
        return this.bEy == 0;
    }
}
