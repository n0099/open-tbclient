package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveInfoData aYc;
    private int blY;
    private com.baidu.live.videochat.b.a blZ;
    private c bma;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.blY = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.blY = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.bma = new c();
                this.bma.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.blZ = new com.baidu.live.videochat.b.a();
                this.blZ.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.aYc = new AlaLiveInfoData();
                this.aYc.parserJson(optJSONObject4);
            }
        }
    }

    public boolean Kl() {
        return this.blY == 1;
    }

    public AlaLiveInfoData Km() {
        return this.aYc;
    }

    public com.baidu.live.videochat.b.a Kn() {
        return this.blZ;
    }

    public c Ko() {
        return this.bma;
    }
}
