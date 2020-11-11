package com.baidu.live.yuyingift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YuyinAlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.yuyingift.a.a bRq;
    private long bdW;
    private long bdX;
    private long mLogId;

    public YuyinAlaGiftSendHttpResponseMessage() {
        super(1031055);
        this.bdW = 0L;
    }

    public long Jt() {
        return this.bdW;
    }

    public long Ju() {
        return this.bdX;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.yuyingift.a.a XF() {
        return this.bRq;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031055) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bdW = jSONObject.optLong("left_scores");
            this.bdX = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.bRq = com.baidu.live.yuyingift.a.a.ak(optJSONObject);
            }
        }
    }
}
