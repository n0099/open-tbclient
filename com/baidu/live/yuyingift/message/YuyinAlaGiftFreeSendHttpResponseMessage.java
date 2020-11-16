package com.baidu.live.yuyingift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YuyinAlaGiftFreeSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bck;

    public YuyinAlaGiftFreeSendHttpResponseMessage() {
        super(1031056);
        this.bck = 0L;
    }

    public long IJ() {
        return this.bck;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031056) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bck = jSONObject.optLong("left_petal");
        }
    }
}
