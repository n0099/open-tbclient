package com.baidu.live.talentshow.model;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveBCVideoApplyChatResponse extends JsonHttpResponsedMessage {
    private String bvS;
    private String status;

    public LiveBCVideoApplyChatResponse() {
        super(1021222);
        this.status = "";
        this.bvS = "";
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (BdLog.isDebugMode()) {
            BdLog.e("LiveBBChatApplyChatResponse:  " + jSONObject.toString());
        }
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.status = optJSONObject.optString("status");
            this.bvS = optJSONObject.optString("count_down");
        }
    }

    public String getStatus() {
        return this.status;
    }

    public String Rp() {
        return this.bvS;
    }
}
