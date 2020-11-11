package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private int bJf;
    private com.baidu.live.videochat.b.a bJg;
    private c bJh;
    private AlaLiveInfoData bmO;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.bJf = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bJf = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.bJh = new c();
                this.bJh.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bJg = new com.baidu.live.videochat.b.a();
                this.bJg.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.bmO = new AlaLiveInfoData();
                this.bmO.parserJson(optJSONObject4);
            }
        }
    }

    public boolean VT() {
        return this.bJf == 1;
    }

    public AlaLiveInfoData VU() {
        return this.bmO;
    }

    public com.baidu.live.videochat.b.a VV() {
        return this.bJg;
    }

    public c VW() {
        return this.bJh;
    }
}
