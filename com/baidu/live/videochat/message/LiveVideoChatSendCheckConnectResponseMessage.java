package com.baidu.live.videochat.message;

import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.videochat.b.c;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LiveVideoChatSendCheckConnectResponseMessage extends JsonHttpResponsedMessage {
    private String bLm;
    private com.baidu.live.videochat.b.a bME;
    private c bMF;
    private AlaLiveInfoData bnl;
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
            this.bLm = optJSONObject.optString("get_text");
            this.mInterval = optJSONObject.optInt("interval", 3000);
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

    public com.baidu.live.videochat.b.a Vb() {
        return this.bME;
    }

    public c Vc() {
        return this.bMF;
    }

    public AlaLiveInfoData Vd() {
        return this.bnl;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusText() {
        return this.bLm;
    }

    public long getInterval() {
        return this.mInterval;
    }
}
