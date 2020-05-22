package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveVideoChatSendCheckConnectResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveInfoData bfM;
    private c bgA;
    private String bgl;
    private com.baidu.live.videochat.b.a bgz;
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
            this.bgl = optJSONObject.optString("get_text");
            this.mInterval = optJSONObject.optInt("interval", 3000);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.bgA = new c();
                this.bgA.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bgz = new com.baidu.live.videochat.b.a();
                this.bgz.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.bfM = new AlaLiveInfoData();
                this.bfM.parserJson(optJSONObject4);
            }
        }
    }

    public com.baidu.live.videochat.b.a IT() {
        return this.bgz;
    }

    public c IU() {
        return this.bgA;
    }

    public AlaLiveInfoData IV() {
        return this.bfM;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusText() {
        return this.bgl;
    }

    public long getInterval() {
        return this.mInterval;
    }
}
