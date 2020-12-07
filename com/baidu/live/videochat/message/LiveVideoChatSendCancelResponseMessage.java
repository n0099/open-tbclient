package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private int bMC;
    private com.baidu.live.videochat.b.a bMD;
    private c bME;
    private AlaLiveInfoData bqm;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.bMC = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bMC = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.bME = new c();
                this.bME.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bMD = new com.baidu.live.videochat.b.a();
                this.bMD.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.bqm = new AlaLiveInfoData();
                this.bqm.parserJson(optJSONObject4);
            }
        }
    }

    public boolean XK() {
        return this.bMC == 1;
    }

    public AlaLiveInfoData XL() {
        return this.bqm;
    }

    public com.baidu.live.videochat.b.a XM() {
        return this.bMD;
    }

    public c XN() {
        return this.bME;
    }
}
