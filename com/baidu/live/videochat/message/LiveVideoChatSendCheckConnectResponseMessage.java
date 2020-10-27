package com.baidu.live.videochat.message;

import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveVideoChatSendCheckConnectResponseMessage extends JsonHttpResponsedMessage {
    private String bBI;
    private c bDA;
    private com.baidu.live.videochat.b.a bDz;
    private AlaLiveInfoData blu;
    private long mInterval;
    private int status;

    public LiveVideoChatSendCheckConnectResponseMessage() {
        super(1021179);
        this.mInterval = IMConnection.RETRY_DELAY_TIMES;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.status = optJSONObject.optInt("get_status");
            this.bBI = optJSONObject.optString("get_text");
            this.mInterval = optJSONObject.optInt("interval", 3000);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.bDA = new c();
                this.bDA.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.bDz = new com.baidu.live.videochat.b.a();
                this.bDz.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.blu = new AlaLiveInfoData();
                this.blu.parserJson(optJSONObject4);
            }
        }
    }

    public com.baidu.live.videochat.b.a Tv() {
        return this.bDz;
    }

    public c Tw() {
        return this.bDA;
    }

    public AlaLiveInfoData Tx() {
        return this.blu;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusText() {
        return this.bBI;
    }

    public long getInterval() {
        return this.mInterval;
    }
}
