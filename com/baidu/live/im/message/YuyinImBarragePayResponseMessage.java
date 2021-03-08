package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class YuyinImBarragePayResponseMessage extends JsonHttpResponsedMessage {
    private long brm;

    public YuyinImBarragePayResponseMessage() {
        super(1031047);
    }

    public long HJ() {
        return this.brm;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031047) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.brm = optJSONObject.optLong("left_scores");
            }
        }
    }
}
