package com.baidu.live.message;

import com.baidu.live.data.ak;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetLiveActivityDynamicHttpResponseMessage extends JsonHttpResponsedMessage {
    private ak asy;

    public GetLiveActivityDynamicHttpResponseMessage() {
        super(1021126);
    }

    public ak wC() {
        return this.asy;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.asy = new ak();
            this.asy.parserJson(jSONObject);
        }
    }
}
