package com.baidu.live.follow.http;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FollowStatusHttpResponsedMessage extends JsonHttpResponsedMessage {
    private boolean aOx;

    public FollowStatusHttpResponsedMessage() {
        super(1021196);
    }

    public boolean DL() {
        return this.aOx;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aOx = optJSONObject.optInt("is_follow", 0) == 1;
        }
    }
}
