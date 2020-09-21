package com.baidu.live.videochat.message;

import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveVideoChatSendCheckConnectResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveInfoData bgj;
    private String buK;
    private com.baidu.live.videochat.b.a buX;
    private c buY;
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
            this.buK = optJSONObject.optString("get_text");
            this.mInterval = optJSONObject.optInt("interval", 3000);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.buY = new c();
                this.buY.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.buX = new com.baidu.live.videochat.b.a();
                this.buX.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.bgj = new AlaLiveInfoData();
                this.bgj.parserJson(optJSONObject4);
            }
        }
    }

    public com.baidu.live.videochat.b.a QN() {
        return this.buX;
    }

    public c QO() {
        return this.buY;
    }

    public AlaLiveInfoData QP() {
        return this.bgj;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusText() {
        return this.buK;
    }

    public long getInterval() {
        return this.mInterval;
    }
}
