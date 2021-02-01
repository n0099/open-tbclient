package com.baidu.live.yyrtc;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LiveYYRtcTokenHttpResponseMessage extends JsonHttpResponsedMessage {
    private String token;

    public String getToken() {
        return this.token;
    }

    public LiveYYRtcTokenHttpResponseMessage() {
        super(1021240);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.token = optJSONObject.optString("token");
        }
    }
}
