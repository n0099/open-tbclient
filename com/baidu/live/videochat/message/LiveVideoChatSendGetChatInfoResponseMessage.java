package com.baidu.live.videochat.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveVideoChatSendGetChatInfoResponseMessage extends JsonHttpResponsedMessage {
    private d bva;
    private d bvb;
    private com.baidu.live.videochat.b.b bvc;
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
                this.bvc = new com.baidu.live.videochat.b.b();
                this.bvc.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.bva = new d();
                this.bva.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.bvb = new d();
                this.bvb.parserJson(optJSONObject4);
            }
        }
    }

    public long getInterval() {
        return this.mInterval;
    }

    public d QR() {
        return this.bva;
    }

    public d QS() {
        return this.bvb;
    }

    public com.baidu.live.videochat.b.b QT() {
        return this.bvc;
    }
}
