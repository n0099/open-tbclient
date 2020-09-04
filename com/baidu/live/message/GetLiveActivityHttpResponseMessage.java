package com.baidu.live.message;

import com.baidu.live.data.az;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetLiveActivityHttpResponseMessage extends JsonHttpResponsedMessage {
    private az beS;

    public az LJ() {
        return this.beS;
    }

    public GetLiveActivityHttpResponseMessage() {
        super(1021122);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.beS = new az();
            this.beS.parserJson(jSONObject);
        }
    }
}
