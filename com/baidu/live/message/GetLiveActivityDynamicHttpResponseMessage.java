package com.baidu.live.message;

import com.baidu.live.data.ao;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetLiveActivityDynamicHttpResponseMessage extends JsonHttpResponsedMessage {
    private ao aQx;

    public GetLiveActivityDynamicHttpResponseMessage() {
        super(1021126);
    }

    public ao DT() {
        return this.aQx;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aQx = new ao();
            this.aQx.parserJson(jSONObject);
        }
    }
}
