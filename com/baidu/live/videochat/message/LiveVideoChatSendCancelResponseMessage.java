package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private int bRT;
    private com.baidu.live.videochat.b.a bRU;
    private c bRV;
    private AlaLiveInfoData bsm;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.bRT = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bRT = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.bRV = new c();
                this.bRV.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bRU = new com.baidu.live.videochat.b.a();
                this.bRU.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.bsm = new AlaLiveInfoData();
                this.bsm.parserJson(optJSONObject4);
            }
        }
    }

    public boolean WL() {
        return this.bRT == 1;
    }

    public AlaLiveInfoData WM() {
        return this.bsm;
    }

    public com.baidu.live.videochat.b.a WN() {
        return this.bRU;
    }

    public c WO() {
        return this.bRV;
    }
}
