package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private c bDA;
    private int bDy;
    private com.baidu.live.videochat.b.a bDz;
    private AlaLiveInfoData blu;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.bDy = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bDy = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.bDA = new c();
                this.bDA.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bDz = new com.baidu.live.videochat.b.a();
                this.bDz.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.blu = new AlaLiveInfoData();
                this.blu.parserJson(optJSONObject4);
            }
        }
    }

    public boolean Tt() {
        return this.bDy == 1;
    }

    public AlaLiveInfoData Tu() {
        return this.blu;
    }

    public com.baidu.live.videochat.b.a Tv() {
        return this.bDz;
    }

    public c Tw() {
        return this.bDA;
    }
}
