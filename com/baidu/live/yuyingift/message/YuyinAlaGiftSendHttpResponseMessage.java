package com.baidu.live.yuyingift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class YuyinAlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bhM;
    private long bhN;
    private com.baidu.live.yuyingift.a.a cbz;
    private long mLogId;

    public YuyinAlaGiftSendHttpResponseMessage() {
        super(1031055);
        this.bhM = 0L;
    }

    public long HJ() {
        return this.bhM;
    }

    public long HK() {
        return this.bhN;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.yuyingift.a.a Zb() {
        return this.cbz;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031055) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bhM = jSONObject.optLong("left_scores");
            this.bhN = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.cbz = com.baidu.live.yuyingift.a.a.as(optJSONObject);
            }
        }
    }
}
