package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveInfoData bds;
    private int brE;
    private com.baidu.live.videochat.b.a brF;
    private c brG;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.brE = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.brE = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.brG = new c();
                this.brG.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.brF = new com.baidu.live.videochat.b.a();
                this.brF.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.bds = new AlaLiveInfoData();
                this.bds.parserJson(optJSONObject4);
            }
        }
    }

    public boolean Qd() {
        return this.brE == 1;
    }

    public AlaLiveInfoData Qe() {
        return this.bds;
    }

    public com.baidu.live.videochat.b.a Qf() {
        return this.brF;
    }

    public c Qg() {
        return this.brG;
    }
}
