package com.baidu.live.talentshow.model;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LiveBCVideoCheckUserResponse extends JsonHttpResponsedMessage {
    private String bHy;
    private int userStatus;

    public LiveBCVideoCheckUserResponse(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (BdLog.isDebugMode()) {
            BdLog.e("LiveBBChatApplyChatResponse:  " + jSONObject.toString());
        }
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.userStatus = JavaTypesHelper.toInt(optJSONObject.optString("status"), 1);
            this.bHy = optJSONObject.optString("text");
        }
    }

    public int getUserStatus() {
        return this.userStatus;
    }

    public String Vx() {
        return this.bHy;
    }
}
