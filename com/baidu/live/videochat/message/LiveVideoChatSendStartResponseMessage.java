package com.baidu.live.videochat.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveVideoChatSendStartResponseMessage extends JsonHttpResponsedMessage {
    private e bgF;

    public LiveVideoChatSendStartResponseMessage() {
        super(1021177);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bgF = new e();
            this.bgF.bgv = optJSONObject.optInt("start_status");
            this.bgF.bgw = optJSONObject.optString("start_text");
        }
    }

    public e Ja() {
        return this.bgF;
    }
}
