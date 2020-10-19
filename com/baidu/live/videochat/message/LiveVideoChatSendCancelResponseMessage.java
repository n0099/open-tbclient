package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private int bAC;
    private com.baidu.live.videochat.b.a bAD;
    private c bAE;
    private AlaLiveInfoData bjZ;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.bAC = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bAC = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.bAE = new c();
                this.bAE.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bAD = new com.baidu.live.videochat.b.a();
                this.bAD.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.bjZ = new AlaLiveInfoData();
                this.bjZ.parserJson(optJSONObject4);
            }
        }
    }

    public boolean St() {
        return this.bAC == 1;
    }

    public AlaLiveInfoData Su() {
        return this.bjZ;
    }

    public com.baidu.live.videochat.b.a Sv() {
        return this.bAD;
    }

    public c Sw() {
        return this.bAE;
    }
}
