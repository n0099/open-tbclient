package com.baidu.live.guess.http;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GuessUploadAnswerResponseMessage extends JsonHttpResponsedMessage {
    private String msg;
    private int status;

    public GuessUploadAnswerResponseMessage() {
        super(1021218);
        this.msg = "";
        this.status = 0;
    }

    public int getStatus() {
        return this.status;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (BdLog.isDebugMode()) {
            BdLog.e("GuessVoucher:  " + jSONObject.toString());
        }
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.status = optJSONObject.optInt("status", 0);
                this.msg = optJSONObject.optString("msg", "");
            } else if (jSONObject.has(BaseJsonData.TAG_ERRNO) && jSONObject.has(BaseJsonData.TAG_ERRMSG)) {
                setError(-1);
                setErrorString(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
            }
        }
    }
}
