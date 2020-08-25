package com.baidu.live.follow.http;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class FollowStatusHttpResponsedMessage extends JsonHttpResponsedMessage {
    private boolean aMD;

    public FollowStatusHttpResponsedMessage() {
        super(1021196);
    }

    public boolean Du() {
        return this.aMD;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aMD = optJSONObject.optInt("is_follow", 0) == 1;
        }
    }
}
