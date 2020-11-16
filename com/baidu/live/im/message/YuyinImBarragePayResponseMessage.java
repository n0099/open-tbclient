package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YuyinImBarragePayResponseMessage extends JsonHttpResponsedMessage {
    private long bkh;

    public YuyinImBarragePayResponseMessage() {
        super(1031047);
    }

    public long IK() {
        return this.bkh;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031047) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.bkh = optJSONObject.optLong("left_scores");
            }
        }
    }
}
