package com.baidu.live.sdk.goods.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class HasGoodsAuthResponseMessage extends JsonHttpResponsedMessage {
    public boolean bsI;

    public HasGoodsAuthResponseMessage() {
        super(1021143);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.bsI = optJSONObject.optBoolean("isAuth");
        }
    }
}
