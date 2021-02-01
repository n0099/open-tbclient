package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private int bQt;
    private com.baidu.live.videochat.b.a bQu;
    private c bQv;
    private AlaLiveInfoData bqM;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.bQt = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bQt = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.bQv = new c();
                this.bQv.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bQu = new com.baidu.live.videochat.b.a();
                this.bQu.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.bqM = new AlaLiveInfoData();
                this.bqM.parserJson(optJSONObject4);
            }
        }
    }

    public boolean WI() {
        return this.bQt == 1;
    }

    public AlaLiveInfoData WJ() {
        return this.bqM;
    }

    public com.baidu.live.videochat.b.a WK() {
        return this.bQu;
    }

    public c WL() {
        return this.bQv;
    }
}
