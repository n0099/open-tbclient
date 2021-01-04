package com.baidu.live.yuyingift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class YuyinAlaGiftFreeSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bhS;

    public YuyinAlaGiftFreeSendHttpResponseMessage() {
        super(1031056);
        this.bhS = 0L;
    }

    public long Kk() {
        return this.bhS;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031056) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bhS = jSONObject.optLong("left_petal");
        }
    }
}
