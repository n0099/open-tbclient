package com.baidu.live.message;

import com.baidu.live.data.ac;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GetLiveActivityHttpResponseMessage extends JsonHttpResponsedMessage {
    private ac ajP;

    public ac ur() {
        return this.ajP;
    }

    public GetLiveActivityHttpResponseMessage() {
        super(1021122);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.ajP = new ac();
            this.ajP.parserJson(jSONObject);
        }
    }
}
