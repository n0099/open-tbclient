package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private int bRp;
    private com.baidu.live.videochat.b.a bRq;
    private c bRr;
    private AlaLiveInfoData brX;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.bRp = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bRp = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.bRr = new c();
                this.bRr.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bRq = new com.baidu.live.videochat.b.a();
                this.bRq.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.brX = new AlaLiveInfoData();
                this.brX.parserJson(optJSONObject4);
            }
        }
    }

    public boolean YR() {
        return this.bRp == 1;
    }

    public AlaLiveInfoData YS() {
        return this.brX;
    }

    public com.baidu.live.videochat.b.a YT() {
        return this.bRq;
    }

    public c YU() {
        return this.bRr;
    }
}
