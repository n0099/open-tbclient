package com.baidu.live.videochat.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveVideoChatSendGetChatInfoResponseMessage extends JsonHttpResponsedMessage {
    private d bJj;
    private d bJk;
    private com.baidu.live.videochat.b.b bJl;
    private long mInterval;

    public LiveVideoChatSendGetChatInfoResponseMessage() {
        super(1021180);
        this.mInterval = 2000L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.mInterval = optJSONObject.optLong("interval", 2000L);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("chat_info");
            if (optJSONObject2 != null) {
                this.bJl = new com.baidu.live.videochat.b.b();
                this.bJl.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.bJj = new d();
                this.bJj.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.bJk = new d();
                this.bJk.parserJson(optJSONObject4);
            }
        }
    }

    public long getInterval() {
        return this.mInterval;
    }

    public d VZ() {
        return this.bJj;
    }

    public d Wa() {
        return this.bJk;
    }

    public com.baidu.live.videochat.b.b Wb() {
        return this.bJl;
    }
}
