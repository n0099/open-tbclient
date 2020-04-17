package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private int aYW;
    private com.baidu.live.videochat.b.a aYX;
    private c aYY;
    private AlaLiveInfoData aYl;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.aYW = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aYW = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.aYY = new c();
                this.aYY.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.aYX = new com.baidu.live.videochat.b.a();
                this.aYX.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.aYl = new AlaLiveInfoData();
                this.aYl.parserJson(optJSONObject4);
            }
        }
    }

    public boolean GZ() {
        return this.aYW == 1;
    }

    public AlaLiveInfoData Ha() {
        return this.aYl;
    }

    public com.baidu.live.videochat.b.a Hb() {
        return this.aYX;
    }

    public c Hc() {
        return this.aYY;
    }
}
