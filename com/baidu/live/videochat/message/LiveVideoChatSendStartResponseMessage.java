package com.baidu.live.videochat.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.e;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveVideoChatSendStartResponseMessage extends JsonHttpResponsedMessage {
    private e bMJ;

    public LiveVideoChatSendStartResponseMessage() {
        super(1021177);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bMJ = new e();
            this.bMJ.bLu = optJSONObject.optInt("start_status");
            this.bMJ.bLv = optJSONObject.optString("start_text");
        }
    }

    public e XT() {
        return this.bMJ;
    }
}
