package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private int bMD;
    private com.baidu.live.videochat.b.a bME;
    private c bMF;
    private AlaLiveInfoData bnl;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.bMD = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bMD = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.bMF = new c();
                this.bMF.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bME = new com.baidu.live.videochat.b.a();
                this.bME.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.bnl = new AlaLiveInfoData();
                this.bnl.parserJson(optJSONObject4);
            }
        }
    }

    public boolean UZ() {
        return this.bMD == 1;
    }

    public AlaLiveInfoData Va() {
        return this.bnl;
    }

    public com.baidu.live.videochat.b.a Vb() {
        return this.bME;
    }

    public c Vc() {
        return this.bMF;
    }
}
