package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveInfoData bfM;
    private c bgA;
    private int bgy;
    private com.baidu.live.videochat.b.a bgz;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.bgy = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bgy = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.bgA = new c();
                this.bgA.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bgz = new com.baidu.live.videochat.b.a();
                this.bgz.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.bfM = new AlaLiveInfoData();
                this.bfM.parserJson(optJSONObject4);
            }
        }
    }

    public boolean IR() {
        return this.bgy == 1;
    }

    public AlaLiveInfoData IS() {
        return this.bfM;
    }

    public com.baidu.live.videochat.b.a IT() {
        return this.bgz;
    }

    public c IU() {
        return this.bgA;
    }
}
