package com.baidu.live.yuyingift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YuyinAlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.yuyingift.a.a bPG;
    private long bcl;
    private long bcm;
    private long mLogId;

    public YuyinAlaGiftSendHttpResponseMessage() {
        super(1031055);
        this.bcl = 0L;
    }

    public long IK() {
        return this.bcl;
    }

    public long IL() {
        return this.bcm;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.yuyingift.a.a WW() {
        return this.bPG;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031055) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bcl = jSONObject.optLong("left_scores");
            this.bcm = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.bPG = com.baidu.live.yuyingift.a.a.ae(optJSONObject);
            }
        }
    }
}
