package com.baidu.live.guess.http;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GuessVoucherHttpResponseMessage extends JsonHttpResponsedMessage {
    private boolean bjS;
    private String bjT;
    private int doubleTicketNumber;
    private boolean isFollow;
    private int voucherNum;

    public GuessVoucherHttpResponseMessage() {
        super(1021215);
        this.bjS = false;
        this.voucherNum = 0;
        this.isFollow = false;
        this.doubleTicketNumber = 0;
        this.bjT = "";
    }

    public int getVoucherNum() {
        return this.voucherNum;
    }

    public boolean isFollow() {
        return this.isFollow;
    }

    public String getTaskUrl() {
        return this.bjT;
    }

    public int getDoubleTicketNumber() {
        return this.doubleTicketNumber;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.voucherNum = optJSONObject.optInt("total_quiz_ticket", 0);
                this.isFollow = optJSONObject.optInt("is_follow") != 0;
                this.bjT = optJSONObject.optString("task_url");
                this.doubleTicketNumber = optJSONObject.optInt("double_coupon_num");
                this.bjS = this.voucherNum > 0;
            } else if (jSONObject.has(BaseJsonData.TAG_ERRNO) && jSONObject.has(BaseJsonData.TAG_ERRMSG)) {
                setError(-1);
                setErrorString(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
            }
        }
    }
}
