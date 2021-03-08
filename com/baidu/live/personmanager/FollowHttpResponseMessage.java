package com.baidu.live.personmanager;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class FollowHttpResponseMessage extends JsonHttpResponsedMessage {
    public FollowHttpResponseMessage() {
        super(1031045);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() != 0) {
        }
    }
}
