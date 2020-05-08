package com.baidu.live.message;

import com.baidu.live.data.an;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetLiveActivityHttpResponseMessage extends JsonHttpResponsedMessage {
    private an aQD;

    public an DT() {
        return this.aQD;
    }

    public GetLiveActivityHttpResponseMessage() {
        super(1021122);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aQD = new an();
            this.aQD.parserJson(jSONObject);
        }
    }
}
