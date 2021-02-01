package com.baidu.live.follow.http;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaFollowStatusHttpResponseMessage extends JsonHttpResponsedMessage {
    private boolean aUX;

    public AlaFollowStatusHttpResponseMessage() {
        super(1021234);
    }

    public boolean Dn() {
        return this.aUX;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aUX = optJSONObject.optInt("is_follow", 0) == 1;
        }
    }
}
