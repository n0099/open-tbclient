package com.baidu.live.videochat.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.d;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LiveVideoChatSendGetChatInfoResponseMessage extends JsonHttpResponsedMessage {
    private d brI;
    private d brJ;
    private com.baidu.live.videochat.b.b brK;
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
                this.brK = new com.baidu.live.videochat.b.b();
                this.brK.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.brI = new d();
                this.brI.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.brJ = new d();
                this.brJ.parserJson(optJSONObject4);
            }
        }
    }

    public long getInterval() {
        return this.mInterval;
    }

    public d Qj() {
        return this.brI;
    }

    public d Qk() {
        return this.brJ;
    }

    public com.baidu.live.videochat.b.b Ql() {
        return this.brK;
    }
}
