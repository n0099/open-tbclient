package com.baidu.live.videochat.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveVideoChatSendGetChatInfoResponseMessage extends JsonHttpResponsedMessage {
    private d bmc;
    private d bmd;
    private com.baidu.live.videochat.b.b bme;
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
                this.bme = new com.baidu.live.videochat.b.b();
                this.bme.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.bmc = new d();
                this.bmc.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.bmd = new d();
                this.bmd.parserJson(optJSONObject4);
            }
        }
    }

    public long getInterval() {
        return this.mInterval;
    }

    public d Kr() {
        return this.bmc;
    }

    public d Ks() {
        return this.bmd;
    }

    public com.baidu.live.videochat.b.b Kt() {
        return this.bme;
    }
}
