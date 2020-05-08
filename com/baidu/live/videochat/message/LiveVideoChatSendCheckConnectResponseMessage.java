package com.baidu.live.videochat.message;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveVideoChatSendCheckConnectResponseMessage extends JsonHttpResponsedMessage {
    private String aYP;
    private AlaLiveInfoData aYq;
    private com.baidu.live.videochat.b.a aZc;
    private c aZd;
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
            this.aYP = optJSONObject.optString("get_text");
            this.mInterval = optJSONObject.optInt("interval", 3000);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.aZd = new c();
                this.aZd.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.aZc = new com.baidu.live.videochat.b.a();
                this.aZc.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.aYq = new AlaLiveInfoData();
                this.aYq.parserJson(optJSONObject4);
            }
        }
    }

    public com.baidu.live.videochat.b.a Ha() {
        return this.aZc;
    }

    public c Hb() {
        return this.aZd;
    }

    public AlaLiveInfoData Hc() {
        return this.aYq;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusText() {
        return this.aYP;
    }

    public long getInterval() {
        return this.mInterval;
    }
}
