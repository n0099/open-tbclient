package com.baidu.live.message;

import com.baidu.live.data.al;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetLiveActivityDynamicHttpResponseMessage extends JsonHttpResponsedMessage {
    private al awU;

    public GetLiveActivityDynamicHttpResponseMessage() {
        super(1021126);
    }

    public al yZ() {
        return this.awU;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.awU = new al();
            this.awU.parserJson(jSONObject);
        }
    }
}
