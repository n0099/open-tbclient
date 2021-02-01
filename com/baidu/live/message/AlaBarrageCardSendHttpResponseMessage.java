package com.baidu.live.message;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaBarrageCardSendHttpResponseMessage extends JsonHttpResponsedMessage {
    public int mErrorCode;
    public String mErrorMsg;

    public AlaBarrageCardSendHttpResponseMessage() {
        super(1021235);
        this.mErrorCode = 0;
        this.mErrorMsg = "恭喜您获得弹幕卡";
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            parseJson(jSONObject);
        }
    }

    private void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR)) != null) {
            this.mErrorCode = optJSONObject.optInt(BaseJsonData.TAG_ERRNO);
            this.mErrorMsg = optJSONObject.optString("usermsg");
            if (TextUtils.isEmpty(this.mErrorMsg)) {
                this.mErrorMsg = optJSONObject.optString(BaseJsonData.TAG_ERRMSG);
            }
            setError(this.mErrorCode);
            setErrorString(this.mErrorMsg);
        }
    }
}
