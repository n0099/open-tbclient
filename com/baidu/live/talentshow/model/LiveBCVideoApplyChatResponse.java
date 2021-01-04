package com.baidu.live.talentshow.model;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LiveBCVideoApplyChatResponse extends JsonHttpResponsedMessage {
    private String bFP;
    private String status;

    public LiveBCVideoApplyChatResponse() {
        super(1021222);
        this.status = "";
        this.bFP = "";
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (BdLog.isDebugMode()) {
            BdLog.e("LiveBBChatApplyChatResponse:  " + jSONObject.toString());
        }
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.status = optJSONObject.optString("status");
            this.bFP = optJSONObject.optString("count_down");
        }
    }

    public String getStatus() {
        return this.status;
    }

    public String US() {
        return this.bFP;
    }
}
