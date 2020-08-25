package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class NotifyOfficialMsgHttpResponseMessage extends JsonHttpResponsedMessage {
    public NotifyOfficialMsgHttpResponseMessage() {
        super(1021184);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null) {
        }
    }
}
