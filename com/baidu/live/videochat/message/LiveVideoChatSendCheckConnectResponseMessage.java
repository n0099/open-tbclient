package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveVideoChatSendCheckConnectResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveInfoData aYc;
    private String blM;
    private com.baidu.live.videochat.b.a blZ;
    private c bma;
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
            this.blM = optJSONObject.optString("get_text");
            this.mInterval = optJSONObject.optInt("interval", 3000);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.bma = new c();
                this.bma.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.blZ = new com.baidu.live.videochat.b.a();
                this.blZ.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.aYc = new AlaLiveInfoData();
                this.aYc.parserJson(optJSONObject4);
            }
        }
    }

    public com.baidu.live.videochat.b.a Kn() {
        return this.blZ;
    }

    public c Ko() {
        return this.bma;
    }

    public AlaLiveInfoData Kp() {
        return this.aYc;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusText() {
        return this.blM;
    }

    public long getInterval() {
        return this.mInterval;
    }
}
