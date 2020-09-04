package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LiveVideoChatSendCancelResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveInfoData bdu;
    private int brH;
    private com.baidu.live.videochat.b.a brI;
    private c brJ;

    public LiveVideoChatSendCancelResponseMessage() {
        super(1021173);
        this.brH = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.brH = optJSONObject.optInt("cancel_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.brJ = new c();
                this.brJ.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.brI = new com.baidu.live.videochat.b.a();
                this.brI.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.bdu = new AlaLiveInfoData();
                this.bdu.parserJson(optJSONObject4);
            }
        }
    }

    public boolean Qd() {
        return this.brH == 1;
    }

    public AlaLiveInfoData Qe() {
        return this.bdu;
    }

    public com.baidu.live.videochat.b.a Qf() {
        return this.brI;
    }

    public c Qg() {
        return this.brJ;
    }
}
