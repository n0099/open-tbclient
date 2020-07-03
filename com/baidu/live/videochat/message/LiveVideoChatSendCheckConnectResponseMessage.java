package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveVideoChatSendCheckConnectResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveInfoData aWb;
    private com.baidu.live.videochat.b.a blF;
    private c blG;
    private String bls;
    private long mInterval;
    private int status;

    public LiveVideoChatSendCheckConnectResponseMessage() {
        super(1021179);
        this.mInterval = 3000L;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.status = optJSONObject.optInt("get_status");
            this.bls = optJSONObject.optString("get_text");
            this.mInterval = optJSONObject.optInt("interval", 3000);
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

    public com.baidu.live.videochat.b.a Kg() {
        return this.blF;
    }

    public c Kh() {
        return this.blG;
    }

    public AlaLiveInfoData Ki() {
        return this.aWb;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusText() {
        return this.bls;
    }

    public long getInterval() {
        return this.mInterval;
    }
}
