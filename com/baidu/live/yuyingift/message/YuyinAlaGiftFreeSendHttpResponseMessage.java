package com.baidu.live.yuyingift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class YuyinAlaGiftFreeSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bhL;

    public YuyinAlaGiftFreeSendHttpResponseMessage() {
        super(1031056);
        this.bhL = 0L;
    }

    public long HI() {
        return this.bhL;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031056) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bhL = jSONObject.optLong("left_petal");
        }
    }
}
