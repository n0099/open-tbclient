package com.baidu.live.yuyingift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YuyinAlaGiftSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.yuyingift.a.a bUQ;
    private long bgl;
    private long bgm;
    private long mLogId;

    public YuyinAlaGiftSendHttpResponseMessage() {
        super(1031055);
        this.bgl = 0L;
    }

    public long KK() {
        return this.bgl;
    }

    public long KL() {
        return this.bgm;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public com.baidu.live.yuyingift.a.a Zv() {
        return this.bUQ;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031055) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bgl = jSONObject.optLong("left_scores");
            this.bgm = jSONObject.optLong("tdou_num");
            this.mLogId = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject("system_luck_window");
            if (optJSONObject != null) {
                this.bUQ = com.baidu.live.yuyingift.a.a.ag(optJSONObject);
            }
        }
    }
}
