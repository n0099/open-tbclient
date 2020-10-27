package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YuyinImBarragePayResponseMessage extends JsonHttpResponsedMessage {
    private long bky;

    public YuyinImBarragePayResponseMessage() {
        super(1031047);
    }

    public long IS() {
        return this.bky;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031047) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.bky = optJSONObject.optLong("left_scores");
            }
        }
    }
}
