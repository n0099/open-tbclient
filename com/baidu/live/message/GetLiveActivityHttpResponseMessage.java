package com.baidu.live.message;

import com.baidu.live.data.ac;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GetLiveActivityHttpResponseMessage extends JsonHttpResponsedMessage {
    private ac akh;

    public ac uq() {
        return this.akh;
    }

    public GetLiveActivityHttpResponseMessage() {
        super(1021122);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.akh = new ac();
            this.akh.parserJson(jSONObject);
        }
    }
}
