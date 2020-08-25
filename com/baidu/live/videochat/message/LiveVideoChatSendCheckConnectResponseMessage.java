package com.baidu.live.videochat.message;

import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LiveVideoChatSendCheckConnectResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveInfoData bds;
    private com.baidu.live.videochat.b.a brF;
    private c brG;
    private String brs;
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
            this.brs = optJSONObject.optString("get_text");
            this.mInterval = optJSONObject.optInt("interval", 3000);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.brG = new c();
                this.brG.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject3 != null) {
                this.brF = new com.baidu.live.videochat.b.a();
                this.brF.parserJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject4 != null) {
                this.bds = new AlaLiveInfoData();
                this.bds.parserJson(optJSONObject4);
            }
        }
    }

    public com.baidu.live.videochat.b.a Qf() {
        return this.brF;
    }

    public c Qg() {
        return this.brG;
    }

    public AlaLiveInfoData Qh() {
        return this.bds;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusText() {
        return this.brs;
    }

    public long getInterval() {
        return this.mInterval;
    }
}
