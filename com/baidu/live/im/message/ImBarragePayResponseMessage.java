package com.baidu.live.im.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ImBarragePayResponseMessage extends JsonHttpResponsedMessage {
    private long ahv;

    public ImBarragePayResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
    }

    public long rn() {
        return this.ahv;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021133) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.ahv = optJSONObject.optLong("left_scores");
            }
        }
    }
}
