package com.baidu.live.sdk.goods.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GetSingleGoodsHttpResponseMessage extends JsonHttpResponsedMessage {
    public com.baidu.live.sdk.goods.a.a bzE;

    public GetSingleGoodsHttpResponseMessage() {
        super(1021201);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("result")) != null && getError() == 0) {
            this.bzE = com.baidu.live.sdk.goods.a.a.Y(optJSONObject);
        }
    }
}
