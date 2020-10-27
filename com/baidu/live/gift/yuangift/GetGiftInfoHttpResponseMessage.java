package com.baidu.live.gift.yuangift;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetGiftInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private g beu;

    public GetGiftInfoHttpResponseMessage() {
        super(1021130);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONArray("data") != null && (optJSONArray = jSONObject.optJSONArray("data")) != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            this.beu = new g();
            this.beu.parseJson(optJSONObject);
        }
    }
}
