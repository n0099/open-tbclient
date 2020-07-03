package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveInfoData aWb;
    private int blE;
    private com.baidu.live.videochat.b.a blF;
    private c blG;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.blE = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.blE = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.blG = new c();
                this.blG.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.blF = new com.baidu.live.videochat.b.a();
                this.blF.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.aWb = new AlaLiveInfoData();
                this.aWb.parserJson(optJSONObject4);
            }
        }
    }

    public boolean Ke() {
        return this.blE == 1;
    }

    public AlaLiveInfoData Kf() {
        return this.aWb;
    }

    public com.baidu.live.videochat.b.a Kg() {
        return this.blF;
    }

    public c Kh() {
        return this.blG;
    }
}
