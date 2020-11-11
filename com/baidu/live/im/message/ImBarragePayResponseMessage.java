package com.baidu.live.im.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ImBarragePayResponseMessage extends JsonHttpResponsedMessage {
    private long blS;

    public ImBarragePayResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
    }

    public long Jt() {
        return this.blS;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021133) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.blS = optJSONObject.optLong("left_scores");
            }
        }
    }
}
