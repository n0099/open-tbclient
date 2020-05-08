package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveInfoData aYq;
    private int aZb;
    private com.baidu.live.videochat.b.a aZc;
    private c aZd;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.aZb = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aZb = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.aZd = new c();
                this.aZd.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.aZc = new com.baidu.live.videochat.b.a();
                this.aZc.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.aYq = new AlaLiveInfoData();
                this.aYq.parserJson(optJSONObject4);
            }
        }
    }

    public boolean GY() {
        return this.aZb == 1;
    }

    public AlaLiveInfoData GZ() {
        return this.aYq;
    }

    public com.baidu.live.videochat.b.a Ha() {
        return this.aZc;
    }

    public c Hb() {
        return this.aZd;
    }
}
