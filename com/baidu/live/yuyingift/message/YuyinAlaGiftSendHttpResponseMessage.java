package com.baidu.live.yuyingift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YuyinAlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.yuyingift.a.a bLI;
    private long bcD;
    private long bcE;
    private long mLogId;

    public YuyinAlaGiftSendHttpResponseMessage() {
        super(1031055);
        this.bcD = 0L;
    }

    public long IS() {
        return this.bcD;
    }

    public long IT() {
        return this.bcE;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.yuyingift.a.a Vg() {
        return this.bLI;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031055) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bcD = jSONObject.optLong("left_scores");
            this.bcE = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.bLI = com.baidu.live.yuyingift.a.a.ae(optJSONObject);
            }
        }
    }
}
