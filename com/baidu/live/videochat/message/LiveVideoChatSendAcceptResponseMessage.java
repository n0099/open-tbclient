package com.baidu.live.videochat.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveVideoChatSendAcceptResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.videochat.b.a bMB;
    private int status;

    public LiveVideoChatSendAcceptResponseMessage() {
        super(1021174);
        this.status = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.status = optJSONObject.optInt("accept_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.bMB = new com.baidu.live.videochat.b.a();
                this.bMB.parserJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.videochat.b.a XJ() {
        return this.bMB;
    }
}
