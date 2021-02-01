package com.baidu.live.message;

import com.baidu.live.data.br;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GetLiveActivityHttpResponseMessage extends JsonHttpResponsedMessage {
    private br bvd;

    public br Ov() {
        return this.bvd;
    }

    public GetLiveActivityHttpResponseMessage() {
        super(1021122);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.bvd = new br();
            this.bvd.parserJson(jSONObject);
        }
    }
}
